package helpers;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.LogUtils;

import java.util.ArrayList;

import static keywords.Keyword.*;

public class VpnHelper {
    private final String extension_Protocol = "chrome-extension";
    private final String extension_ID = "eppiocemhmnlbhjplcgkofciiegomcon";
    private final String indexPage = extension_Protocol + "://" + extension_ID + "/popup/index.html";
    private By agreeButton = By.xpath("//button[@class='button_pink agreement_agree']");
    private By searchCountry = By.xpath("//input[@type='text']");
    private By countryName = By.xpath("//span[@class='pl-2.5']");
    private By country(String locale){
        return By.xpath("//*[contains(text(),'" + locale + "')]");
    }

    public void setAndCheckVPN(String locale){
        LogUtils.info("Set up Urban VPN... ");
        sleep(2);
        openURL(indexPage);
        waitForPageLoaded();
        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(0));

        clickElement(agreeButton);
        clickElement(agreeButton);
        clickElement(searchCountry);
        System.out.println(country(locale));
        scrollToElement(country(locale));
        clickElement(country(locale));
        sleep(5);
        LogUtils.info("Verify VPN is working or not ...");
        DriverManager.getDriver().switchTo().window(tabs.get(0));
        openURL("https://checkip.com.vn/");
        waitForElementVisible(countryName);
        Assert.assertTrue(getWebElement(countryName).getText().contains(locale));
        LogUtils.info("VPN is working");
    }
}
