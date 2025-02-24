package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer{
    public static WebDriver driver;

    public static void openBrowser() {
        String browser = ConfigReader.read("browser");
        switch (browser) {
            case "chrome":
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--headless");
                driver=new ChromeDriver(options);
                break;
            // driver = new ChromeDriver(); //this is replaced with above headless for backend test purposes
            case "firefox":
                driver = new FirefoxDriver();
                break;


            default:
                throw new RuntimeException("The name of browser is invalid" + browser);
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        activatePageObjects();

    }

    public static void shutDownBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

    public String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);

    }

    public byte[] takeScreenShot(String fileName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }


    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }
    public static  void sentText(String text, WebElement element){
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }
    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        return wait;
    }
    public static void clickOnElement(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }
    public static void waitForElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
}
