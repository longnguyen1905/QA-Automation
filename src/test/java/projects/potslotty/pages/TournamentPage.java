package projects.potslotty.pages;

import constants.ConstantGlobal;
import io.qameta.allure.Step;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static keywords.Keyword.*;

public class TournamentPage {
    private By payoutTotal = By.xpath("//span[@class='pp-count-widget__value']");
    private By titlePage = By.xpath("//h2");
    private By payoutIcon = By.xpath("//span[@class='pp-count-widget__icon icon-payout']");
    private By payoutLabel = By.xpath("//span[@class='pp-count-widget__label']");
    private By tournamentDropdownList = By.cssSelector("#dropdown-basic");
    private By tournamentWidget = By.cssSelector("#ppTournamentWidgetContainer");
    private By daily = By.xpath("//span[normalize-space()='Daily']");
    private By weekly = By.xpath("//span[normalize-space()='Weekly Qualifier']");
    private By monthly = By.xpath("//span[normalize-space()='Monthly']");
    private By dailyTournaments = By.xpath("//span[normalize-space()='Daily']");
    private By weeklyTournaments = By.xpath("//span[normalize-space()='Weekly Qualifier']");
    private By monthlyTournaments = By.xpath("//span[normalize-space()='Monthly']");
    private By exclamationMarkIconBanner = By.xpath("(//span[@class='pp-mtournament-widget_card-info-button text-white'])[3]");
    private By information = By.xpath("(//div[@class='pp-tournaments-ext-info !block !bg-[#1d1c22]'])[1]");
    private By prizePool = By.xpath("(//div[@class='pp-tournaments-ext-prizepool !bg-[#1d1c22]'])[1]");
    private By leaderboard = By.xpath("(//div[@class='pp-tournaments-ext-leaderboard max-h-[500px] !bg-[#1d1c22]'])[1]");
    private By firstTournament = By.xpath("(//div[@class='pp-tournaments-item-wrapper collapsed'])[1]");
    private By listPrize = By.xpath("(//div[@class='pp-tournaments-ext !p-5'])[1]//span[@class='pp-tournaments-ext-prizepool_block-cash_item-value ml-2']");
    private By totalPrize = By.xpath("(//span[@class='pp-tournaments-ext_card-titlebar_sub'])[1]");

    private String iconTop2 = "(//img[contains(@alt,'crown_silver')])";
    private String imgTop2 = "(//img[contains(@alt,'top2')])";
    private String iconTop3 = "(//img[contains(@alt,'crown_bronze')])";
    private String imgTop3 = "(//img[contains(@alt,'top3')])";
    private String reloadRanking = "(//span[@title='Reload rankings'])";
    private String switchPreviousPage = "(//button[@class='btnprev mr-2 !bg-gradient-to-b !from-[#797A7D] !to-[#545C63]'])";
    private String switchNextPage = "(//button[contains(@class,'btnprev mr-2 !bg-gradient-to-b !from-[#797A7D] !to-[#545C63]')])";
    private String iconTop1 ="(//img[contains(@alt,'crown_gold')])";
    private String imgTop1 ="(//img[contains(@alt,'top1')])";
    private String noDataLeaderboard = "(//p[normalize-space()='No Data'])";
    //private String listPrize ="(//div[@class='pp-tournaments-ext !p-5'])"+"["+index+"]//span[@class='pp-tournaments-ext-prizepool_block-cash_item-value ml-2']";
    private String informationTournament ="(//span[normalize-space()='Information'])";
    private String prizePoolTournament ="(//span[normalize-space()='Prize Pool'])";
    private String leaderboardTournament ="(//span[normalize-space()='Leaderboard'])";
    private String getInformationType ="(//span[normalize-space()='Type'])";
    private String getInformationStartTime ="(//span[normalize-space()='Start Time'])";
    private String getInformationEndTime ="(//span[normalize-space()='End Time'])";
    private String getInformationBalance ="(//span[normalize-space()='Balance'])";
    private String getInformationCost = "(//span[normalize-space()='Cost'])";
    private String getInformationRejoinLimit = "(//span[normalize-space()='Rejoin Limit'])";
    private String detailTournament ="(//div[contains(@class,'pp-tournaments-item flex flex-col justify-between')])";
    private By listTournament = By.xpath("(//div[contains(@class,'pp-tournaments-item flex flex-col justify-between')])");
    public By listGameTournament = By.cssSelector(".accordion .flex .text-ellipsis-2");


    @Step("User select daily")
    public void clickDaily(){
        clickElement(daily);
    }
    @Step("User select weekly")
    public void clickWeekly(){
        clickElement(weekly);
    }
    @Step("User select Monthly")
    public void clickMonthly(){
        clickElement(monthly);
    }
    @Step("User click on First Tournament")
    public void clickFirstTournament(){
        clickElement(firstTournament);
        sleep(2);
    }
    @Step("User click Exclamation Mark Icon Banner")
    public void clickExclamationMarkIconBanner(){
        clickElement(exclamationMarkIconBanner);
    }
    @Step("User can see tournament page")
    public void userCanSeeTheTournamentsList(){
        verifyElementVisible(tournamentDropdownList);
//        verifyURL(ConstantGlobal.URL_TOURNAMENT);
    }
    public void userMustNotSeeAnyCurrenciesExceptTON(){
        Assert.assertTrue(getElementText(payoutTotal).contains("TON"));
    }
    public void userMustNotSeeAnyCurrenciesExceptMYR(){
        Assert.assertTrue(getElementText(payoutTotal).contains("MYR"));
    }
    public void userMustNotSeeAnyCurrenciesExceptVND(){
        Assert.assertTrue(getElementText(payoutTotal).contains("VND"));
    }
    @Step("user See Pay out Section")
    public void userSeePayoutSection(String s){
        verifyElementVisible(payoutIcon);
        verifyElementVisible(payoutTotal);
        verifyEquals(s, getElementText(payoutLabel), "label not match");
    }
    @Step("User click on dropdown list filter")
    public void clickDropdownList(){
        clickElement(tournamentDropdownList);
    }
    @Step("User can sse list option filter")
    public void userCanSeeTheDropdownListOptions(){
        verifyElementVisible(daily);
        verifyElementVisible(weekly);
        verifyElementVisible(monthly);
    }
    @Step("user Only See Daily Tournaments")
    public void userOnlySeeDailyTournaments(){
        verifyElementVisible(dailyTournaments);
        verifyElementNotDisplayed(weeklyTournaments);
        verifyElementNotDisplayed(monthlyTournaments);
    }
    @Step("user Only See Monthly Tournaments")
    public void userOnlySeeMonthlyTournaments(){
        verifyElementNotDisplayed(dailyTournaments);
        verifyElementNotDisplayed(weeklyTournaments);
        verifyElementVisible(monthlyTournaments);
    }
    @Step("user Only See Weekly Tournaments")
    public void userOnlySeeWeeklyTournaments(){
        verifyElementNotDisplayed(dailyTournaments);
        verifyElementVisible(weeklyTournaments);
        verifyElementNotDisplayed(monthlyTournaments);
    }
    @Step("user Can See Tournament Details")
    public void userCanSeeTournamentDetails(){
        verifyElementVisible(information);
        verifyElementVisible(prizePool);
        verifyElementVisible(leaderboard);
    }
    @Step("user Can See Prize Pool Detail")
    public void userCanSeePrizePoolDetail(int index) {
        verifyContainText(prizePoolTournament ,index  ,"Prize Pool");
//        verifyContainText(totalPrize,"TON");
//        List<WebElement> elements = getWebElements(listPrize);
//        for (WebElement element : elements) {
//            Assert.assertTrue(element.getText().contains("TON"));
//        }
    }
    @Step("user Can See Each Detail Tournament")
    public void userCanSeeEachDetailTournament () {
        waitForElementPresent(listTournament);
        List<WebElement> elements = getWebElements(listTournament);
        String currentTitle = getElementText(titlePage);
        if ( currentTitle.equals("UPCOMING")==true) {
            for (int i = 1; i <= elements.size(); i++) {
                userCanSeeDetailTournamentUpcoming(i);
            }
        }
        else{
            for (int i = 1; i <= elements.size(); i++) {
                userCanSeeFullDetailTournament(i);
            }
        }
    }
    public void userCanSeeBoardDetailTournament(int index){
        verifyContainText(informationTournament,index,"Information");
        verifyContainText(prizePoolTournament,index,"Prize Pool");
        verifyContainText(leaderboardTournament,index,"Leaderboard");
    }
    @Step("user Can See Information of {0} Tournament")
    public void userCanSeeInformationTournament(int index){
        verifyContainText(getInformationStartTime,index,"Start Time");
        verifyContainText(getInformationType,index,"Type");
        verifyContainText(getInformationBalance,index,"Balance");
        verifyContainText(getInformationEndTime,index,"End Time");
        verifyContainText(getInformationCost,index,"Cost");
        verifyContainText(getInformationRejoinLimit,index,"Rejoin Limit");
    }
    @Step("user Can See Detail Leader Board")
    public void userCanSeeDetailLeaderBoard(int index){
        verifyElementVisible(reloadRanking,index);
        verifyElementVisible(switchPreviousPage,index);
        verifyElementVisible(switchNextPage,index);
    }
    @Step("user Can See Top Player")
    public void userCanSeeTopPlayer(int index){
        List<String> stringList = new ArrayList<>(List.of(iconTop1,imgTop1 ,iconTop2,imgTop2,iconTop3,imgTop3 ));
        verifyListElementVisible(stringList,index);
    }
    public void userNotSeeTopPlayer(int index){
        verifyElementVisible(noDataLeaderboard, index);

    }
    public void userCanSeeFullDetailTournament(int index){
        clickElement(detailTournament,index);
        userCanSeeBoardDetailTournament(index);
        userCanSeeInformationTournament(index);
        userCanSeeDetailLeaderBoard(index);
        userCanSeeTopPlayer(index);
    }
    public void userCanSeeDetailTournamentUpcoming(int index){
        clickElement(detailTournament,index);
        userCanSeeBoardDetailTournament(index);
        userCanSeeInformationTournament(index);
        userCanSeeDetailLeaderBoard(index);
        userNotSeeTopPlayer(index);
    }
    public void detectLanguage(String locale){
        String bodyTexts = getPageBodyText();
        List<String> listGameName = getTextListElements(listGameTournament);
        List<String> bodyTextsList = replaceTexts(bodyTexts, listGameName,locale);
        detectLanguagePage(locale, bodyTextsList);
    }
}