package projects.potslotty.pages;

import constants.ConstantGlobal;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static keywords.Keyword.*;

public class TermAndConPage {
    private By titleTermAndCondition = By.xpath("//h2[normalize-space()='PotSlotty']");
    @Step("User can see term and condition page")
    public void userWillBeRedirectedToTermAndConditionPage(){
        verifyElementVisible(titleTermAndCondition);
        verifyURL(ConstantGlobal.URL_TERM_AND_CONDITION);
    }
    public void detectLanguage(String locale){
        String bodyTexts = getPageBodyText();
        List<String> bodyTextsList = replaceTexts(bodyTexts,locale);
        detectLanguagePage(locale, bodyTextsList);
    }
}
