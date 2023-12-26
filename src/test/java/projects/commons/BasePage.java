package projects.commons;

import constants.ConstantGlobal;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.LogUtils;

import java.io.File;

public class BasePage {

    public static void createDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = setupBrowser("chrome");
        DriverManager.setDriver(driver);
    }
    @Parameters({"BROWSER"})
    public static void createDriver(@Optional("chrome") String browserName) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
    }

    public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }


    private static WebDriver initChromeDriver() {
        WebDriver driver;
        LogUtils.info("Launching Chrome browser...");

        ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
        }

        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        LogUtils.info("Launching Edge browser...");

        EdgeOptions options = new EdgeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        LogUtils.info("Launching Firefox browser...");

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(ConstantGlobal.HEADLESS);

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

    public static void createDriverVPN(){
        LogUtils.info("Launching Chrome browser with VPN... ");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        String rootFolder = System.getProperty("user.dir");
        File vpn = new File(rootFolder + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "vpn" + File.separator + "Urban.crx");
        ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }
        options.addArguments("--remote-allow-origins=*");
        options.addExtensions(vpn);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    public static void createMetaMaskDriver(){
        LogUtils.info("Launching Chrome browser with Meta Mask... ");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }
        options.addArguments("--user-data-dir=C:\\Users\\nguyenhuutruonglong\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    public static void createTrustWalletDriver(){
        LogUtils.info("Launching Chrome browser with Trust Wallet... ");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }
        options.addArguments("--user-data-dir=C:\\Users\\nguyenhuutruonglong\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }
    public static void createDriverProfile() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        LogUtils.info("Launching Chrome browser...");
        ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
        }
        options.addArguments("--user-data-dir=C:\\Users\\tranthanhtai\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }
}
