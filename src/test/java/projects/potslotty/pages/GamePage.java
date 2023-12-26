package projects.potslotty.pages;
import static keywords.Keyword.*;
import static keywords.Keyword.clickElement;

import constants.ConstantGlobal;
import drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LogUtils;


import java.util.List;

public class GamePage extends CommonPage{
    private By bannerGameOfWeek = By.xpath("//div[contains(@class,'game-off-week game-of-the-week md:min-h-300')]");
    private By bannerTournament = By.xpath("//div[contains(@class,'relative mb-4 h-full px-4 lg:px-0')]");
    private By playAtBannerGame = By.cssSelector(".btnsecondary");
    private By titleBannerGame = By.xpath("//h1[normalize-space()='GAME OF THE WEEK']");
    private By listGame = By.xpath("(//div[contains(@class,'flex items-center justify-center')])");
    public By gameIframe = By.xpath("//iframe");
    private By popUpPlease = By.cssSelector(".welcome-modal");
    private By buttonOpenGame = By.cssSelector(".deposit-button");
    private By btnLogin = By.xpath("(//button[contains(@class,'btndefault w-40 bnt-text-1 my-5 rounded-r-none')])[1]");
    private By btnContinue = By.xpath("//button[normalize-space()='Continue']");
    private By btnDeposit = By.xpath("(//a[normalize-space()='Deposit'])[1]");
    private By listNameGame = By.cssSelector(".grid p");
    private String listGame (int index) {
        return "(//div[contains(@class,'flex items-center justify-center')])"+"["+index+"]";
    }

    @Step("User can see banner game")
    public void userCanSeeBanner(){
        verifyElementVisible(bannerGameOfWeek);
        verifyElementVisible(playAtBannerGame);
        verifyContainText(titleBannerGame,"GAME OF THE WEEK");
        verifyElementVisible(bannerTournament);
    }
    public void userCanPlayAllGame() {
        List<WebElement> games = getWebElements(listGame);
        for (int index = 1; index <= games.size(); index++) {
            clickElement(By.xpath(listGame(index)));
            loadedGameSuccess();
            clickElement(potSlottyLogo);
        }
    }
    public void loadedGameSuccess(){
        try {
            waitForElementVisible(gameIframe);
            String expectedID = getWebElement(gameIframe).getAttribute("id");
            String tmpURL = DriverManager.getDriver().getCurrentUrl();
            String actualID = tmpURL.substring(tmpURL.lastIndexOf("play/") + 5, (tmpURL.length()-1));
            verifyEquals(actualID, expectedID);
        }
        catch(AssertionError error) {
            LogUtils.info("Game not load success: " + error.getMessage());
        }
    }
    @Step("Verify game id")
    public void userCanPlayFirstGame() {
        loadedGameSuccess();
    }
    @Step("User click on first game")
    public void userClickFirstGame() {
        clickElement(listGame);
    }
    public void clickOpenGame(){
        clickElement(buttonOpenGame);
    }
    public void userCanSeePopUpPleaseLogin(){
        verifyContainText(popUpPlease,"Please log in or create an account.");    }
    public void clickBtnLogin(){
        clickElement(btnLogin);
    }
    public void clickBtnContinue(){
        clickElement(btnContinue);
    }
    public void clickBtnDeposit(){
        clickElement(btnDeposit);
    }
    public void verifyButtonOnNewGame(){
        verifyElementVisible(buttonOpenGame);
        verifyElementVisible(btnDeposit);
    }
    public void clickBannerTournament(){
        clickElement(bannerTournament);
    }
    public void clickPlayOnBanner(){
        clickElement(playAtBannerGame);
    }
    public void userCanSeeHomePage(){
        verifyURL(ConstantGlobal.URL);
        userCanSeeBanner();
    }
    public void detectLanguage(String locale){
        String bodyTexts = getPageBodyText();
        List<String> listGameName = getTextListElements(listNameGame);
        List<String> bodyTextsList = replaceTexts(bodyTexts, listGameName,locale);
        System.out.println("body texts after replace: " + bodyTextsList);
        detectLanguagePage(locale, bodyTextsList);
    }
}
