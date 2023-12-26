package projects.potslotty.testcases.commons;

import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import projects.commons.BaseTest;
import projects.potslotty.pages.CommonPage;
import projects.potslotty.pages.TournamentPage;


@Epic("Test Tournament Page")
public class Tournament extends BaseTest {
    private CommonPage commonPage;
    private TournamentPage tournamentPage;

    public Tournament(){
        commonPage = new CommonPage();
        tournamentPage = new TournamentPage();
    }
    @Test(description = "User can see module paid out")
    public void userCanSeeModulePaidOut() {
        commonPage.clickTournaments();
        tournamentPage.userSeePayoutSection("Paid out prize in 30 days");
    }
    @Test(description = "User can see dropdown list filter")
    public void userCanSeeDropdownListFilter() {
        tournamentPage.clickDropdownList();
        tournamentPage.userCanSeeTheDropdownListOptions();
    }
    @Test(description = "User can filter by daily tournaments")
    public void userCanFilterByDailyTournaments() {
        tournamentPage.clickDropdownList();
        tournamentPage.clickDaily();
        tournamentPage.userOnlySeeDailyTournaments();
    }
    @Test(description = "User can filter by weekly tournaments")
    public void userCanFilterByWeeklyTournaments() {
        tournamentPage.clickDropdownList();
        tournamentPage.clickWeekly();
        tournamentPage.userOnlySeeWeeklyTournaments();
    }
    @Test(description = "User can filter by monthly tournaments")
    public void userCanFilterByMonthlyTournaments() {
        tournamentPage.clickDropdownList();
        tournamentPage.clickMonthly();
        tournamentPage.userOnlySeeMonthlyTournaments();
    }
    @Test(description = "User can see details tournament from banner")
    public void userCancanSeeDetailsTournamentFromBanner() {
        commonPage.clickTournaments();
        tournamentPage.clickExclamationMarkIconBanner();
        tournamentPage.userCanSeeTournamentDetails();
    }
    @Test(description = "User can see details first tournament")
    public void userCanSeeDetailsFirstTournament() {
        tournamentPage.clickFirstTournament();
        tournamentPage.userCanSeeInformationTournament(1);
    }
    @Test(description = "User can see prize pool of tournament")
    public void userCanSeePrizePoolOfTournament() {
        tournamentPage.clickFirstTournament();
        tournamentPage.userCanSeePrizePoolDetail(1);

    }
    @Test(description = "User can see leader board of tournament")
    public void userCanSeeLeaderBoardOfTournament() {
        tournamentPage.clickFirstTournament();
        tournamentPage.userCanSeeTopPlayer(1);
        tournamentPage.userCanSeeDetailLeaderBoard(1);
    }
}
