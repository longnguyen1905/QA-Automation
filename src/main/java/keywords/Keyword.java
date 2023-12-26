package keywords;

import com.github.pemistahl.lingua.api.Language;
import com.github.pemistahl.lingua.api.LanguageDetector;
import com.github.pemistahl.lingua.api.LanguageDetectorBuilder;
import constants.ConstantGlobal;
import drivers.DriverManager;
import helpers.CaptureHelper;
import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import helpers.SystemHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Keyword {

    private final static long EXPLICIT_TIMEOUT = ConstantGlobal.EXPLICIT_TIMEOUT;
    private final static long STEP_TIME = ConstantGlobal.STEP_TIME;
    private final static long PAGE_LOAD_TIMEOUT = ConstantGlobal.PAGE_LOAD_TIMEOUT;

    static {
        PropertiesHelper.loadAllFiles();
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public static WebElement getWebElement(String xpath, int index) {
        return getWebElement(By.xpath(xpath + "[" + index + "]"));
    }

    public static By xpathIndex(String xpath, int index) {
        return By.xpath(xpath + "[" + index + "]");
    }

    @Step("Verify Equals: {0} and {1}")
    public static void verifyEquals(Object actual, Object expected) {
        waitForPageLoaded();
        sleep(STEP_TIME);
        LogUtils.info("Verify equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, "Fail. Not match. '" + actual.toString() + "' != '" + expected.toString() + "'");
    }

    @Step("Verify Equals: {0} and {1}")
    public static void verifyEquals(Object actual, Object expected, String message) {
        waitForPageLoaded();
        sleep(STEP_TIME);
        LogUtils.info("Verify equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    @Step("Check element existing {0}")
    public static Boolean checkElementExist(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        List<WebElement> listElement = getWebElements(by);

        if (listElement.size() > 0) {
            LogUtils.info("Check Element Exist: " + true + " --- " + by);
            return true;
        } else {
            LogUtils.info("Check Element Exist: " + false + " --- " + by);
            return false;
        }
    }

    @Step("Open URL: {0}")
    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
//        sleep(STEP_TIME);
        LogUtils.info("Open URL: " + url);
//        waitForPageLoaded();
//        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
//            CaptureHelper.takeScreenshot("openURL_" + SystemHelper.makeSlug(url));
//        }
    }

    @Step("Click element {0}")
    public static void clickElement(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        getWebElement(by).click();
        LogUtils.info("Click element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("clickElement_" + SystemHelper.makeSlug(by.toString()));
        }
    }

    public static void clickElement(String string, int index) {
        waitForPageLoaded();
        waitForElementVisible(xpathIndex(string, index));
        sleep(STEP_TIME);
        getWebElement(xpathIndex(string, index)).click();
        LogUtils.info("Click element " + xpathIndex(string, index));

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("clickElement_" + SystemHelper.makeSlug(xpathIndex(string, index).toString()));
        }
    }

    @Step("Click element {0} with timeout {1}")
    public static void clickElement(By by, int timeout) {
        waitForPageLoaded();
        waitForElementVisible(by, timeout);
        sleep(STEP_TIME);
        getWebElement(by).click();
        LogUtils.info("Click element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("clickElement_" + SystemHelper.makeSlug(by.toString()));
        }
    }

    @Step("Set text {1} on {0}")
    public static void setText(By by, String value) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        getWebElement(by).sendKeys(value);
        LogUtils.info("Set text: " + value + " on element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("setText_" + SystemHelper.makeSlug(by.toString()));
        }
    }

    @Step("Set text {1} on {0} and press key {2}")
    public static void setTextAndKey(By by, String value, Keys key) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        getWebElement(by).sendKeys(value, key);
        LogUtils.info("Set text: " + value + " on element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("setText_" + SystemHelper.makeSlug(by.toString()));
        }
    }

    @Step("Get text of element {0}")
    public static String getElementText(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        String text = getWebElement(by).getText();
        LogUtils.info("Get text: " + text);
        return text;
    }

    public static String getElementAttribute(By by, String attribute) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        LogUtils.info("Get text of attribute: " + getWebElement(by).getAttribute(attribute));
        return getWebElement(by).getAttribute(attribute);
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT), Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());

        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            LogUtils.info("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    public static void waitForElementClickable(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            LogUtils.info("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    @Step("Scroll to element {0}")
    public static void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    }

    @Step("Scroll to element {0}")
    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("scrollToElement_" + SystemHelper.makeSlug(element.getText()));
        }
    }

    @Step("Scroll to element {0} with type {1}")
    public static void scrollToElement(WebElement element, String type) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(" + type + ");", element);
    }

    @Step("Scroll to position with X={0}, Y={1}")
    public static void scrollToPosition(int X, int Y) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(" + X + "," + Y + ");");
    }

    public static String getPageBodyText() {
        LogUtils.info("Get page body texts ...");
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        String bodyText = (String) js.executeScript("return document.body.innerText;");
        return bodyText.toLowerCase();
    }


    @Step("Move to element {0}")
    public static boolean moveToElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).release(getWebElement(by)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    public static boolean moveToOffset(int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveByOffset(X, Y).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    @Step("Highlight element {0}")
    public static WebElement highLightElement(By by) {
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", getWebElement(by));
            sleep(1);
        }
        return getWebElement(by);
    }

    @Step("Hover on element {0}")
    public static boolean hoverElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Mouse hover on element {0}")
    public static boolean mouseHover(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Drag element {0} to element {1}")
    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropElement(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropOffset(By fromElement, int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).pause(1).moveByOffset(X, Y).release().build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    @Step("Press ENTER on keyboard")
    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Press BackSpace on keyboard")
    public static boolean pressBackSpace() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Press Delete on keyboard")
    public static boolean pressDelete() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DELETE);
            robot.keyRelease(KeyEvent.VK_DELETE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Press ESC on keyboard")
    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Press F11 on keyboard")
    public static boolean pressF11() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState").toString().equals("complete");

        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        if (!jsReady) {
            LogUtils.info("Javascript in NOT Ready!");
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load (Javascript). (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }
    }

    public static void waitForJQueryLoad() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            assert driver != null;
            return ((Long) ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return jQuery.active") == 0);
        };

        boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");

        if (!jqueryReady) {
            LogUtils.info("JQuery is NOT Ready!");
            try {
                wait.until(jQueryLoad);
            } catch (Throwable error) {
                Assert.fail("Timeout waiting for JQuery load. (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }
    }

    public static void waitForAngularLoad() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        ExpectedCondition<Boolean> angularLoad = driver -> {
            assert driver != null;
            return Boolean.valueOf(((JavascriptExecutor) DriverManager.getDriver()).executeScript(angularReadyScript).toString());
        };

        boolean angularReady = Boolean.parseBoolean(js.executeScript(angularReadyScript).toString());

        if (!angularReady) {
            LogUtils.info("Angular is NOT Ready!");
            try {
                wait.until(angularLoad);
            } catch (Throwable error) {
                Assert.fail("Timeout waiting for Angular load. (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }

    }

    public static void verifyElementVisible(By by, String message) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        LogUtils.info("Verify " + by + " is visible");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isDisplayed(), message);
    }

    public static void verifyElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        LogUtils.info("Verify " + by + " is visible");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isDisplayed(), "Element not visible");
    }

    public static void verifyListElementVisible(List<String> list, int index) {
        for (String element : list) {
            verifyElementVisible(element, index);
        }
    }

    public static void verifyElementVisible(String string, int index) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathIndex(string, index)));
        LogUtils.info("Verify " + xpathIndex(string, index) + " is displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(xpathIndex(string, index)).isDisplayed(), "Element not visible");
    }

    public static void verifyElementClickable(By by) {
        waitForPageLoaded();
        LogUtils.info("Verify " + by + " is clickable");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isEnabled(), "Element not clickable");
    }

    public static void verifyElementClickable(By by, String message) {
        waitForPageLoaded();
        LogUtils.info("Verify " + by + " is clickable");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isEnabled(), message);
    }

    public static void verifyElementInvisible(By by) {
        boolean check = true;
        String status = "visible";
        try {
            getWebElement(by);
            check = false;
        } catch (Exception e) {
            status = "invisible";
        }
        LogUtils.info("check is " + check);
        LogUtils.info("Element is " + status + ": " + by);
        Assert.assertTrue(check);
    }

    public static void verifyElementInvisible(By by, String message) {
        boolean check = true;
        String status = "visible";
        try {
            getWebElement(by);
            check = false;
        } catch (Exception e) {
            status = "invisible";
        }
        LogUtils.info("Element is " + status + ": " + by);
        Assert.assertTrue(check, message);
    }

    public static void verifyElementDisable(By by) {
        Assert.assertFalse(getWebElement(by).isEnabled());
        LogUtils.info("Verify element disable: " + by);
    }

    public static void verifyElementDisable(By by, String message) {
        Assert.assertFalse(getWebElement(by).isEnabled(), message);
        LogUtils.info("Verify element disable: " + by);
    }

    public static void verifyElementEnable(By by, String message) {
        Assert.assertTrue(getWebElement(by).isEnabled(), message);
        LogUtils.info("Verify element enable: " + by);
    }

    public static void clearTextElement(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        String s = Keys.chord(Keys.CONTROL, "a");
        getWebElement(by).sendKeys(s);
        getWebElement(by).sendKeys(Keys.DELETE);
        LogUtils.info("clear text element " + by);
    }

    public static String getCurrentUrlNewTab() {
        String parent_tab = DriverManager.getDriver().getWindowHandle();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> s = DriverManager.getDriver().getWindowHandles();
        Iterator<String> i = s.iterator();

        while (i.hasNext()) {
            String child_tab = i.next();
            if (!parent_tab.equalsIgnoreCase(child_tab)) {
                DriverManager.getDriver().switchTo().window(child_tab);
            }
        }
        return DriverManager.getDriver().getCurrentUrl();
    }

    public static void verifyEqualText(By by, String message){
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        Assert.assertTrue(getElementText(by).equals(message));
        LogUtils.info("Verify element: " + by + " equal: " + message);
    }

    public static void verifyContainText(By by, String message) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        Assert.assertTrue(getElementText(by).contains(message));
        LogUtils.info("Verify element: " + by + "contains: " + message);
    }

    public static void verifyContainText(WebElement element, String message) {
        waitForPageLoaded();
        sleep(STEP_TIME);
        Assert.assertTrue(element.getText().contains(message));
        LogUtils.info("Verify element: " + element + "contains: " + message);
    }

    public static void verifyContainTextLowerCase(WebElement element, String message) {
        waitForPageLoaded();
        sleep(STEP_TIME);
        Assert.assertTrue(element.getText().toLowerCase().contains(message));
        LogUtils.info("Verify element: " + element + "contains: " + message);
    }

    public static void verifyContainText(String string, int index, String message) {
        waitForPageLoaded();
        waitForElementVisible(xpathIndex(string, index));
        sleep(STEP_TIME);
        Assert.assertTrue(getElementText(xpathIndex(string, index)).contains(message));
        LogUtils.info("Verify element: " + xpathIndex(string, index) + "contains: " + message);
    }

    public static void verifyURL(String text) {
        waitForPageLoaded();
        sleep(STEP_TIME);
        verifyEquals(DriverManager.getDriver().getCurrentUrl(), text, "URl not match");
        LogUtils.info("Verify URL: " + text);
    }

    public static void verifyURLContainText(String text) {
        waitForPageLoaded();
        sleep(STEP_TIME);
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(text), "URl not match");
        LogUtils.info("Verify URL contain: " + text);
    }

    public static void verifyElementDisplayed(By by) {
        Assert.assertTrue(getWebElement(by).isDisplayed());
        LogUtils.info("Verify element displayed: " + by);
    }

    public static void verifyElementDisplayed(By by, String message) {
        Assert.assertTrue(getWebElement(by).isDisplayed(), message);
        LogUtils.info("Verify element displayed: " + by);
    }

    public static void verifyElementNotDisplayed(By by) {
        Assert.assertFalse(getWebElement(by).isDisplayed());
        LogUtils.info("Verify element not displayed: " + by);
    }

    public static void verifyElementNotDisplayed(By by, String message) {
        Assert.assertFalse(getWebElement(by).isDisplayed(), message);
        LogUtils.info("Verify element not displayed: " + by);
    }

    public static List<String> getDataForLocale(String country, String nameList) {
        ExcelHelper excelHelper = new ExcelHelper();
        List<String> listValue = new ArrayList<>();
        int colum = 0;
        Object[][] data = excelHelper.getExcelData("src/test/resources/datatest/dataLocale.xlsx", country);
        switch (nameList) {
            case ("listCurrency"):
                colum = 0;
                break;
            case ("listCurrencyNotExist"):
                colum = 1;
                break;
            case ("listHeader"):
                colum = 2;
                break;
            case ("listHeaderNotExist"):
                colum = 3;
                break;
            case ("languageCode"):
                colum = 4;
                break;
            case ("countryCode"):
                colum = 5;
                break;
        }
        for (int row = 0; row < data.length; row++) {
            listValue.add((String) data[row][colum]);
        }
        listValue.removeAll(Collections.singleton("notValue"));
        return listValue;
    }

    public static List<String> replaceTexts(String text, List<String> elementTexts, String sheet) {
        LogUtils.info("Replace some texts and return list String ...");
        String result = text;
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/DataTest.xlsx", sheet);

        for (int i = 1; i < excelHelper.getPhysicalNumberOfRows(); i++) {
            elementTexts.add(excelHelper.getCellData("Replace Characters", i));
        }
        for (String s : elementTexts) {
            result = result.replace(s, " ");
        }
        result = result.replaceAll("\\d", " ");
        result = result.replace("  ", " ");
        result = result.replace("\n", " ");
        String[] results = result.split(" ");
        List<String> list = new LinkedList<String>(Arrays.asList(results));
        list.removeAll(Arrays.asList("", null, " ", "  ", "   ", "     "));
        return list;
    }

    public static List<String> replaceTexts(String text, String sheet) {
        LogUtils.info("Replace some texts and return list String ...");
        String result = text;
        List<String> replaceTextList = new ArrayList<>();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/datatest/DataTest.xlsx", sheet);

        for (int i = 1; i < excelHelper.getPhysicalNumberOfRows(); i++) {
            replaceTextList.add(excelHelper.getCellData("Replace Characters", i));
        }
        for (String s : replaceTextList) {
            result = result.replace(s, " ");
        }
        result = result.replaceAll("\\d", " ");
        result = result.replace("  ", " ");
        result = result.replace("\n", " ");
        String[] results = result.split(" ");
        List<String> list = new LinkedList<String>(Arrays.asList(results));
        list.removeAll(Arrays.asList("", null, " ", "  ", "   ", "     "));
        return list;
    }

    public static void detectLanguagePage(String locale, List<String> listElementText) {
        LogUtils.info("detect language of list page texts");
        List<String> listTextsFail = new ArrayList<>();
        LanguageDetector detector = LanguageDetectorBuilder.fromAllLanguages().build();
        Language detectedLanguage;


        for (String elementText : listElementText) {
            detectedLanguage = detector.detectLanguageOf(elementText);
            if (detectedLanguage.name().equals(locale)) {
            } else {
//                LogUtils.warn("Language detect different: " + locale + " and " + detectedLanguage.name());
//                LogUtils.warn("Texts not match: " + elementText);
                listTextsFail.add(elementText);
            }
        }

        listTextsFail.removeAll(Arrays.asList("", null));
        for (String text : listTextsFail) {
            detectedLanguage = detector.detectLanguageOf(text);
            if (detectedLanguage.name().equals(locale)) {
                System.out.println("=>>>>>>>>>>>>>>>>>" + text);
                listTextsFail.remove(text);
            }
        }

        if (listTextsFail.size() > 0) {
            for (String text : listTextsFail) {
                detectedLanguage = detector.detectLanguageOf(text);
                Assert.assertEquals(detectedLanguage.name(), locale, "\nURL fail: " + DriverManager.getDriver().getCurrentUrl() + "\n"
                        + "List texts not match: " + listTextsFail);
            }
        }
    }

    public static List<String> getTextListElements(By elements) {
        LogUtils.info("Get list element ...");
        List<String> list = new ArrayList<>();
        sleep(2);
        waitForElementVisible(elements);
        for (WebElement element : getWebElements(elements)) {
            list.add(element.getText().toLowerCase());
        }
        return list;
    }

    public static boolean checkEqualList(List listA, List listB) {
        Set<String> set1 = new HashSet<>(listA);
        Set<String> set2 = new HashSet<>(listB);
        boolean areEqual = set1.equals(set2);
        return areEqual;
    }

    public static List<String> getListDifferent(List<String> listA, List<String> listB) {
        List<String> listDiff = listA.stream()
                .filter(item -> !listB.contains(item))
                .collect(Collectors.toList());
        return listDiff;
    }

    public static void verifyListDisplayed(By elements) {
        for (WebElement element : getWebElements(elements)) {
            verifyElementDisplayed(element, "element " + element + " not displayed");
        }
    }

    public static void verifyElementDisplayed(WebElement element, String message) {
        Assert.assertTrue(element.isDisplayed(), message);
        LogUtils.info("Verify element displayed: " + element);
    }

    public static List<String> getListName(By list) {
        List<String> listName = new ArrayList<>();
        sleep(2);
        waitForElementVisible(list);
        for (WebElement nameOfGame : getWebElements(list)) {
            listName.add(nameOfGame.getText());
        }
        return listName;
    }

    public static String getAttributeValue(By by) {
        return getWebElement(by).getAttribute("value");
    }

    public static void switchToWindow(int index, int numberOfWindows) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(index));
        sleep(2);
        waitForPageLoaded();
    }

    public static String getDataFromTxt(String path) {
        StringBuilder result = new StringBuilder();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                result.append(line).append("\n");
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static int extractNumber(String inputString) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            String number = matcher.group();
            return Integer.parseInt(number);
        } else {
            return 0;
        }
    }

    public static void openNewUrlTab(String url) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.open('" + url + "','_blank');");
    }

}
