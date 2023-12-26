package projects.credit_system.pages;

import org.openqa.selenium.By;

public class AgentListPage {
    private By firstBreadcrumbs = By.cssSelector(".main-content.w-full.pt-5 a");
    private By secondBreadcrumbs = By.cssSelector(".flex.items-center.whitespace-nowrap li");
    private By thirdBreadcrumbs = By.cssSelector(".main-content.w-full.pt-5 div:nth-child(4)");
    private By fourthBreadcrumbs = By.cssSelector(".main-content.w-full.pt-5 div:nth-child(5)");
    private By reloadButton = By.cssSelector(".flex.w-full.lg\\:flex-row.flex-col button");
    private By searchInput = By.cssSelector("input[placeholder='--']");
    private By searchIcon = By.cssSelector("img[alt='Search icon']");
    private By dataFromTable(int row, int column){
        return By.cssSelector(".mt-4 tbody tr:nth-child(" + row + ") td:nth-child(" + column + ")");
    }


}
