import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttribute {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.avito.ru/");

        WebElement element = driver.findElement(By.xpath("//a[text()='Одежда, обувь и аксессуары']"));
        String par1 = element.getAttribute("offsetWidth");
        String par2 = element.getAttribute("href");


        System.out.println(par2);
    }
}
