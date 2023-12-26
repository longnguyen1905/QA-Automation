package projects.potslotty.testcases.commons;


import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import projects.commons.BaseTest;
import projects.potslotty.pages.*;

@Epic("Test Header")
public class Header extends BaseTest {
    private CommonPage commonPage;
    private GamePage gamePage;
    private TournamentPage tournamentPage;
    private ResultsPage resultsPage;
    private UpcomingPage upcomingPage;
    private EarnPage earnPage;
    private DepositPage depositPage;
    private SearchPage searchPage;
    private TermAndConPage termAndConPage;
    private Header(){
        commonPage = new CommonPage();
        gamePage = new GamePage();
        tournamentPage = new TournamentPage();
        resultsPage = new ResultsPage();
        upcomingPage = new UpcomingPage();
        earnPage = new EarnPage();
        depositPage = new DepositPage();
        searchPage = new SearchPage();
        termAndConPage = new TermAndConPage();
    }

    @Test(description = "User can navigate to tournament page")
    public void userCanNavigateToTournamentPage() {
        commonPage.clickTournaments();
        tournamentPage.userCanSeeTheTournamentsList();
    }
    @Test(description = "User can navigate to results page")
    public void userCanNavigateToResultsPage() {
        commonPage.clickResults();
        resultsPage.userCanSeeAllResultsLabel();
        resultsPage.userCanSeeEndingTournaments();
    }
    @Test(description = "User can navigate to upcoming page")
    public void userCanNavigateToUpcomingPage() {
        commonPage.clickUpcoming();
        upcomingPage.userCanSeeUpcomingTitle();
    }
    @Test(description = "User can navigate to earn page")
    public void userCanNavigateToEarnPage() {
        commonPage.clickEarn();
        earnPage.userCanSeeEarnTitle();
    }
    @Test(description = "User can navigate to games page")
    public void userCanNavigateToGamesPage() {
        commonPage.switchToTonWallet();
        commonPage.clickGamePage();
        gamePage.userCanSeeBanner();
    }
    @Test(description = "User can navigate to deposit page")
    public void userCanNavigateToDepositPage() {
        commonPage.switchToTonWallet();
        commonPage.clickOnDeposit();
        depositPage.userCanSeeDepositSection();
    }
    @Test(description = "User can navigate to search page")
    public void userCanNavigateToSearchPage() {
        commonPage.clickGamePage();
        commonPage.clickOnSearchIcon();
        searchPage.userCanSeeSearchInput();
    }
    @Test(description = "User can see pop up profile")
    public void userCanSeePopUpProfile() {
        commonPage.clickAvatar();
        commonPage.verifyDisplayedPopUpProfile();
    }
    @Test(description = "User can navigate to term and condition page")
    public void userCanNavigateToTermAndConditionPage() {
        commonPage.clickOnTermAndCondition();
        termAndConPage.userWillBeRedirectedToTermAndConditionPage();
    }
    @Test(description = "User can  can see footer")
    public void userCanSeFooter() {
        commonPage.userCanSeeFooter();
    }
}

