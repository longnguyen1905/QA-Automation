package projects.potslotty.pages;
import constants.ConstantGlobal;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import keywords.Keyword;

import java.util.List;

import static keywords.Keyword.*;
import static keywords.Keyword.verifyElementVisible;


public class UpcomingPage extends TournamentPage {
    private By titleUpcoming = By.xpath("//h2[normalize-space()='Upcoming']");
    private  By statusTournament = By.xpath("//span[contains(text(),'STARTS IN')]");
    private  By allUpcoming = By.xpath("//div[@id='ppTournamentWidgetContainer']");
    private By listGameTournament = By.cssSelector(".accordion .flex .text-ellipsis-2");


    @Step("User can see upcoming page")
    public void userCanSeeUpcomingTitle(){
        Keyword.verifyElementVisible(titleUpcoming);
        Keyword.verifyContainText(titleUpcoming,"UPCOMING");
        verifyURL(ConstantGlobal.URL_UPCOMING);
    }
    @Step("user Can See All Upcoming Label")
    public void userCanSeeAllUpcomingLabel(){
        verifyElementVisible(allUpcoming);
    }

    @Step("user Can See Upcoming Tournaments")
    public void userCanSeeUpcomingTournaments(){
//        DepositPage depositPage = new DepositPage();
//        verifyElementDisable(depositPage.depositButton);
        verifyURL(ConstantGlobal.URL_UPCOMING);
    }

    @Step("user Can See Detail First Upcoming")
    public void userCanSeeDetailFirstUpcoming(){
        clickFirstTournament();
        userCanSeeInformationTournament(1);
        userCanSeePrizePoolDetail(1);
    }
    public void detectLanguage(String locale){
        String bodyTexts = getPageBodyText();
        List<String> listGameName = getTextListElements(listGameTournament);
        List<String> bodyTextsList = replaceTexts(bodyTexts, listGameName,locale);
        detectLanguagePage(locale, bodyTextsList);
    }

}
