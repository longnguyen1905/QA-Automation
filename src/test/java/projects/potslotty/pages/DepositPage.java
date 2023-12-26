package projects.potslotty.pages;

import constants.ConstantGlobal;
import drivers.DriverManager;
import io.qameta.allure.Step;
import keywords.Keyword;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static keywords.Keyword.*;

public class DepositPage {
    private By inputAmount = By.xpath("//input[@type='text']");
    protected By depositButton = By.cssSelector(".border .button.deposit-button");
    private By errorMessageGreaterAmount = By.cssSelector(".border .mt-5");
    private By tonKeeperHeaderTitle = By.xpath("//div[@class='page-header-title']");
    private By tonKeeperBodyTitle = By.xpath("//div[normalize-space()='Install Tonkeeper and log in to your wallet']");
    private By tonHubGrid = By.xpath("//img[@alt='icon_tonhub']");
    private By tonKeeperGrid = By.xpath("//img[@alt='icon_tonkeeper']");
    private By tonHubTitle = By.xpath("//h3[normalize-space()='Tonhub']");
    private By openInTonHubButton = By.xpath("//a[normalize-space()='Open in Tonhub']");
    private By buttonQRCode = By.xpath("//p[normalize-space()='QR Code']");
    private By imageQRCode = By.xpath("//*[name()='path' and contains(@d,'M 7 0 l 1 ')]");
    private By selectBank = By.xpath("(//span[normalize-space()='Please Select Bank'])");
    private By mayBank = By.xpath("//span[normalize-space()='Maybank Berhad']");
    private By buyCrypTo = By.xpath("//h3[normalize-space()='Buy Crypto']");
    private By depositTab = By.xpath("//h3[normalize-space()='Deposit']");
    private By currencyUnit = By.xpath("//span[@class='mx-2']");
    private By quickInputAmount = By.xpath("//div[@class='hide-scroll svelte-s8eivf mt-4 flex overflow-x-auto lg:justify-end']");
    private By walletMessage = By.cssSelector(".blink_me");
    private By walletAddress = By.xpath("//p[@class='break-words']");
    private By tapTonToCopy = By.xpath("//span[normalize-space()='Tap TON address to copy']");
    private By copy = By.xpath("//span[normalize-space()='Copy']");
    private String maxMYR = ConstantGlobal.MAX_MYR;
    private String minMYR = ConstantGlobal.MIN_MYR;
    private By chainSelector = By.xpath("//button[@data-testid='rk-chain-button']");
    private By walletAddressUSDT = By.xpath("//div[@class='iekbcc0 ju367v4 ju367va ju367v1k ju367v25']");
    private By rainbowKitIcon = By.xpath("//img[@alt='rainbow-kit']");
    private By rainbowKitPopupTitle = By.id("rk_connect_title");
    private By copyAddressButton = By.xpath("(//button[@style='will-change: transform;'])[2]");
    private By disconnectWalletButton = By.xpath("//button[@data-testid='rk-disconnect-button']");
    private By trustWallet = By.xpath("//button[@data-testid='rk-wallet-option-trust']");
    private By rainbowWallet = By.xpath("//button[@data-testid='rk-wallet-option-rainbow']");
    private By coinbaseWallet = By.xpath("//button[@data-testid='rk-wallet-option-coinbase']");
    private By metaMaskWallet = By.xpath("//button[@data-testid='rk-wallet-option-metaMask']");
    private By walletConnect = By.xpath("//button[@data-testid='rk-wallet-option-walletConnect']");
    private By argentWallet = By.xpath("//button[@data-testid='rk-wallet-option-argent']");
    private By coin98Wallet = By.xpath("//button[@data-testid='rk-wallet-option-coin98']");
    private By foxWallet = By.xpath("//button[@data-testid='rk-wallet-option-foxwallet']");
    private By frameWallet = By.xpath("//button[@data-testid='rk-wallet-option-frame']");
    private By frontierWallet = By.xpath("//button[@data-testid='rk-wallet-option-frontier']");
    private By imTokenWallet = By.xpath("//button[@data-testid='rk-wallet-option-imToken']");
    private By OKXWallet = By.xpath("//button[@data-testid='rk-wallet-option-okx']");
    private By phantomWallet = By.xpath("//button[@data-testid='rk-wallet-option-phantom']");
    private By uniswapWallet = By.xpath("//button[@data-testid='rk-wallet-option-uniswap']");
    private By QRCodeToConnectWallet = By.xpath("//div[@class='iekbcc0 ju367v8c ju367v6l ju367v76 ju367v7r ju367vd6 ju367vo ju367vt ju367vv ju367v9a _1vwt0cg0']");
    private By switchNetworksTitle = By.xpath("//h1[@id='rk_chain_modal_title']");
    private By bscChain = By.xpath("//div[@aria-label='BSC']");
    private By polygonChain = By.xpath("//div[@aria-label='Polygon']");
    private By switchButton = By.xpath("//button[contains(text(),'Switch')]");
    private By depositTONSection = By.cssSelector(".rounded-b-2xl");


    public void clickDepositButton(){
        waitForElementClickable(depositButton);
        clickElement(depositButton);
    }
    public void clickTonHub(){
        clickElement(tonHubGrid);
    }
    public void clickTonKeeper(){
        clickElement(tonKeeperGrid);
    }
    public void clickButtonQRCode(){
        clickElement(buttonQRCode);
    }
    public void clickSelectBank(){
        clickElement(selectBank);
    }
    public void clickMayBank(){
        clickElement(mayBank);
    }
    public void clickDepositTab(){
        clickElement(depositTab);
    }
    public void clickBuyCrypto(){
        clickElement(buyCrypTo);
    }
    public void inputAmount(String amount){
        clearTextElement(inputAmount);
        sleep(0.5);
        setText(inputAmount, amount);
        sleep(1);
    }

    public void verifyDepositButtonEnable(){
        verifyElementClickable(depositButton);
    }
    public void verifyDepositButtonDisable(){
        waitForElementVisible(depositButton);
        verifyElementDisable(depositButton);
    }
    public void userShouldSeeErrorMessage(String message){
        verifyElementVisible(errorMessageGreaterAmount);
        verifyEquals(message , getElementText(errorMessageGreaterAmount), "error message not match");
    }
    public void verifyInputFieldIsBlank(){
        verifyEquals("", getWebElement(inputAmount).getText());
    }
    public void userWillBeRedirectedToURLBegin(String url){
        Assert.assertTrue(getCurrentUrlNewTab().contains(url));
    }
    public void verifyUserCanMakePaymentViaTonKeeper(){
        verifyElementVisible(tonKeeperHeaderTitle);
        verifyElementVisible(tonKeeperBodyTitle);
    }
    public void verifyUserCanMakePaymentViaTonHub(){
        verifyElementVisible(tonHubTitle);
        verifyElementVisible(openInTonHubButton);
    }
    public void verifyQRCodeImageVisibility(){
        verifyElementVisible(imageQRCode, "QR Code is not visible");
    }
    public void verifyQRCodeImageInvisible(){
        verifyElementInvisible(imageQRCode, "QR code is displayed");
    }
    @Step("User can see deposit page")
    public void userCanSeeDepositSection(){
        verifyContainText(depositTab,"Deposit");
        verifyURL(ConstantGlobal.URL_DEPOSIT);
        verifyElementVisible(currencyUnit);
        verifyElementVisible(depositButton);
    }
    public void userCanSeeDepositSectionDetails(){
        verifyElementVisible(inputAmount);
        verifyElementVisible(depositTab);
        verifyElementVisible(buyCrypTo);
        verifyElementVisible(depositButton);
        verifyElementVisible(quickInputAmount);
    }
    public void userCanClickOnPackOf(String amount){
        By element = By.xpath("//div[@class='hide-scroll svelte-s8eivf mt-4 flex overflow-x-auto lg:justify-end']" +
                "//*[normalize-space(text()) = '"+ amount +"']");
        clickElement(element);
    }
    public String getInputAmount(){

        return getWebElement(inputAmount).getAttribute("value");
    }
    public void userCanSeeInputAmountChangeTo(String amount){
        verifyEquals(amount, getInputAmount(), "amount not match");
    }
    public void verifyTonKeeperAndTonHubClickable(){
        verifyElementClickable(tonKeeperGrid);
        verifyElementClickable(tonHubGrid);
    }
    public void verifyQRCodeSection(){
        verifyElementVisible(imageQRCode);
//        verifyElementVisible(walletMessage);
//        verifyElementVisible(walletAddress);
//        verifyElementVisible(tapTonToCopy);
    }
    public void userCanTapTonAddressToCopy(){
        clickElement(walletAddress);
        verifyElementInvisible(tapTonToCopy);
        verifyElementVisible(copy);
    }
    public void amountNotAllow(){
        clearTextElement(inputAmount);
        String valueInput = String.valueOf(Float.parseFloat(maxMYR)+0.01);
        setText(inputAmount, valueInput);
    }

    public void amountNotAllowMin() {
        clearTextElement(inputAmount);
        String valueInput = String.valueOf(Float.parseFloat(minMYR)-0.01);
        setText(inputAmount, valueInput);
    }

    public void verifyErrorMessageGreaterAmount(){
        String message = "Please enter a smaller number " + maxMYR;
        verifyContainText(errorMessageGreaterAmount, message);
    }
    public void userCanSeeDepositUSDTSectionDetails(){
        verifyElementDisplayed(inputAmount);
        verifyElementDisplayed(depositButton);
        verifyElementDisplayed(quickInputAmount);
        verifyElementDisplayed(chainSelector);
//        verifyElementDisplayed(walletAddressUSDT);
    }
    public void detectLanguage(String locale){
        waitForElementVisible(depositButton);
        String bodyTexts = getPageBodyText();
        List<String> bodyTextsList = replaceTexts(bodyTexts,locale);
        detectLanguagePage(locale, bodyTextsList);
    }
    public void connectWalletIfNotConnected(){
        try {
            waitForElementVisible(inputAmount);
            getWebElement(chainSelector);
        }catch (Exception e){
            clickElement(rainbowKitIcon);
            clickElement(trustWallet);
            waitForElementVisible(chainSelector);
        }
    }
    public void disconnectWalletIfConnected(){
        try {
            waitForElementVisible(inputAmount);
            getWebElement(chainSelector);
            clickElement(walletAddressUSDT);
            clickElement(disconnectWalletButton);
        }catch (NoSuchElementException e){
            LogUtils.info("Wallet was disconnected ...");
        }
    }
    public void clickRainbowKitIcon(){
        clickElement(rainbowKitIcon);
    }
    public void verifyRainbowKitEnable(){
        verifyElementClickable(rainbowKitIcon);
    }
    public void verifyRainbowKitPopupTitle(String title){
        verifyEquals(getElementText(rainbowKitPopupTitle), title);
    }
    public void verifyPopularWalletsDisplay(){
        verifyElementVisible(rainbowWallet);
        verifyElementVisible(coinbaseWallet);
        verifyElementVisible(metaMaskWallet);
        verifyElementVisible(walletConnect);
    }
    public void verifyOtherWalletsDisplay(){
        verifyElementVisible(trustWallet);
        verifyElementVisible(argentWallet);
        verifyElementVisible(coin98Wallet);
        verifyElementVisible(foxWallet);
        verifyElementVisible(frameWallet);
        verifyElementVisible(frontierWallet);
        verifyElementVisible(imTokenWallet);
        verifyElementVisible(imTokenWallet);
        verifyElementVisible(phantomWallet);
        verifyElementVisible(uniswapWallet);
    }
    public void clickRainbowWallet(){
        clickElement(rainbowWallet);
    }
    public void clickCoinbaseWallet(){
        clickElement(coinbaseWallet);
    }
    public void clickMetaMaskWallet(){
        clickElement(metaMaskWallet);
    }
    public void verifyVisibleQRCodeConnectWallet(){
        verifyElementVisible(QRCodeToConnectWallet);
    }
    public void clickChainSelector(){
        clickElement(chainSelector);
    }
    public void verifyChainPopup(){
        verifyEquals(getElementText(switchNetworksTitle), "Switch Networks");
        verifyElementVisible(bscChain);
        verifyElementVisible(polygonChain);
    }
    public void clickBSCChain(){
        clickElement(bscChain);
        switchToWindow(1,2);
        clickElement(switchButton);
        switchToWindow(0,1);
        waitForElementVisible(chainSelector);
        verifyEquals(getElementText(chainSelector), "BSC");
    }
    public void clickPolygonChain(){
        clickElement(polygonChain);
        switchToWindow(1,2);
        clickElement(switchButton);
        switchToWindow(0,1);
        waitForElementVisible(chainSelector);
        verifyEquals(getElementText(chainSelector), "Polygon");
    }
    public void clickWalletAddress(){
        clickElement(walletAddressUSDT);
    }
    public void verifyVisibleOfCopyAddressButton(){
        verifyElementClickable(copyAddressButton);
    }
    public void verifyVisibleOfDisconnectButton(){
        verifyElementClickable(disconnectWalletButton);
    }
    public void clickDisconnectWalletButton(){
        clickElement(disconnectWalletButton);
    }
    public void verifyChainSelectorInvisible(){
        verifyElementInvisible(copyAddressButton);
    }
    public void verifyWalletAddressInvisible(){
        verifyElementInvisible(disconnectWalletButton);
    }
    public void verifyInputAmountUSDTEqualToAmount(String amount){
        verifyEquals(getElementAttribute(inputAmount, "value"), amount);
    }
    public void waitForLoadDepositUSDTPage(){
        waitForElementVisible(currencyUnit);
        verifyContainText(currencyUnit, "USDT");
    }
    public void verifyDepositTONSection(){
        verifyElementVisible(depositTONSection);
    }
}
