import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserWindows {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        setDriver("https://signup.live.com/?lic=1");

        driver.findElement(By.xpath("//a[text()=\"Get a new email address\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"MemberName\"]")).sendKeys("sdaddasdaskfasfkkka");
        driver.findElement(By.xpath("//input[@type=\"submit\" and @value=\"Next\"]")).click();
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()=\"Microsoft Services Agreement\"]")).click();
        for(String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }

        driver.findElement(By.xpath("//a[text()=\"Bing Suppliers Page\"]")).click();

        driver.switchTo().window(mainWindow);
        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("12345");
    }

    public static void setDriver(String url){

        String nameUrl = url;
        driver.get(nameUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
