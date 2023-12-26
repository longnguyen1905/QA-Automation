package projects.credit_system.pages;

import keywords.Keyword;
import org.openqa.selenium.By;

import static keywords.Keyword.*;

public class LoginPage {
    private By loginTitle = By.cssSelector(".flex.justify-between.items-center p");
    private By languageDropdown = By.cssSelector(".dropdown_lang.text-left.flex.items-center.justify-between.flex-row");
    private By languageEnglish = By.cssSelector(".dropdown_lang_popup.flex.flex-col li:first-child");
    private By languageChinese = By.cssSelector(".dropdown_lang_popup.flex.flex-col li:nth-child(2)");
    private By usernameInput = By.cssSelector("input[placeholder='Username']");
    private By passwordInput = By.cssSelector("input[placeholder='Password']");
    private By loginButton = By.cssSelector(".flex.justify-center > button");
    private By incorrectInformationErrorMessage = By.cssSelector(".flex.flex-col.justify-center.w-full > p");

    public void selectLanguageEnglish(){
        clickElement(languageDropdown);
        clickElement(languageEnglish);
    }
    public void selectLanguageChinese(){
        clickElement(languageDropdown);
        clickElement(languageChinese);
    }
    public void loginCreditSystem(String username, String password){
        setText(usernameInput, username);
        setText(passwordInput, password);
        clickElement(loginButton);
    }

    public void verifyIncorrectInformationErrorMessage(){
        verifyElementVisible(incorrectInformationErrorMessage);
        verifyEqualText(incorrectInformationErrorMessage, "You have entered incorrect login information. Please note that your account will be locked if you enter the wrong login information at 5 times!");
    }


}
