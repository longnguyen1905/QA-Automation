package projects.self_service.pages;

import constants.ConstantGlobal;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import projects.commons.BasePage;


import static keywords.Keyword.*;

public class LandingPage {
    private By hotline = By.cssSelector("body .d-hotline");
    private By reply = By.cssSelector("body .h-reply div");

    private By homeHeader = By.cssSelector(".nav_item:nth-child(1)");
    private By gameCatalog = By.cssSelector(".nav_item:nth-child(2)");
    private By gamePackage = By.cssSelector(".nav_item:nth-child(3)");
    private By feature = By.cssSelector(".nav_item:nth-child(5)");
    private By logo = By.cssSelector(".fixed  a.hidden");
    private By backOffice = By.cssSelector(".nav_item:nth-child(6)");
    private By vision = By.cssSelector(".nav_item:nth-child(7)");

    private By welcome = By.cssSelector(".bg-main p.absolute");
    private By textAreYouReady = By.cssSelector(" .body_text:nth-child(1)");
    private By textLookNoFurther = By.cssSelector(" .body_text:nth-child(2)");
    private By textWeBuild = By.cssSelector(".absolute.justify-center .title_color");
    private By textImmersive = By.cssSelector(".absolute.justify-center .reveal:nth-child(1)");
    private By textServing = By.cssSelector(".absolute.justify-center .reveal:nth-child(2)");

    private By titleGameCatalog = By.cssSelector("#game_catalog .text-center");
    private By sliderGameCatalog = By.cssSelector("#game_catalog .swiper.mb-3 , .swiper.mb-0");

    private By titleGamePackage = By.cssSelector("#game_package div.justify-center");
    private By subTitleGamePackage = By.cssSelector("#game_package p.sofia.text-center");
    private By listPackage = By.cssSelector("#index");
    private By listNamePackage = By.cssSelector("#index p.font-\\[500\\]");
    private By listPrice = By.cssSelector("#index p.ml-\\[8px\\]");
    private By listDescription = By.cssSelector("#index p.sofia.mt-0");
    private By listBenefit = By.cssSelector("#index:nth-child(1) .overflow-y-auto");
    private By benefit1 = By.cssSelector("#game_package .swiper-slide:nth-child(1)");
    private By getStartStandard = By.cssSelector("#game_package .swiper-slide:nth-child(2) button");
    private By switchSliderPackage = By.cssSelector("#game_package .swiper-pagination span:nth-child(2)");

    private By titleFeature = By.cssSelector("#features .z-10.flex");
    private By cryptoCurrency = By.cssSelector("#features .fade-right:nth-child(1) p:nth-child(1)");
    private By cryptoCurrencyDescription = By.cssSelector("#features .fade-right:nth-child(1) p:nth-child(2)");
    private By featureConfigure = By.cssSelector("#features .fade-right:nth-child(2) p:nth-child(1)");
    private By featureConfigureDescription = By.cssSelector("#features .fade-right:nth-child(2) p:nth-child(2)");
    private By featureAPI = By.cssSelector("#features .fade-right:nth-child(3) p:nth-child(1)");
    private By featureAPIDescription = By.cssSelector("#features .fade-right:nth-child(3) p:nth-child(2)");

    private By titleBackOffice = By.cssSelector("#back_office .justify-center");
    private By descriptionBackOffice = By.cssSelector("#back_office .mafia-font.mt-3");
    private By dataInsights = By.cssSelector("#back_office .text-item:nth-child(1) h4");
    private By dataInsightsDescription = By.cssSelector("#back_office .text-item:nth-child(1) p");
    private By manageWebsite = By.cssSelector("#back_office .text-item:nth-child(2) h4");
    private By manageWebsiteDescription = By.cssSelector("#back_office .text-item:nth-child(2) p");
    private By support = By.cssSelector("#back_office .text-item:nth-child(3) h4");
    private By supportDescription = By.cssSelector("#back_office .text-item:nth-child(3) p");

    private By titleVision = By.cssSelector("#vision h3");
    private By descriptionVision = By.cssSelector("#vision p.mb-9");
    private By detailVision = By.cssSelector("#vision ul");

    private By footer = By.cssSelector(".px-7 p, .px-7 a");

    @Step(" open url")
    public void openSS(){
        openURL(ConstantGlobal.URL);
    }
    public void openSSProfile(){
        BasePage.closeDriver();
        BasePage.createDriverProfile();
        openSS();
    }

    public void verifyDisplayedOfHeader(){
        verifyElementDisplayed(homeHeader, "button home is not displayed");
        verifyElementDisplayed(gameCatalog, "button game catalog is not displayed");
        verifyElementDisplayed(gamePackage, "button game package is not displayed");
        verifyElementDisplayed(logo, "logo is not displayed");
        verifyElementDisplayed(feature, "button feature is not displayed");
        verifyElementDisplayed(backOffice, "button back office is not displayed");
        verifyElementDisplayed(vision, "button vision is not displayed");
    }
    public void verifyDisplayedOfHome(){
        scrollToElement(titleGameCatalog);
        verifyEqualText(welcome,"Welcome To");
        verifyEqualText(textAreYouReady,"Are you ready to embark on an exciting journey in the world of online gaming?");
        verifyEqualText(textLookNoFurther,"Look no further! We build casino website craft.");
        verifyEqualText(textWeBuild,"We build casino websites craft");
        verifyEqualText(textImmersive,"Immersive experiences that captivate players");
        verifyEqualText(textServing,"serving as your gateway to the Ultimate casino experience");
    }

    public void verifyDisplayedOfFeature(){
        verifyElementDisplayed(titleFeature, "title feature not displayed");
        verifyEqualText(cryptoCurrency, "Cryptocurrency");
        verifyEqualText(featureConfigure, "Configure Your Site");
        verifyEqualText(featureAPI, "API Documentation And Testing");
        verifyEqualText(cryptoCurrencyDescription, "Crypto transactions for a secure, seamless, and exciting gaming experience.");
        verifyEqualText(featureConfigureDescription, "Tailor your gaming platform to your preferences effortlessly. Customize game lists, currencies, and domains effortlessly with our intuitive tools.");
        verifyEqualText(featureAPIDescription, "Seamlessly integrate with our platform using comprehensive API documentation. Test your connections with ease to ensure a smooth gaming experience.");
    }
    public void clickOnFeature(){
        clickElement(feature);
        sleep(2);
    }
    public void clickOnGameCatalog(){
        clickElement(gameCatalog);
        sleep(2);
    }
    public void clickOnGamePackage(){
        clickElement(gamePackage);
        sleep(2);
    }
    public void clickOnBackOffice(){
        clickElement(backOffice);
        sleep(2);
    }
    public void clickOnVision(){
        clickElement(vision);
        sleep(2);
    }
    public void clickOnGetStartStandard(){
        clickOnGamePackage();
        sleep(1);
        scrollToElement(getStartStandard);
        sleep(1);
        clickElement(getStartStandard);
        sleep(2);
    }

    public void verifyDisplayedOfBackOffice(){
        verifyElementDisplayed(titleBackOffice, "title back office not displayed");
        verifyEqualText(descriptionBackOffice, "Unlock a world of possibilities with Our Backoffice, your trusted partner for success. Discover cutting-edge tools, unparalleled support, and a commitment to helping you achieve your goals.");
        verifyEqualText(dataInsights,"Data Insights");
        verifyEqualText(dataInsightsDescription,"Harness the power of near real-time data to make informed decisions that drive success.");
        verifyEqualText(manageWebsite,"Manage Website");
        verifyEqualText(manageWebsiteDescription,"Take control of your online presence effortlessly with Our Backoffice's user-friendly tools.");
        verifyEqualText(support,"24/7 Support");
        verifyEqualText(supportDescription,"We're here for you around the clock, ensuring you're never alone on your journey.");
    }
    public void verifyDisplayedOfVision(){
        verifyElementDisplayed(titleVision, "title vision not displayed");
        verifyEqualText(descriptionVision, "We envision a future where the world of online gaming and cryptocurrency converge to create");
        verifyEqualText(detailVision,"Boundless Opportunities For Entertainment Innovation Prosperity");
    }
    public void verifyDisplayedOfGameCatalog(){
        verifyEqualText(titleGameCatalog,"World Of CASINO GAMES");
        verifyElementDisplayed(sliderGameCatalog, "Slider is not displayed");
    }
    public void verifyDisplayedOfGamePackage(){
        verifyEqualText(titleGamePackage,"Offering GAME PACKAGES");
        verifyEqualText(subTitleGamePackage,"Your casino's success story begins here");
        verifyElementDisplayed(listPackage, "Package is not displayed");
        verifyElementDisplayed(listNamePackage, "Name package is not displayed");
        verifyElementDisplayed(listPrice, "Price of package is not displayed");
        verifyElementDisplayed(listBenefit, "Benefit of package is not displayed");
    }
}