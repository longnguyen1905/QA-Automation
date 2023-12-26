package projects.potslotty.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static keywords.Keyword.*;


public class CommonPage {
    public By potSlottyLogo = By.xpath("//img[@alt='logo']");
    public By tournaments = By.cssSelector("#tournaments-link-header");
    public By results = By.cssSelector("#results-link-header");
    public By games = By.cssSelector("#games-link-header");
    public By upcoming = By.cssSelector("#upcoming-link-header");
    public By earn = By.cssSelector("#earn-link-header");
    public By selectLanguage = By.cssSelector(".font-medium button");
    public By loginButton = By.xpath("//span[contains(text(),'Login')]");
    public By letsGoButton = By.cssSelector("#welcome-button");
    public By depositButtonHeader = By.cssSelector("#deposit-button-on-header");
    public By switchWallet = By.cssSelector("#switches-currency-on-header");
    public By searchButton = By.xpath("//img[contains(@alt,'icon_search')]");
    public By avatar = By.xpath("//img[@alt='avatar']");
    public By selectMYR = By.cssSelector("#MYR-currency");
    public By selectTON = By.cssSelector("#TON-currency");
    public By selectVND = By.cssSelector("#VND-currency");
    public By selectUSDT = By.cssSelector("#USDT-currency");
    public By selectBNB = By.cssSelector("#BNB-currency");
    public By selectIDR = By.cssSelector("#IDR-currency");
    public By selectPHP = By.cssSelector("#PHP-currency");
    public By componentCurrency = By.cssSelector(".overflow-y-auto");
    public By componentLanguage = By.cssSelector(".overflow-y-auto");
    public By reserved = By.cssSelector(".mb-1.mt-4");
    public By termAndCon = By.xpath("//a[normalize-space()='Terms and Conditions']");
    public By support = By.cssSelector(".p-6 .cursor-pointer") ;
    public By english = By.xpath("//p[contains(text(),'English')]") ;
    public By ru = By.xpath("//*[contains(text(),'Русский')]") ;
    public By china = By.xpath("//*[contains(text(),'简体中文')]") ;
    public By hongKong = By.xpath("//*[contains(text(),'香港')]") ;
    public By vie = By.xpath("//*[contains(text(),'Tiếng Việt')]") ;
    public By thai = By.xpath("//*[contains(text(),'ไทย')]") ;
    public By malaysia = By.xpath("//*[contains(text(),'Malaysia')]") ;
    public By indonesia = By.xpath("//*[contains(text(),'Indonesia')]") ;
    public By cambodia = By.xpath("//*[contains(text(),'ភាសាខ្មែរ')]") ;
    public By Currency = By.cssSelector(".overflow-y-auto .justify-between ");
    public By tournamentRu = By.xpath("//*[contains(text(),'Турниры')]");
    public By tournamentId = By.xpath("//*[contains(text(),'Turnamen')]");
    public By tournamentCN = By.xpath("//*[contains(text(),'锦标赛')]");
    public By tournamentTh = By.xpath("//*[contains(text(),'การแข่งขัน')]");
    public By tournamentMs = By.xpath("//*[contains(text(),'Kejohanan')]");
    public By tournamentVie = By.xpath("//*[contains(text(),'Giải đấu')]");
    public By componentTransaction = By.cssSelector(".mt-5");
    private By popupProfile =  By.cssSelector(".modal-profile-box");
    private By account =  By.cssSelector(".modal-profile-box .btndefault");
    private By signOut =  By.cssSelector(".modal-profile-box .signout_btn");
    private By displayNameAtPopUp =  By.cssSelector(".modal-profile-box h2");
    private By goldAmount =  By.cssSelector(".modal-profile-box .w-full div.flex.items-center");

    public void clickLetsGoButton(){
        clickElement(letsGoButton);
    }
    public LoginPage clickLoginButton(){
        clickElement(loginButton);
        return new LoginPage();
    }
    @Step("Click on Game Page")
    public GamePage clickGamePage(){
        clickElement(games);
        return new GamePage();
    }
    public GamePage clickPotSlottyLogo(){
        clickElement(potSlottyLogo);
        return new GamePage();
    }

    @Step("Click on tournament")
    public TournamentPage clickTournaments(){
        clickElement(tournaments);
        return new TournamentPage();
    }

    @Step("Click on Results")
    public ResultsPage clickResults(){
        clickElement(tournaments);
        clickElement(results);
        return new ResultsPage();
    }

    @Step("User click on upcoming")
    public UpcomingPage clickUpcoming(){
        clickTournaments();
        clickElement(upcoming);
        sleep(1);
        return new UpcomingPage();
    }

    @Step("Click on Earn button")
    public EarnPage clickEarn(){
        clickElement(earn);
        return new EarnPage();
    }
    public DepositPage clickDepositButtonHeader(){
        clickElement(depositButtonHeader);
        return new DepositPage();
    }
    public ProfilePage clickAvatar(){
        clickElement(avatar);
        sleep(1);
        return new ProfilePage();
    }


    public void clickSwitchWallet(){
        waitForElementClickable(switchWallet);
        clickElement(switchWallet);
        waitForElementPresent(componentCurrency);
    }
    public void clickSelectMYR(){
        clickElement(selectMYR);
        sleep(2);
    }
    @Step("User switch currency to TON")
    public void switchToTonWallet(){
        clickElement(switchWallet);
        clickElement(selectTON);
        sleep(2);
    }
    public void switchToVNDWallet(){
        clickElement(switchWallet);
        clickElement(selectVND);
    }
    public void switchToUSDTWallet(){
        clickElement(switchWallet);
        clickElement(selectUSDT);
        sleep(2);
    }
    public void clickSwitchLanguage(){
        waitForElementClickable(selectLanguage);
        clickElement(selectLanguage);
        waitForElementPresent(componentLanguage);
    }
    public void switchToRussian(){
        clickSwitchLanguage();
        clickElement(ru);
        waitForElementVisible(tournamentRu);
    }
    public void switchToChina(){
        clickSwitchLanguage();
        clickElement(china);
        waitForElementVisible(tournamentCN);
    }
    public void switchToHongKong(){
        clickSwitchLanguage();
        clickElement(hongKong);
        waitForElementVisible(tournamentCN);
    }
    public void switchToVietNam(){
        clickSwitchLanguage();
        clickElement(vie);
        waitForElementVisible(tournamentVie);
    }
    public void switchToThaiLan(){
        clickSwitchLanguage();
        clickElement(thai);
        waitForElementVisible(tournamentTh);
    }
    public void switchToMalaysia(){
        clickSwitchLanguage();
        clickElement(malaysia);
        waitForElementVisible(tournamentMs);
    }
    public void switchToIndonesia(){
        clickSwitchLanguage();
        clickElement(indonesia);
        waitForElementVisible(tournamentId);
    }
    public void switchToCambodia(){
        clickSwitchLanguage();
        clickElement(cambodia);
    }

    public int getCurrentBalance(){
        return Integer.parseInt(getElementText(switchWallet));
    }

    public  ProfilePage clickOnProfile(){
        clickElement(avatar);
        waitForElementVisible(componentTransaction);
        return new ProfilePage();
    }
    @Step("User click on term and condition")
    public  TermAndConPage clickOnTermAndCondition(){
        clickElement(termAndCon);
        return new TermAndConPage();
    }
    @Step("User click on deposit")
    public  DepositPage clickOnDeposit(){
        clickElement(depositButtonHeader);
        return new DepositPage();
    }
    @Step("User click on search")
    public  SearchPage clickOnSearchIcon(){
        clickElement(searchButton);
        waitForPageLoaded();
        return new SearchPage();
    }
    public void clickAccount(){
        clickElement(account);
    }
    public void verifyDisplayedHeader(String textLink) {
        switch (textLink) {
            case "tournament":
                verifyElementDisplayed(tournaments, "Tournaments is not displayed ");
                break;
            case "results":
                clickElement(tournaments);
                verifyElementDisplayed(results, "Results is not displayed ");
                break;
            case "upcoming":
                clickElement(tournaments);
                verifyElementDisplayed(upcoming, "Upcoming is not displayed ");
                break;
            case "earn":
                verifyElementDisplayed(earn, "Earn is not displayed ");
                break;
            case "profile":
                verifyElementDisplayed(avatar, "Profile is not displayed ");
                break;
            case "games":
                verifyElementDisplayed(games, "Game is not displayed ");
                break;
            case "search":
                verifyElementDisplayed(searchButton, "Search is not displayed ");
                break;
            case "deposit":
                verifyElementDisplayed(depositButtonHeader, "Deposit is not displayed ");
                break;
            case "currency":
                verifyElementDisplayed(switchWallet, "Deposit is not displayed ");
                break;
        }
    }

    public void verifyInvisibleHeader(String textLink) {
        switch (textLink) {
            case "games":
                verifyElementInvisible(games, "Game is displayed ");
                break;
            case "search":
                verifyElementInvisible(searchButton, "Search is displayed ");
                break;
            case "deposit":
                verifyElementInvisible(depositButtonHeader, "Deposit is displayed ");
                break;
            case "tournament":
                verifyElementInvisible(tournaments, "Tournaments is displayed ");
                break;
            case "results":
                clickElement(tournaments);
                verifyElementInvisible(results, "Results is displayed ");
                break;
            case "upcoming":
                clickElement(tournaments);
                verifyElementInvisible(upcoming, "Upcoming is displayed ");
                break;
            case "earn":
                verifyElementInvisible(earn, "Earn is displayed ");
                break;
            case "profile":
                verifyElementInvisible(avatar, "Profile is displayed ");
                break;
        }
    }

    public void verifyDisplayedListHeader(String country) {
        List<String> listHeader = getDataForLocale(country, "listHeader");
        for (String linkHeader : listHeader) {
            verifyDisplayedHeader(linkHeader);
        }
    }

    public void verifyInvisibleListHeader(String country) {
        List<String> listHeaderNotExist = getDataForLocale(country, "listHeaderNotExist");
        for (String linkHeader : listHeaderNotExist) {
            verifyInvisibleHeader(linkHeader);
        }
    }

    public void verifyCurrency(String country) {
        List<String> listCurrency = getDataForLocale(country, "listCurrency");
        clickSwitchWallet();
        List<String> listCurrencyActual = getListName(Currency);
        System.out.println(listCurrency+ "---------with------"+listCurrencyActual);
        verifyEquals(checkEqualList(listCurrency, listCurrencyActual), true);
        verifyListDisplayed(Currency);
    }

    public List<String> allCurrency = List.of("USDT", "TON", "BNB", "IDR", "MYR", "THB");

    public void verifyCurrencyNotDisplayed(String country) {
        List<String> listCurrencyNotExist = getDataForLocale(country, "listCurrencyNotExist");
        clickSwitchWallet();
        List<String> listCurrencyActual = getListDifferent(allCurrency, getListName(Currency));
        System.out.println(listCurrencyNotExist+ "---------with------"+listCurrencyActual);
        verifyEquals(checkEqualList(listCurrencyNotExist, listCurrencyActual), true);
    }

    public String checkDisplayed(By by) {
        if (getWebElement(by).isDisplayed() == true) {
        }
        return null;
    }
    public void verifyLoginButtonInvisible(){
        verifyElementInvisible(loginButton);
    }
    @Step("User can see pop up profile")
    public void verifyDisplayedPopUpProfile(){
        waitForElementVisible(goldAmount);
        verifyElementDisplayed(popupProfile, "Pop up profile is not displayed");
        verifyElementDisplayed(displayNameAtPopUp, "Display name is not displayed");
        verifyElementDisplayed(goldAmount, "Gold amount is not displayed");
        verifyElementEnable(signOut, "Sign out is disable");
        verifyElementEnable(account, "Account is disable");
    }
    @Step("User can see footer")
    public void userCanSeeFooter(){
        verifyContainText(reserved,"All rights Reserved");
        verifyContainText(termAndCon,"Terms and Conditions");
        verifyContainText(support,"Support");
    }
}
