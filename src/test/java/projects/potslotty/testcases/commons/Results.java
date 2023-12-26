package projects.potslotty.testcases.commons;

import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import projects.potslotty.pages.CommonPage;
import projects.potslotty.pages.ResultsPage;
import projects.commons.BaseTest;


@Epic("Test Results Page")
public class Results extends BaseTest {
    private CommonPage commonPage;
    private ResultsPage resultsPage;
    private Results(){
        commonPage = new CommonPage();
        resultsPage = new ResultsPage();
    }

    @Test(description = "User can see all results")
    public void userCanSeeAllResults() {
        commonPage.clickResults();
        resultsPage.userCanSeeAllResultsLabel();
        resultsPage.userCanSeeEndingTournaments();
    }

    @Test(description = "User can see details first results")
    public void userCanSeeDetailFirstResults() {
        commonPage.clickResults();
        resultsPage.userCanSeeDetailFirstResults();
    }

}

