import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

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
