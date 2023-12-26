package projects.potslotty.testcases.commons;

import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import projects.commons.BaseTest;
import projects.potslotty.pages.CommonPage;
import projects.potslotty.pages.UpcomingPage;


@Epic("Verify the UI and function of Tournament - Upcoming")
public class Upcoming extends BaseTest {
    private CommonPage commonPage;
    private UpcomingPage upcomingPage;

    public Upcoming() {
        commonPage = new CommonPage();
        upcomingPage = new UpcomingPage();
    }
    @Test(description = "user can see all upcoming tournament")
    public void userCanSeeAllUpcomingTournament() {
        commonPage.clickUpcoming();
        upcomingPage.userCanSeeAllUpcomingLabel();
        upcomingPage.userCanSeeUpcomingTournaments();
    }
    @Test(description = "user can see details first upcoming")
    public void userCanSeeDetailsFirstUpcoming() {
        commonPage.clickUpcoming();
        upcomingPage.userCanSeeDetailFirstUpcoming();
    }
    @Test(description = "user can see detail upcoming tournament")
    public void userCanSeeDetailUpcomingTournament() {
        commonPage.clickUpcoming();
        upcomingPage.userCanSeeEachDetailTournament();
    }
}

