import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsClass {

    static WebDriver driver;
    static JavascriptExecutor jsExecutor;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        getChromeDriver("https://github.com/");

        List<WebElement> listElements = driver.findElements(By.xpath("//a[@href=\"/logins\"]"));
        System.out.println(listElements.size());

        if(listElements.size() > 0){
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("alert('Elements is found')");

        }else{
            jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("alert('elements is not found')");
        }
    }

    public static void getChromeDriver(String url){

        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
}
