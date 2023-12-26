package projects.potslotty.testcases.commons;

import io.qameta.allure.Epic;
import org.testng.annotations.Test;
import projects.potslotty.pages.CommonPage;
import projects.potslotty.pages.EarnPage;
import projects.commons.BaseTest;


@Epic("Test Earn Page")
public class Earn extends BaseTest {
    private CommonPage commonPage;
    private EarnPage earnPage;
    private Earn(){
        commonPage = new CommonPage();
        earnPage = new EarnPage();
    }

    @Test(description = "Referral code section")
    public void referralCodeSection() {
        commonPage.clickEarn();
        earnPage.userCanSeeReferralCode();
        earnPage.verifySocialIconDisplay();
    }
    @Test(description = "Telegram redirection")
    public void telegramRedirection() {
        commonPage.clickEarn();
        earnPage.clickTelegramIcon();
        earnPage.verifyTelegramPopup();
    }
    @Test(description = "Facebook redirection")
    public void facebookRedirection() {
        commonPage.clickEarn();
        earnPage.clickFacebookIcon();
        earnPage.verifyFacebookPopup();
    }
}