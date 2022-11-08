import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElement {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://en.wikipedia.org/wiki/Moldova");

        WebElement linkedTextElement = driver.findElement(By.linkText("Main page"));
        WebElement partialLinkElement = driver.findElement(By.partialLinkText("About "));
        WebElement nameSearchElement = driver.findElement(By.name("search"));
        WebElement classSearchButtonElement = driver.findElement(By.className("searchButton"));
        WebElement idElement = driver.findElement(By.id("ca-history"));
        WebElement tagNameElement = driver.findElement(By.tagName("input"));

        WebElement cssSelectorElement = driver.findElement(By.cssSelector("div#simpleSearch > input[type='search"));
        WebElement xPathElement = driver.findElement(By.xpath("//div[@id=\"mw-panel\"]/div[@id]/a"));

        driver.quit();
    }
}
