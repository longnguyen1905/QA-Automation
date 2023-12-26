package projects.commons;

import api.commons.send_report.AuthPotslotty;
import com.google.common.collect.ImmutableMap;
import constants.ConstantGlobal;
import drivers.DriverManager;
import helpers.StorageHelper;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import projects.potslotty.pages.CommonPage;
import reports.AllureManager;
import utils.LogUtils;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static keywords.Keyword.openURL;

@Listeners(TestListener.class)
public class BaseTest {
    CommonPage commonPage = new CommonPage();
//    @BeforeMethod
//    @Parameters({"BROWSER"})
//    public void createDriver(@Optional("chrome") String browserName) {
//        BasePage.createDriver();
////        Keyword.openURL(ConstantGlobal.URL);
//    }
    @BeforeMethod
    public void setDriver(){
        BasePage.createDriver();
        StorageHelper storageHelper = new StorageHelper();
        openURL(ConstantGlobal.URL);
        storageHelper.loginByToken();
        commonPage.clickLetsGoButton();
    }
    @AfterMethod
    public void teardown(ITestResult result){
            if (result.isSuccess() != true) {
                AllureManager.saveScreenshotPNG();
            }
        BasePage.closeDriver();
    }
    @BeforeSuite
    public static void beforeAll() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Environment", ConstantGlobal.ENV.toUpperCase())
                        .put("Browser", "Chrome")
                        .build(),
                System.getProperty("user.dir") + "/target/allure-results/");
        AuthPotslotty.createToken();
    }

}
