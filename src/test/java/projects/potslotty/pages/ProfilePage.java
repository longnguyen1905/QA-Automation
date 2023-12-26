package projects.potslotty.pages;

import constants.ConstantGlobal;
import drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static keywords.Keyword.*;

public class ProfilePage {
    private By inputWithdrawAmount = By.xpath("//input[@placeholder='>= 0.01 TON']");
    private By inputWithdrawAmountMYR = By.xpath("//input[@placeholder='>= 10 MYR']");
    private By inputWithdrawAmountUSDT = By.xpath("//input[@placeholder='>= 0.01 USDT']");
    public By withdrawButton = By.xpath("//button[normalize-space()='Withdraw']");
//    private By popupWithdrawButton = By.xpath("//button[@class='btndefault w-40 bnt-text-1 my-5 rounded-r-none']");
//    private By popupCancelButton = By.xpath("//button[normalize-space()='Cancel']");
//    private By popupOkButton = By.xpath("//button[normalize-space()='Ok']");
//    private By popupWithdrawTitle= By.xpath("//p[@class='text-white heading-5 text-left px-4']");
//    private By popupWithdrawSuccessTitle = By.xpath("//p[@class='text-white heading-5 text-left px-4']");
//    private By moduleInfo = By.xpath("//div[@class='level-container svelte-13o469e inline-flex w-full items-center p-2 font-semibold']");
    private By imageAvatar = By.xpath("//img[@alt='Logo Image']");
    private By userName = By.cssSelector(".lg\\:flex-row h2");
    private By userLevel = By.xpath("//p[contains(text(),'Level')]");
    private By firstName = By.cssSelector("[name='firstName']");
    private By lastName = By.cssSelector("[name='lastName']");
    private By btnSave = By.cssSelector(".new-profile .btndefault");
    private By walletAddressMessage = By.xpath("//div[contains(text(),'Please add your TON wallet address for withdrawal')]");
    private By inputAddress = By.xpath("//input[contains(@placeholder,'TON address here')]");
    private By editButton = By.xpath("//button[normalize-space()='EDIT']");
    private By saveButton = By.xpath("//button[normalize-space()='SAVE']");
    private By autoWithdrawTitle = By.xpath("//h2[normalize-space()='Auto withdraw']");
    private By autoWithdrawMessage = By.xpath("//div[@class='blink_me flex items-center justify-center rounded-lg border border-dashed border-[#fff] p-2 text-[12px] text-[#fff] sm:text-[15px] ']");
    private By transactionsTitle = By.xpath("//h1[normalize-space()='Transactions']");
    private By transactionsHistory = By.xpath("//div[@class='setting-container svelte-13o469e mt-2 flex items-center justify-between px-2 py-1 text-white']");
    private By rainbowKitIcon = By.xpath("//img[@alt='rainbow-kit']");
    private By chainAfterDisconnect = By.xpath("//div[@class='flex items-center rounded-xl bg-[#1A1B1F] p-2 font-bold text-white']");
    private By walletAfterDisconnect = By.xpath("//div[@class='ml-2 rounded-xl bg-[#1A1B1F] p-2 font-bold text-white']");
    private By chainSelector = By.xpath("//button[@data-testid='rk-chain-button']");
    private By walletAddressUSDT = By.xpath("//div[@class='iekbcc0 ju367v4 ju367va ju367v1k ju367v25']");
    private By generalInformation = By.cssSelector(".profile-player .hidden.md\\:flex a:nth-child(1)");
    private By withdraw = By.cssSelector(".profile-player .hidden.md\\:flex a:nth-child(2)");
    private By transaction =  By.cssSelector(".profile-player .hidden.md\\:flex a:nth-child(3)");

    private By titlePageGeneral =  By.xpath("//h2[contains(text(),'General')]");
    private By popUpSaveInformation =  By.cssSelector(".welcome-modal");
    private By btnCancel =  By.cssSelector(".btnsecondary ");
    private By btnSaveInformation =  By.cssSelector(".welcome-modal .btndefault ");
    private By withdrawTitle =  By.cssSelector("h1.text-\\[\\#F1DF3E\\]") ;


    public void clickWithdrawButton(){
        clickElement(withdrawButton);
    }
    public void clickPopupWithdrawButton(){
//        clickElement(popupWithdrawButton);
    }
//    public void clickPopupCancelButton(){
//        clickElement(popupCancelButton);
//    }
//    public void clickPopupOkButton(){
//        clickElement(popupOkButton);
//    }
    public void clickEditButton(){
        clickElement(editButton);
    }

    public void clickWithdraw(){
        clickElement(withdraw);
    }
    public void clickTransaction(){
        clickElement(transaction);
    }



    public void inputAmount(String amount){
        setText(inputWithdrawAmount, amount);
    }
    public void inputAmountMYR(String amount){
        setText(inputWithdrawAmountMYR, amount);
    }
    public void inputAmountUSDT(String amount){
        waitForElementVisible(chainSelector);
        setText(inputWithdrawAmountUSDT, amount);
    }
    public void verifyWithdrawButtonEnable(){
        verifyElementClickable(withdrawButton, "Withdraw button is disable");
    }
    public void verifyWithdrawButtonDisable(){
        verifyElementDisable(withdrawButton, "Withdraw button is enable");
    }
    public void verifyInputFieldIsEmpty(){
        verifyEquals(getElementText(inputWithdrawAmount), "", "Input field is not empty");
    }
    public void verifyInputFieldMyrIsEmpty(){
        verifyEquals(getElementText(inputWithdrawAmountMYR), "", "Input field is not empty");
    }
//    public void verifyPopupWithdrawDisplay(){
//        verifyElementVisible(popupWithdrawTitle, "Pop up title is not display");
//        verifyEquals(getElementText(popupWithdrawTitle), "Please confirm to withdraw your balance to your registered wallet", "title not match");
//    }
    public void verifyPopupWithdrawSuccessDisplay(){
//        verifyElementVisible(popupWithdrawSuccessTitle, "Pop up title is not display");
//        verifyEquals(getElementText(popupWithdrawSuccessTitle), "Withdraw successfully", "title not match");
    }
    public void verifyProfilePlayer(){
        verifyEquals(getElementText(generalInformation), "General information");
        verifyElementVisible(imageAvatar, "Image avatar is not displayed");
        verifyElementVisible(userName, "User Name is not displayed");
        verifyElementVisible(userLevel, "User level is not displayed");
        verifyElementVisible(firstName, "First Name is not displayed");
        verifyElementVisible(lastName, "Last Name  is not displayed");
        verifyElementDisable(btnSave, "Btn Save is enable");
        verifyURL(ConstantGlobal.URL_PROFILE);
    }
    public void verifyWalletAddress(){
        verifyElementVisible(walletAddressMessage, "wallet address message is not displayed");
        verifyElementVisible(inputAddress, "input address is not displayed");
        verifyElementVisible(editButton, "Edit button is not displayed");
    }
    public void verifyAutoWithdrawSection(){
        verifyElementVisible(autoWithdrawTitle, "Auto Withdraw Title is not displayed");
        verifyElementVisible(autoWithdrawMessage, "Auto Withdraw message is not displayed");
        verifyElementVisible(withdrawButton, "Withdraw Button is not displayed");
        verifyURL(ConstantGlobal.URL_WITHDRAW);
    }
    public void verifyTransactionHistory(){
        verifyElementVisible(transactionsTitle);
        verifyElementVisible(transactionsHistory);
        verifyEquals(10, getWebElements(transactionsHistory).size());
        verifyURL(ConstantGlobal.URL_TRANSACTIONS);
    }
    public void verifyEditAndSaveButton(){
        verifyElementVisible(saveButton, "save button is not displayed");
        verifyElementInvisible(editButton, "edit button is not disable");
    }
    public void userCanEditTheWalletAddress(){
        clearTextElement(inputAddress);
        setText(inputAddress, "EQC7iX8x6xGxDENaanzdxzwIwgc8AePrpXHuIdUs4mPC_abc");
        clickElement(saveButton);
        waitForElementClickable(editButton);
        Assert.assertTrue(getWebElement(inputAddress).getAttribute("value").contains("C_abc"), "address was not changed");
        sleep(1);
        clickElement(editButton);
        clearTextElement(inputAddress);
        setText(inputAddress, ConstantGlobal.TON_ADDRESS);
        clickElement(saveButton);
        waitForElementClickable(editButton);
    }
    public void editAddressWithoutSaving(){
        clearTextElement(inputAddress);
        setText(inputAddress, "EQC7iX8x6xGxDENaanzdxzwIwgc8AePrpXHuIdUs4mPC_123");
        DriverManager.getDriver().navigate().refresh();

    }
    public void verifyWalletNotChanged(){
        verifyElementVisible(editButton, "edit button is not displayed");
        verifyElementDisable(saveButton, "save button is not disable");
        Assert.assertTrue(getWebElement(inputAddress).getAttribute("value").contains("mPC_Iw3"), "address was changed");
    }
    public void detectLanguage(String locale){
        String bodyTexts = getPageBodyText();
        List<String> bodyTextsList = replaceTexts(bodyTexts,locale);
        detectLanguagePage(locale, bodyTextsList);
    }
    public void verifyChainAfterDisconnect(){
        waitForElementVisible(rainbowKitIcon);
        verifyElementVisible(chainAfterDisconnect);
    }
    public void verifyWalletAfterDisconnect(){
        waitForElementVisible(rainbowKitIcon);
        verifyElementVisible(walletAfterDisconnect);
    }
    public void verifyUSDTInputFieldIsEmpty(){
        verifyEquals(getElementText(inputWithdrawAmountUSDT), "", "Input field is not empty");
    }
    public void verifyInputAmountUSDTEqualToAmount(String amount){
        verifyEquals(getElementAttribute(inputWithdrawAmountUSDT, "value"), amount);
    }
    public void editFirstName(String value){
        clearTextElement(firstName);
        setText(firstName, value);
    }
    public void editLastName(String value){
        clearTextElement(lastName);
        setText(lastName, value);
    }
    public void clickSaveButton(){
        clickElement(btnSave);
    }
    public void clickCancelButton(){
        clickElement(btnCancel);
    }
    public void clickSaveInformation(){
        clickElement(btnSaveInformation);
        sleep(1);
    }
    public void verifyButtonSaveEnable(){
        verifyElementEnable(btnSave, "Button save is disable");
    }
    public void userCanSeePopUpSaveInformation(){
        verifyElementDisplayed(popUpSaveInformation, "Pop up confirm save information is not displayed");
    }
    public void userCanCancelSaveInformation(){
        verifyElementInvisible(popUpSaveInformation, "Pop up confirm save information is displayed ");
    }
    public void userCanSaveNewInformation(){
        verifyElementDisable(saveButton, "Save button is not disable");
    }
    public void verifySaveNewInformation(){
        verifyContainText(userName, getElementAttribute(firstName,"value"));
    }
    public void reSavedInformation(){
        editFirstName("Test");
        editLastName("Test");
        clickSaveButton();
        clickSaveInformation();
    }
    public void limitCharacterInput(Integer number){
        verifyEquals(getElementAttribute(firstName,"value").length(), number);
    }
    public void verifyInputFirstName(String value){
        verifyEquals( getElementAttribute(firstName,"value"), value);
    }
    public void verifyUserCannotAccessProfilePage(){
        verifyElementInvisible(generalInformation);
        verifyElementInvisible(withdraw);
        verifyElementInvisible(transaction);
    }
}
