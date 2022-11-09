package example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestGit {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://github.com/");

        //getTitle
        System.out.println(driver.getTitle());

        //getCurrentUrl
        System.out.println(driver.getCurrentUrl());

        //click and search to Search GitHub
        driver.findElement(By.xpath("//form[@role=\"search\"]//input[@type=\"text\"]")).click();
        driver.findElement(By.xpath("//form[@role=\"search\"]//input[@type=\"text\"]"))
                .sendKeys("SQL", Keys.ENTER);

        //Click to Sigh In , getAttribute(), getText()
        WebElement signIn = driver.findElement(By.xpath("//div[@class=\"position-relative mr-lg-3 d-lg-inline-block\"]/a"));
        System.out.println(signIn.getAttribute("namespaceURI"));
        System.out.println(signIn.getText());
        signIn.click();

        //try to log in
        driver.findElement(By.name("login")).sendKeys("rusanovschi1994@gmail.com", Keys.TAB);
        driver.findElement(By.id("password")).sendKeys("1111");
        driver.findElement(By.name("commit")).submit();

        Thread.sleep(3000);

        //get ProvectaPos
        driver.get("https://provectapos.com/app/#/login");
        System.out.println(driver.getTitle());

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.quit();
    }
}
