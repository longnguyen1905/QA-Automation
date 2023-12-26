package helpers;

import constants.ConstantGlobal;
import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtils;

import java.time.Duration;
import java.util.ArrayList;

import static keywords.Keyword.*;

public class WalletHelper {
    private WebDriverWait wait;
    private By metaMaskPassword= By.xpath("//input[@type='password']");
    private By metaMaskUnLockButton = By.xpath("//button[@role='button']");
    private By metaMaskTransferUrl = By.xpath("//div[@class='site-origin confirm-page-container-summary__origin']");
    private By metaMaskTransferAmount = By.xpath("//h1[@class='mm-box mm-text mm-text--display-md mm-text--font-weight-normal mm-text--ellipsis mm-box--color-text-default']");
    private By metaMaskButtons = By.xpath("//button[@class='icon-button eth-overview__button']");
    private By metaMaskRejectButton = By.xpath("//button[normalize-space()='Reject']");
    private By metaMaskConfirmButton = By.xpath("//button[normalize-space()='Confirm']");
    private By trustWalletPassword = By.xpath("//input[@type='password']");
    private By trustWalletUnLockButton = By.xpath("//button[@type='submit']");
    private By trustWalletTransferUrl = By.xpath("(//p[@class='body-text text-textPrimary font-medium   text-unset'])[1]");
    private By trustWalletTransferAmount = By.xpath("(//p[@class='body-text text-textPrimary font-medium   text-unset'])[3]");
    private By trustWalletButtons = By.xpath("//div[@class='css-pw1m0c']");
    private By trustWalletRejectButton = By.cssSelector(".default-button .title-text ");
    private By trustWalletConfirmButton = By.xpath("//*[contains(text(),'Confirm')]");
    private By maticText = By.xpath("//*[contains(text(),'MATIC')]");

    public void setupMetaMask(){
        LogUtils.info("Login meta mask ...");
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConstantGlobal.EXPLICIT_TIMEOUT), Duration.ofSeconds(5));
        openURL("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html");
        setText(metaMaskPassword, "Social123");
        clickElement(metaMaskUnLockButton);
        waitForElementVisible(maticText);
    }
    public void setupTrustWallet(){
        LogUtils.info("Login trust wallet ...");
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConstantGlobal.EXPLICIT_TIMEOUT), Duration.ofSeconds(5));
        openURL("chrome-extension://egjidjbpglichdcondbcbdnbeeppgdph/home.html");
        setText(trustWalletPassword, "Social123@");
        clickElement(trustWalletUnLockButton);
        waitForElementVisible(maticText);
    }
    public void verifyMetaMaksDepositSuccess(){
        LogUtils.info("Verify Meta Mask transaction info ...");
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConstantGlobal.EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(1));
        sleep(3);
        waitForPageLoaded();
        verifyEquals(getElementText(metaMaskTransferUrl), ConstantGlobal.URL.substring(0, ConstantGlobal.URL.length() - 4));
        verifyEquals(getElementText(metaMaskTransferAmount), "0.01 USDT");
        verifyElementClickable(metaMaskConfirmButton);
        clickElement(metaMaskRejectButton);
    }
    public void verifyTrustWalletsDepositSuccess(){
        LogUtils.info("Verify Trust Wallet transaction info ...");
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConstantGlobal.EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(1));
        sleep(3);
        waitForPageLoaded();
        verifyEquals(getElementText(trustWalletTransferUrl), ConstantGlobal.URL.substring(0, ConstantGlobal.URL.length() - 4));
        verifyContainText(trustWalletTransferAmount, "MATIC");
        verifyElementClickable(trustWalletConfirmButton);
    }
    public void rejectTrustWallet(){
        clickElement(trustWalletRejectButton);
        sleep(1);
        switchToWindow(0,1);
        verifyURL(ConstantGlobal.URL_DEPOSIT);
    }
}
