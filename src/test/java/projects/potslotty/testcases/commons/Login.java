package projects.potslotty.testcases.commons;

import constants.ConstantGlobal;
import helpers.StorageHelper;
import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projects.commons.BasePage;
import projects.commons.BaseTest;
import projects.potslotty.pages.CommonPage;
import projects.potslotty.pages.LoginPage;


import static keywords.Keyword.openURL;
import static projects.commons.BasePage.createDriver;

@Epic("Login without referral")
public class Login extends BaseTest {
    private CommonPage commonPage;
    private LoginPage loginPage;
    private StorageHelper storageHelper;

    public Login(){
        commonPage = new CommonPage();
        loginPage = new LoginPage();
    }
    @BeforeMethod
    public void setDriver(){
        BasePage.createDriver();
        openURL(ConstantGlobal.URL);
        commonPage.clickLetsGoButton();
        commonPage.clickLoginButton();
    }
    @Test(description = "Log in with Mail OTP - Valid email")
    public void logInWithValidEmail() {
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("longuyen@alphanetworks.global");
        loginPage.clickSendButton();
        loginPage.userCanSeePopUpInputOTP();
        loginPage.userCanSeeCheckYourEmailLabel();
    }
    @Test(description = "Log in with Mail OTP - Invalid email")
    public void logInWithInvalidEmail() {
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("longuyen");
        loginPage.clickSendButton();
        loginPage.userCanSeeErrorMessage("Email is invalid");
        loginPage.checkSendButtonDisable();
    }
    @Test(description = "Log in with Mail OTP - Wrong format email")
    public void logInWithWrongFormatEmail() {
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("testmail@.mail.c");
        loginPage.clickSendButton();
        loginPage.userCanSeePopUpError("Invalid email. Please check again");
    }
    @Test(description = "Log in with Mail OTP - Empty email")
    public void logInWithEmptyEmail() {
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("");
        loginPage.checkSendButtonDisable();
    }
    @Test(description = "Log in with Mail OTP - Valid OTP")
    public void logInWithInvalidOTP() {
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("longuyen@alphanetworks.global");
        loginPage.userInputOTP("123456");
        loginPage.clickLoginButton();
        loginPage.userCanSeePopUpError("OTP code is invalid");
    }
    @Test(description = "Log in with Mail OTP - Empty OTP")
    public void logInWithEmptyOTP() {
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("longuyen@alphanetworks.global");
        loginPage.userInputOTP("");
        loginPage.checkLoginButtonDisable();
    }
    @Test(description = "Log in with Mail OTP - Resend status disable within 60 sec")
    public void checkStatusResendButton() {
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("longuyen@alphanetworks.global");
        loginPage.clickSendButton();
        loginPage.userCanSeeCheckYourEmailLabel();
        loginPage.checkCountDownEnable();
    }
    @Test(description = "Log in with Line")
    public void LogInWithLine() {
        loginPage.clickContinueWithLine();
        loginPage.userCanSeeLineLabelAndLineCorporation();
        loginPage.userNavigateToURLLineUrlThatContainsPotslotty();
    }

}
