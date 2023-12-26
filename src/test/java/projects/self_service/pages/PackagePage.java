package projects.self_service.pages;

import drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static keywords.Keyword.*;

public class PackagePage {
    private By titlePage = By.cssSelector(".flex-col.text-center");
    private By sectionYourPlan = By.cssSelector(".overflow-y-auto");
    private By yourPlan = By.cssSelector(" .overflow-y-auto div>p:nth-child(1)");
    private By namePackage = By.cssSelector(" .overflow-y-auto span:nth-child(2) p");
    private By price = By.cssSelector(" .overflow-y-auto span:nth-child(3) p");
    private By sectionAddonList = By.cssSelector(".add_on_list_bg");
    private By btnSkip = By.cssSelector("button.flex");
    private By btnNext = By.cssSelector(".btn_package");
    private By addFeature = By.cssSelector(".add_on_list_bg .cursor-pointer:nth-child(1)");
    private By firstName = By.cssSelector("input[name='firstname']");
    private By lastName = By.cssSelector("input[name='lastname']");
    private By phone = By.cssSelector("input[name='phone']");
    private By email = By.cssSelector("input[name='email']");
    private By message = By.cssSelector("textarea");
    private By checkBoxAgree = By.cssSelector("input[type='checkbox']");
    private By btnBack = By.cssSelector("button[type='button']");
    private By btnOkay = By.cssSelector(".btn_package.mt-7");
    private By btnSocialConnect = By.cssSelector("button[type='submit']");
    private By messageThank = By.cssSelector(".text-center .text-lg");

    public void inputFirstName(String value){
        setText(firstName,value);
    }
    public void inputLastName(String value){
        setText(lastName,value);
    }
    public void inputContactNumber(String value){
        setText(phone,value);
    }
    public void inputEmail(String value){
        setText(email,value);
    }
    public void inputMessage(String value){
        setText(message,value);
    }
    public void setCheckBoxAgree(){
        clickElement(checkBoxAgree);
    }
    public void clickBtnNext(){
        clickElement(btnNext);
        sleep(2);
    }
    public void clickBtnBack(){
        clickElement(btnBack);
        sleep(2);
        waitForPageLoaded();
    }
    public void clickBtnSocialConnect(){
        scrollToElement(btnSocialConnect);
        clickElement(btnSocialConnect);
        sleep(2);
    }
    @Step("verify add on page")
    public void verifyDisplayedOfAddonPage(){
        verifyElementDisplayed(titlePage, "title page is not displayed");
        verifyEqualText(titlePage, "Choose Your ADD-ON FEATURE");
        verifyElementDisplayed(sectionAddonList, "Add on list is not displayed");
        verifyElementDisplayed(sectionYourPlan, "Section your plan is not displayed");
        verifyElementDisplayed(btnNext, "Next button is not displayed");
    }
    public void verifyDisplayedOfSubmitPage(){
        verifyEqualText(titlePage, "Submit INFORMATION");
//        more ...
    }

    public void verifyDisplayedOfYourPlanSection() {
    verifyElementDisplayed(yourPlan, "title section is not displayed");
    verifyElementDisplayed(namePackage, "name package is not displayed");
    verifyElementDisplayed(price, "price is not displayed");
    }

    public void verifyDisplayedOfAddOnListSection() {
        verifyElementDisplayed(addFeature, "Add feature is not displayed");
        verifyElementDisplayed(btnSkip,"Skip is not displayed");
    }
    public void inputFormInformation(){
        inputFirstName("tai");
        inputLastName("tran");
        inputContactNumber("12345467890");
        inputEmail("abc@bac.com");
        setCheckBoxAgree();
    }
    public void verifyStatusBtnSocialConnect(){
        verifyElementEnable(btnSocialConnect, "btn is disable");
    }
    public void verifyDisplayedConfirmPage(){
        verifyEqualText(titlePage, "Review YOUR REQUEST");
        verifyEqualText(btnSocialConnect, "CONFIRM");
    }
    public void verifyDisplayedThanksPage(){
        verifyEqualText(messageThank, "Thanks for entrusting us with your interests.");
        verifyElementDisplayed(btnOkay, "btn okay not displayed");
    }
    public void verifyWindowLoginTelegram(){
        switchToWindow(1, 2);
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("https://oauth.telegram.org/auth?"));
    }
}
