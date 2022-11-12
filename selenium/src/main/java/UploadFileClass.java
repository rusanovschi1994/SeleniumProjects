import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UploadFileClass {

    static WebDriver driver;

    public static void main(String[] args) {

        getChromeDriver("https://images.google.com/");

        driver.findElement(By.xpath("//div[@aria-label=\"Căutare după imagine\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"file\"]"))
                .sendKeys("C:\\drivers\\selenium\\screenshot.png");
    }

    public static void getChromeDriver(String url){

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
}
