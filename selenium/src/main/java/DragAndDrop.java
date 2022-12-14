import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
            Thread.sleep(2000);

            WebElement dragElement = driver.findElement(By.id("draggable"));
            WebElement dropElement = driver.findElement(By.id("droppable"));

            Actions action = new Actions(driver);

            //old_method
            action
                    .moveToElement(dragElement)
                    .clickAndHold()
                    .pause(Duration.ofSeconds(2))
                    .moveToElement(dropElement)
                    .release()
                    .build()
                    .perform();

//            //new method
//            action
//                    .dragAndDrop(dragElement, dropElement)
//                    .build()
//                    .perform();

            driver.get("https://github.com/");
            Thread.sleep(3000);
            driver.navigate().back();
            Thread.sleep(3000);
            driver.navigate().forward();
            Thread.sleep(4000);
            driver.navigate().refresh();

            //getTitle(), getCurrentUrl()
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
