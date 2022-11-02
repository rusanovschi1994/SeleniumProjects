import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        //find google input element
        WebElement inputElement = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        inputElement.click();
        inputElement.sendKeys("Java");

        //find google search element
        WebElement searchElement = driver.findElement(By.xpath("//input[@class='gNO89b'][@name='btnK']"));
        searchElement.click();
    }
}
