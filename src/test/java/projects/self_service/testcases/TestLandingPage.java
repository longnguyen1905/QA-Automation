package projects.self_service.testcases;

import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import projects.commons.BaseTest;
import projects.self_service.pages.LandingPage;

@Epic("Epic 2")
public class TestLandingPage extends BaseTest {
    LandingPage landingPage = new LandingPage();
    @Test(description = "test ui of header")
    public void testUIHeader(){
        landingPage.openSS();
        landingPage.verifyDisplayedOfHeader();
    }
    @Test
    public void testUIHome(){
        landingPage.openSS();
        landingPage.verifyDisplayedOfHome();
    }
    @Test
    public void testUIFeature(){
        landingPage.openSS();
        landingPage.clickOnFeature();
        landingPage.verifyDisplayedOfFeature();
    }
    @Test
    public void testUIBackOffice(){
        landingPage.openSS();
        landingPage.clickOnBackOffice();
        landingPage.verifyDisplayedOfBackOffice();
    }
//    @Test
//    public void testUIVision(){
//        landingPage.openSS();
//        landingPage.clickOnVision();
//        landingPage.verifyDisplayedOfVision();
//    }
//    @Test
//    public void testUIGameCataLog(){
//        landingPage.openSS();
//        landingPage.clickOnGameCatalog();
//        landingPage.verifyDisplayedOfGameCatalog();
//    }
//    @Test
//    public void testUIGamePackage(){
//        landingPage.openSS();
//        landingPage.clickOnGamePackage();
//        landingPage.verifyDisplayedOfGamePackage();
//    }

}
