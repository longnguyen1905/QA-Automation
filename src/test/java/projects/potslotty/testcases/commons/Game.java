package projects.potslotty.testcases.commons;


import io.qameta.allure.Epic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import projects.commons.BaseTest;
import projects.potslotty.pages.CommonPage;
import projects.potslotty.pages.GamePage;

@Epic("Test Game Page")
public class Game extends BaseTest {
    private CommonPage commonPage;
    private GamePage gamePage;
    private Game(){
        commonPage = new CommonPage();
        gamePage = new GamePage();
    }

    @BeforeMethod
    public void selectTon(){
        commonPage.switchToTonWallet();
    }
    @Test(description = "User can see banner")
    public void userCanBeeBanner() {
        commonPage.clickGamePage();
        gamePage.userCanSeeBanner();
    }
    @Test(description = "User can play first game")
    public void userCanPlayFirstGame() {
        commonPage.clickGamePage();
        gamePage.userClickFirstGame();
        gamePage.userCanPlayFirstGame();
    }
}
