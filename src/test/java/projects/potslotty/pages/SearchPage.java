package projects.potslotty.pages;

import constants.ConstantGlobal;
import io.qameta.allure.Step;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LogUtils;

import java.util.List;

import static keywords.Keyword.*;

public class SearchPage {
    private By searchInput = By.xpath("//input[contains(@type,'text')]");
    private By btnExit = By.xpath("//div[contains(@class,'filter-box relative rounded-lg border border-[#f5e544]')]//a");
    private By publisher = By.xpath("//button[contains(@class,'py-2 pr-3 text-lg')]");
    private By listPublisher = By.xpath("//button[contains(@class,'py-2 pr-3 text-lg')]");
    private By PGSoft = By.xpath("//span[normalize-space()='PG Soft']");
    private By pragmatic = By.xpath("//span[normalize-space()='Pragmatic']");
    private By nameListGame = By.xpath("//p[@class='heading-3  w-full  text-ellipsis px-2 text-center text-white sm:text-xl lg:text-lg']");
    @Step("User can see search page")
    public void userCanSeeSearchInput(){
        Keyword.verifyElementVisible(searchInput);
        verifyURL(ConstantGlobal.URL_SEARCH);
    }
    @Step("Click on drop down list publisher")
    public void clickDropDownListPublisher(){
        clickElement(publisher);
    }
    @Step("Verify search all for default")
    public void userCanSeeDefaultSearchAll(){
        verifyContainText(publisher, "All");
    }
    @Step("User can see list publisher")
    public void userCanSeeListPublisher(){
        List<WebElement> publishers = getWebElements(listPublisher);
        verifyEquals(publishers.size()>1,true);
    }
    public void userDoNotSeeAnyResults(){
        List<WebElement> listGame = getWebElements(nameListGame);
        verifyEquals(listGame.size()<1,true);
    }
    @Step("User can search by PG Soft")
    public void searchByPGSoft(){
        clickDropDownListPublisher();
        clickElement(PGSoft);
    }
    @Step("User can search by PG Soft")
    public void userCanSeeListGamePGSoft(){
        searchByPGSoft();
        verifyContainText(publisher, "PG Soft");
    }
    public void searchByPragmatic(){
        clickDropDownListPublisher();
        clickElement(pragmatic);
    }
    @Step("User can search by Pragmatic")
    public void userCanSeeListGamePragmatic(){
        searchByPragmatic();
        verifyContainText(publisher, "Pragmatic");
    }
    public void inputSearchKey(String searchKey){
        clickElement(searchInput);
        setText(searchInput, searchKey);
    }
    @Step("Verify Search input default blank")
    public void userCanSeeSearchInputBlank(){
        verifyEquals(getElementText(searchInput), "");
    }
    public void userCanSeeListGameHaveContentName (String name) {
        List<WebElement> listNameOfGame = getWebElements(nameListGame);
        verifyEquals(listNameOfGame.size()>=1,true );
        for (WebElement nameOfGame : listNameOfGame) {
            verifyContainTextLowerCase(nameOfGame, name.toLowerCase());
        }
    }
    public void clearText(){
        getWebElement(searchInput).clear();
    }
    public void clickExitSearch(){
        clickElement(btnExit);
    }
    public void detectLanguage(String locale){
        String bodyTexts = getPageBodyText();
        List<String> listGameName = getTextListElements(nameListGame);
        List<String> bodyTextsList = replaceTexts(bodyTexts, listGameName,locale);
        detectLanguagePage(locale, bodyTextsList);
    }
}
