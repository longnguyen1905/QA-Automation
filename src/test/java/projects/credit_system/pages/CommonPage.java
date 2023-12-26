package projects.credit_system.pages;

import keywords.Keyword;
import org.openqa.selenium.By;

import static keywords.Keyword.clickElement;

public class CommonPage {
    public By mainLogo = By.xpath("//img[@alt='Main Logo']");
    public By toggleMenuIcon = By.xpath("//img[@alt='Toggle Menu Icon']");
    public By homeIcon = By.xpath("//img[@alt='Home Icon']");
    public By timerIcon = By.xpath("//img[@alt='Timer Icon']");
    public By timeHeader = By.cssSelector(".ml-2");
    public By announcementsIcon = By.xpath("//img[@alt='Announcements Icon']");
    public By languageDropdown = By.xpath("//div[@class='dropdown_lang text-left flex items-center justify-between flex-row px-[8px] cursor-pointer']");
    public By languageEnglish = By.cssSelector(".absolute.mt-1.flex.z-50.block li:nth-child(1)");
    public By languageChina = By.cssSelector(".absolute.mt-1.flex.z-50.block li:nth-child(2)");
    public By avatarUser = By.xpath("//img[@alt='avatar user']");
    public By userProfileBtn = By.cssSelector(".relative div p:nth-child(1)");
    public By accountManagementIcon = By.xpath("//img[@alt='acc_management icon']");
    public By accountManagementMenuBtn = By.xpath("//a[@title='Account Management']");
    public By agentListMenuBtn = By.xpath("//a[@title='Agent list']");
    public By playerListMenuBtn = By.xpath("//a[@title='Player list']");
    public By createAgentMenuBtn = By.xpath("//a[@title='Create agent']");
    public By createPlayerMenuBtn = By.xpath("//a[@title='Create player']");
    public By reportMenuBtn = By.xpath("//a[@title='Report']");
    public By winLoseMenuBtn = By.xpath("//a[@title='Win lose']");
    public By playerStatementMenuBtn = By.xpath("//a[@title='player statement']");
    public By changePasswordBtn = By.xpath("//*[contains(text(),'Change password')]");
    public By logOutBtn = By.xpath("//*[contains(text(),'Logout')]");

    public HomePage clickMainLogo(){
        clickElement(mainLogo);
        return new HomePage();
    }
    public void clickToggleMenuIcon(){
        clickElement(toggleMenuIcon);
    }
    public HomePage clickHomeIcon(){
        clickElement(homeIcon);
        return new HomePage();
    }
    public void clickAccountManagementMenuBtn(){
        clickElement(accountManagementMenuBtn);
    }
    public AgentListPage clickAgentListMenuBtn(){
        clickElement(agentListMenuBtn);
        return new AgentListPage();
    }
    public PlayerListPage clickPlayerListMenuBtn(){
        clickElement(playerListMenuBtn);
        return new PlayerListPage();
    }
    public CreateAgentPage clickCreateAgentMenuBtn(){
        clickElement(createAgentMenuBtn);
        return new CreateAgentPage();
    }
    public CreatePlayerPage clickCreatePlayerMenuBtn(){
        clickElement(createPlayerMenuBtn);
        return new CreatePlayerPage();
    }
    public void clickReportMenuBtn(){
        clickElement(reportMenuBtn);
    }
    public WinLosepage clickWinLoseMenuBtn(){
        clickElement(winLoseMenuBtn);
        return new WinLosepage();
    }
    public PlayerStatement clickPlayerStatementMenuBtn(){
        clickElement(playerStatementMenuBtn);
        return new PlayerStatement();
    }
    public void clickLanguageDropdown(){
        clickElement(languageDropdown);
    }
    public void selectLanguageEnglish(){
        clickElement(languageDropdown);
        clickElement(languageEnglish);
    }
    public void selectLanguageChina(){
        clickElement(languageDropdown);
        clickElement(languageChina);
    }
    public void clickUserProfileBtn(){
        clickElement(userProfileBtn);
    }
    public void clickChangePassword(){
        clickElement(changePasswordBtn);
    }
    public LoginPage clickLogout(){
        clickElement(logOutBtn);
        return new LoginPage();
    }
}
