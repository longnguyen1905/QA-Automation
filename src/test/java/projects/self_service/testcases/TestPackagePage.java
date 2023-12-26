package projects.self_service.testcases;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import projects.commons.BaseTest;
import projects.commons.TestListener;
import projects.self_service.pages.LandingPage;
import projects.self_service.pages.PackagePage;


@Epic("This is epic")
@Feature(" this is feature")

public class TestPackagePage extends BaseTest {
    LandingPage landingPage = new LandingPage();
    PackagePage packagePage = new PackagePage();

    @Test(description="test add on")
    public void testUIAddOnFeature(){
        landingPage.openSS();
        landingPage.clickOnGetStartStandard();
        packagePage.verifyDisplayedOfAddonPage();
    }
    @Test(description="test your plan")
    public void testUISectionYourPlan(){
        landingPage.openSS();
        landingPage.clickOnGetStartStandard();
        packagePage.verifyDisplayedOfYourPlanSection();
    }
    @Test(description="test add on list")
    public void testUISectionAddOnList(){
        landingPage.openSS();
        landingPage.clickOnGetStartStandard();
        packagePage.verifyDisplayedOfAddOnListSection();
    }
    @Test(description="test add on btn back ))")
    public void testBtnBack() {
        landingPage.openSS();
        landingPage.clickOnGetStartStandard();
        packagePage.clickBtnNext();
        packagePage.clickBtnBack();
        packagePage.verifyDisplayedOfAddonPage();
    }
//    @Test
//    public void testInputForm(){
//        landingPage.openSS();
//        landingPage.clickOnGetStartStandard();
//        packagePage.clickBtnNext();
//        packagePage.inputFormInformation();
//        packagePage.verifyStatusBtnSocialConnect();
//    }
//    @Test
//    public void testSocialConnect(){
//        landingPage.openSSProfile();
//        landingPage.clickOnGetStartStandard();
//        packagePage.clickBtnNext();
//        packagePage.inputFormInformation();
//        packagePage.clickBtnSocialConnect();
//        packagePage.verifyDisplayedConfirmPage();
//    }
//    @Test
//    public void testCreateTicket(){
//        landingPage.openSSProfile();
//        landingPage.clickOnGetStartStandard();
//        packagePage.clickBtnNext();
//        packagePage.inputFormInformation();
//        packagePage.clickBtnSocialConnect();
//        packagePage.verifyDisplayedConfirmPage();
//        packagePage.clickBtnSocialConnect();
//        packagePage.verifyDisplayedThanksPage();
//    }
//    @Test
//    public void testBtnBackAfterConnectSocial(){
//        landingPage.openSSProfile();
//        landingPage.clickOnGetStartStandard();
//        packagePage.clickBtnNext();
//        packagePage.inputFormInformation();
//        packagePage.clickBtnSocialConnect();
//        packagePage.clickBtnBack();
//        packagePage.verifyDisplayedOfSubmitPage();
//    }
//    @Test
//    public void verifyConnectSocialTele(){
//        landingPage.openSS();
//        landingPage.clickOnGetStartStandard();
//        packagePage.clickBtnNext();
//        packagePage.inputFormInformation();
//        packagePage.clickBtnSocialConnect();
//        packagePage.verifyWindowLoginTelegram();
//    }
}
