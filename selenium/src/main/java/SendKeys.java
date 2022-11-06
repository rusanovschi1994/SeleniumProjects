import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SendKeys {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.udemy.com/");

        WebElement inputElement = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        inputElement.click();
        inputElement.sendKeys("Java", Keys.ENTER);


        WebElement selectCourse = driver.findElement(By.xpath("//a[@href=\"/course/neutrino-java-foundations/\"]"));
        selectCourse.click();

    }
}
