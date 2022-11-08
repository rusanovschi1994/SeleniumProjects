import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClickAndSendKeys {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//input[@id=\"email\"]")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("+37368218536", Keys.TAB);

        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("12345678");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div/button[@type=\"submit\"]")).submit();
        Thread.sleep(3000);

        driver.get("https://github.com/");
        WebElement signIn = driver.findElement(By.xpath("//div[@class=\"position-relative mr-lg-3 d-lg-inline-block\"]/a"));
        System.out.println(signIn.getText());
        signIn.click();

        WebElement createGitAccount = driver.findElement(By.xpath("//div[@id=\"login\"]//a[text()=\"Create an account\"]"));
        System.out.println(createGitAccount.getAttribute("href"));
        createGitAccount.click();

    }
}
