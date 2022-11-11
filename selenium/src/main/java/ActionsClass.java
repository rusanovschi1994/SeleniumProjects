import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsClass {

    static Actions actions;
    static WebDriver driver;
    static WebDriverWait driverWait;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        actions = new Actions(driver);

        driverWait = (new WebDriverWait(driver, Duration.ofSeconds(5)));
        driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("draggable")));

        actions
                .moveToElement(dragElement)
                .clickAndHold()
                .moveToElement(dropElement)
                .release()
                .build()
                .perform();
    }

    public static void setDriver(String url){

        String nameUrl = url;
        driver.get(nameUrl);
        driver.manage().window().maximize();
    }
}
