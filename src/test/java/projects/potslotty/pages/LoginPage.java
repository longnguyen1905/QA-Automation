package projects.potslotty.pages;
import constants.ConstantGlobal;
import drivers.DriverManager;
import io.qameta.allure.Step;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.testng.Assert;

import static keywords.Keyword.*;

public class LoginPage {
    private By mailOTPButton = By.cssSelector("#otp-login-button") ;
    private By emailField = By.cssSelector("#email") ;
    private By sendButton = By.cssSelector("#submit-send-email") ;

    private By checkYourEmailLabel = By.xpath("//h3[normalize-space()='OTP Verification']");
    private By otpPopup = By.xpath("//div[@class='opt-login']");
    private By errorMessage = By.xpath("//p[@class='mt-1 text-xs italic text-rose-600']");
    private By otpErrorMessage = By.cssSelector("[aria-live='polite']");
    private By otpField = By.cssSelector("#otp input");
    private By loginButton = By.cssSelector("#submit-code-otp");
    private By resendButton = By.xpath("//span[normalize-space()='Resend']");
    private By countDown = By.xpath("(//span[@class='mb-6 mt-2 text-sm text-[#f5e544]'])[1]");
    private By popupErrorMessage = By.xpath("(//div[@role='status'])[1]");
    private By openTelegramApp = By.cssSelector("#telegram-login-button") ;
    private By continueWithLine = By.cssSelector("#line-login-button");
    private By lineLabel = By.xpath("//h1[normalize-space()='LINE']");
    private By lineCorporation = By.xpath("//b[normalize-space()='LINE Corporation']");
    private By titleLogin = By.xpath("//h1[normalize-space()='Log in']");
    private By messageLogin = By.cssSelector(".box-light-login p");

    @Step("User click Login Button")
    public void clickLoginButton(){
        clickElement(loginButton);
    }
    @Step("User select login mail OTP")
    public void clickMailOTPButton(){
        clickElement(mailOTPButton);
    }
    @Step("User in put email {0}")
    public void inputEmail(String email){
        setText(emailField, email);
    }
    @Step("User click send button")
    public void clickSendButton(){
        clickElement(sendButton);
    }
    public void clickOpenTelegramApp(){
        clickElement(openTelegramApp);
    }
    public void clickContinueWithLine(){
        clickElement(continueWithLine);
    }
    @Step("user Can See Pop Up Input OTP")
    public void userCanSeePopUpInputOTP(){
        verifyElementVisible(otpPopup, "OTP pop up is not displayed");
    }
    public void inputOTP(String otp){
        setText(otpField, otp);
    }
    @Step("user Can See Check Your Email Label")
    public void userCanSeeCheckYourEmailLabel(){
        verifyElementVisible(checkYourEmailLabel, "OTP verification Label is not displayed");
    }
    @Step("user Can See Error Message")
    public void userCanSeeErrorMessage(String message){
        verifyElementVisible(errorMessage, "checkYourEmail Label is not displayed");
        verifyEquals(message, getElementText(errorMessage), "wrong error message");
    }
    @Step("user Can See Pop Up Error {0}")
    public void userCanSeePopUpError(String message){
        verifyElementVisible(otpErrorMessage, "OTP Error Message is not displayed");
        verifyEquals(message, getElementText(otpErrorMessage), "wrong error message");
    }
    @Step("check Send Button Disable")
    public void checkSendButtonDisable(){
        verifyElementDisable(sendButton, "Send button is enable");
    }
    @Step("check Login Button Disable")
    public void checkLoginButtonDisable(){
        verifyElementDisable(loginButton, "Send button is enable");
    }
    public void checkResendButtonDisable(){
        //verifyElementDisable(resendButton, "Resend button is enable");
        verifyElementDisable(resendButton, "Resend button is enable");
    }
    public void checkResendButtonEnable(){
        sleep(60);
        verifyElementVisible(resendButton, "Resend button is disable");
    }
    public void checkCountDownDisable(){
        verifyElementDisable(countDown, "Resend button is enable");
    }
    @Step("check Count Down Enable")
    public void checkCountDownEnable(){
        verifyElementVisible(countDown, "Resend button is disable");
    }
    public void userCanSeePopUpErrorMessage(String message){
        verifyElementVisible(popupErrorMessage, "pop up not display");
        verifyEquals(message, getElementText(popupErrorMessage), "message not match");
    }
    @Step("user Can See Line Label And Line Corporation")
    public void userCanSeeLineLabelAndLineCorporation(){
        verifyElementVisible(lineLabel, "line label not display");
//        verifyElementVisible(lineCorporation, "line corporation not display");
    }
    public void loginTestAccount(){
        CommonPage commonPage = new CommonPage();
        LoginPage loginPage = new LoginPage();
        commonPage.clickLetsGoButton();
        commonPage.clickLoginButton();
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("longuyen@alphanetworks.global");
        loginPage.clickSendButton();
        loginPage.inputOTP("000000");
        loginPage.clickLoginButton();
        Keyword.sleep(2);

    }
    public void verifyPopupLogin(){
        verifyContainText(titleLogin, "LOG IN");
        verifyContainText(messageLogin, "Login using a linked social account or a wallet!");
    }
    @Step("user Input OTP value: {0}")
    public void userInputOTP(String otp){
        clickSendButton();
        userCanSeeCheckYourEmailLabel();
        inputOTP(otp);
    }
    @Step("user Navigate To URL Line Url That Contains Potslotty")
    public void userNavigateToURLLineUrlThatContainsPotslotty(){
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("potslotty"));
    }
}
