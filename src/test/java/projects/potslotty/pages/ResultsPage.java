package projects.potslotty.pages;
import constants.ConstantGlobal;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static keywords.Keyword.*;

public class ResultsPage extends TournamentPage{
    private By allResultsLabel = By.xpath("//h2[normalize-space()='All Results']");
    private By endingTournaments = By.xpath("//div[@class='col-12']");
    private By listGameTournament = By.cssSelector(".accordion .flex .text-ellipsis-2");
    private By componentResults = By.xpath("//div[contains(@class,'container px-3')]");

    @Step("Verify title results page")
    public void userCanSeeAllResultsLabel(){
        verifyElementVisible(allResultsLabel);
    }
    @Step("Verify navigate results page")
    public void userCanSeeEndingTournaments(){
        verifyElementVisible(endingTournaments);
        verifyURL(ConstantGlobal.URL_RESULTS);
    }

    @Step("Verify detail first results")
    public void userCanSeeDetailFirstResults(){
        clickFirstTournament();
        userCanSeeInformationTournament(1);
        userCanSeePrizePoolDetail(1);
        userCanSeeDetailLeaderBoard(1);
    }
    public void detectLanguage(String locale){
        waitForElementVisible(componentResults);
        String bodyTexts = getPageBodyText();
        List<String> listGameName = getTextListElements(listGameTournament);
        List<String> bodyTextsList = replaceTexts(bodyTexts, listGameName,locale);
        detectLanguagePage(locale, bodyTextsList);
    }
}
