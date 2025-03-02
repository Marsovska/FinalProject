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

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void OPEN_BROWSER() {
        String browser = ConfigReader.READ("browser");
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
               /* ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);*/
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;


            default:
                throw new RuntimeException("The name of browser is invalid" + browser);
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.READ("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        ACTIVATE_PAGE_OBJECTS();

    }

    public static void SHUT_DOWN_BROWSER() {
        if (driver != null) {
            driver.close();
        }
    }

    public String GET_TIME_STAMP(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);

    }

    public byte[] TAKE_SCREENSHOT(String fileName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " + GET_TIME_STAMP("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }


    public static WebDriverWait GET_WAIT() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    public static void CLICK_ON_ELEMENT(WebElement element) {
        WAIT_FOR_ELEMENT_TO_BE_CLICKABLE(element);
        element.click();
    }

    public static void WAIT_FOR_ELEMENT_TO_BE_CLICKABLE(WebElement element) {
        GET_WAIT().until(ExpectedConditions.elementToBeClickable(element));
    }
}
