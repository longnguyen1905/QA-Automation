package projects.market_place.pages;

import org.openqa.selenium.By;

import static keywords.Keyword.*;

public class MarketPlacePage {

    private By logo = By.xpath("//img[@alt='potslotty market place logo']");
    private By loginButton = By.xpath("//span[normalize-space()='Login']");
    private By switchLanguage = By.id("switches-language-button");
    private By loginPopupTitle = By.xpath("//*[contains(text(),'Log in')]");
    private By loginPopupText = By.xpath("//*[contains(text(),'Login using a linked')]");
    private By loginTelegramSection = By.cssSelector("#login-container");
    private By loginTelegramPhone = By.cssSelector("#login-phone");
    private By loginTelegram = By.cssSelector("#telegram-login-button");
    private By loginLine = By.cssSelector("#line-login-button");
    private By loginLineSection = By.xpath("//form[@action='/oauth2/v2.1/authenticate']");
    private By loginLineLogo = By.cssSelector(".mdLogo01Img");
    private By loginMailOTP = By.cssSelector("#otp-login-button");
    private By enterYourEmail = By.xpath("//*[contains(text(),'Enter your email')]");
    private By emailField = By.cssSelector("#email");
    private By sendEmailButton = By.cssSelector("#submit-send-email");
    private By otpCodeField = By.xpath("(//input[@autocomplete='one-time-code'])[1]");
    private By checkYourEmailTitle = By.xpath("//*[contains(text(),'OTP Verification')]");
    private By loginEmailButton = By.cssSelector("#submit-code-otp");
    private By walletIcon = By.xpath("//img[@alt='wallet icon']");
    private By invalidEmailErrorMessage = By.xpath("//*[contains(text(),'Email is invalid')]");
    private By alertErrorMessage = By.xpath("//div[@aria-live='polite']");


    public void verifyLogoDisplay(){
        verifyElementVisible(logo);
    }
    public void clickSwitchLanguage(){
        clickElement(switchLanguage);
    }
    public void clickLoginButton(){
        clickElement(loginButton);
    }
    public void verifyLoginPopup(){
        switchToWindow(1,2);
        verifyURLContainText("https://lobby.tpotslotty.cc/en/sso/");
        verifyElementVisible(loginPopupTitle);
        verifyElementVisible(loginPopupText);
    }
    public void clickLoginTelegram(){
        clickElement(loginTelegram);
    }
    public void clickLoginLine(){
        clickElement(loginLine);
    }
    public void verifyTelegramLoginPopup(){
        switchToWindow(2, 3);
        verifyURLContainText("https://oauth.telegram.org/");
        verifyElementVisible(loginTelegramSection);
        verifyElementVisible(loginTelegramPhone);
    }
    public void verifyLineLoginPopup(){
        waitForPageLoaded();
        verifyURLContainText("https://access.line.me/oauth");
        verifyElementVisible(loginLineLogo);
        verifyElementVisible(loginLineSection);
    }
    public void clickLoginMailOTP(){
        clickElement(loginMailOTP);
        verifyElementVisible(enterYourEmail);
    }
    public void enterEmail(String email){
        setText(emailField, email);
    }
    public void clickSendEmailButton(){
        clickElement(sendEmailButton);
    }
    public void verifySendEmailButtonDisable(){
        verifyElementDisable(sendEmailButton);
    }
    public void verifySendEmailButtonEnable(){
        verifyElementEnable(sendEmailButton, "Send Email button is disable");
    }
    public void enterOTPCode(){
        verifyElementVisible(checkYourEmailTitle);
        setText(otpCodeField, "000000");
    }
    public void verifyLoginEmailButtonDisable(){
        verifyElementDisable(loginEmailButton);
    }
    public void verifyLoginEmailButtonEnable(){
        verifyElementEnable(loginEmailButton, "Login button is disable");
    }
    public void clickLoginEmailButton(){
        clickElement(loginEmailButton);
    }
    public void verifyWalletIconVisible(){
        verifyElementVisible(walletIcon);
    }
    public void openNewPotslottyTab(String url){
        openNewUrlTab(url);
        switchToWindow(1,2);
    }
    public void verifyInvalidEmailError(String errorMessage){
        verifyElementVisible(invalidEmailErrorMessage);
        verifyContainText(invalidEmailErrorMessage, errorMessage);
    }
    public void verifyAlertErrorMessage(String errorMessage){
        verifyElementVisible(alertErrorMessage);
        verifyContainText(alertErrorMessage, errorMessage);
    }
    public void openNewMarketplaceTab(String url){
        openNewUrlTab(url);
        switchToWindow(1,2);
    }
}
