package projects.potslotty.pages;

import constants.ConstantGlobal;
import io.qameta.allure.Step;
import keywords.Keyword;
import org.openqa.selenium.By;
import static keywords.Keyword.*;
import static keywords.Keyword.verifyURL;

import constants.ConstantGlobal;
import drivers.DriverManager;
import keywords.Keyword;
import org.openqa.selenium.By;

import java.util.List;

import static keywords.Keyword.*;

public class EarnPage {
    private By yourReferralTitle = By.xpath("//h2[normalize-space()='Your Referral']");
    private By referralQRCode = By.xpath("//*[name()='path' and contains(@d,'M 0 0 l 1 ')]");
    private By referralUrl = By.xpath("//span[contains(text(),'lobby.tpotslotty.cc/?start=')]");
    private By telegramIcon = By.xpath("//img[contains(@alt,'telegram icon')]");
    private By facebookIcon = By.xpath("//img[@alt='facebook icon']");
    private By shareIcon = By.xpath("//img[@alt='share icon']");

    public void verifyQRCodeDisplay(){
        verifyElementVisible(referralQRCode);
    }
    @Step("Verify displayed referral code")
    public void userCanSeeReferralCode(){
        verifyElementVisible(yourReferralTitle);
        verifyElementVisible(referralQRCode);
        verifyElementVisible(referralUrl);
        verifyContainText(referralUrl, "lobby.tpotslotty.cc/?start=");
        verifyContainText(yourReferralTitle,"YOUR REFERRAL");

    }
    @Step("Verify displayed icon social")
    public void verifySocialIconDisplay(){
        verifyElementVisible(telegramIcon);
        verifyElementVisible(facebookIcon);
        verifyElementVisible(shareIcon);
    }
    @Step("Click on telegram icon")
    public void clickTelegramIcon(){
        clickElement(telegramIcon);
    }
    @Step("Click on Facebook icon")
    public void clickFacebookIcon(){
        clickElement(facebookIcon);
    }
    public void verifyTelegramPopup(){
        verifyEquals(getCurrentUrlNewTab(), ConstantGlobal.URL_REFERRAL_TELE);
    }
    public void verifyFacebookPopup(){
        verifyEquals(getCurrentUrlNewTab(), ConstantGlobal.URL_REFERRAL_FB);
    }
    private By titleEarn = By.xpath("//h2[normalize-space()='Your Referral']");
    @Step("User can see earn page")
    public void userCanSeeEarnTitle(){
        Keyword.verifyElementVisible(titleEarn);
        Keyword.verifyContainText(titleEarn,"YOUR REFERRAL");
        verifyURL(ConstantGlobal.URL_EARN);
    }
    public void detectLanguage(String locale){
        waitForElementVisible(referralQRCode);
        String bodyTexts = getPageBodyText();
        List<String> bodyTextsList = replaceTexts(bodyTexts,locale);
        detectLanguagePage(locale, bodyTextsList);
    }
}
