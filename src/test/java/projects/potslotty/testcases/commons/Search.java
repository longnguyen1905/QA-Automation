package projects.potslotty.testcases.commons;

import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projects.commons.BaseTest;
import projects.potslotty.pages.CommonPage;
import projects.potslotty.pages.GamePage;
import projects.potslotty.pages.SearchPage;


@Epic("Test Search Page")
public class Search extends BaseTest {
    private SearchPage searchPage;
    private CommonPage commonPage;
    private GamePage gamePage;

    public Search() {
        searchPage = new SearchPage();
        commonPage = new CommonPage();
        gamePage = new GamePage();
    }
    @BeforeMethod
    public void gotoSearchPage(){
        commonPage.switchToTonWallet();
        commonPage.clickGamePage();
        commonPage.clickOnSearchIcon();
    }
    @Test(description = "User leave blank input search")
    public void userLeaveBlankInputSearch() {
        searchPage.userCanSeeSearchInputBlank();
    }
    @Test(description = "User can see default search all game publisher")
    public void userCanSeeDefaultSearchAllGamePublisher() {
        searchPage.userCanSeeDefaultSearchAll();
    }
    @Test(description = "User can see dropdown list game publisher")
    public void userCanSeeDropdownListGamePublisher() {
        searchPage.clickDropDownListPublisher();
        searchPage.userCanSeeListPublisher();
    }
    @Test(description = "User can search by PGSoft")
    public void userCanSearchByPGSoft() {
        searchPage.userCanSeeListGamePGSoft();
    }
    @Test(description = "User can search by Pragmatic")
    public void userCanSearchByPragmatic() {
        searchPage.userCanSeeListGamePragmatic();
    }
    @Test(description = "User can search with key have no results")
    public void userCanSearchƯithKeyHaveNoResults() {
        searchPage.inputSearchKey("Dra123");
        searchPage.userDoNotSeeAnyResults();
    }
}