import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.FileDetector;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.FileHandler;

public class SendKeys {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        getChromeDriver("http://wiki.microinvest.su/");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id=\"searchInput\"]"));
        String select = Keys.chord(Keys.CONTROL + "a");
        String cut = Keys.chord(Keys.CONTROL + "x");
        String paste = Keys.chord(Keys.CONTROL + "v");

        searchInput.sendKeys("noLogo");
        searchInput.sendKeys(select);
        Thread.sleep(2000);
        searchInput.sendKeys(cut);
        Thread.sleep(3000);
        searchInput.sendKeys(paste, Keys.ENTER);
        Thread.sleep(4000);

        //Take screenshot
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        String dataFormat = "screenshot_" + format.format(data) + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\drivers\\selenium\\" + dataFormat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    public static void getChromeDriver(String url){

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
}
