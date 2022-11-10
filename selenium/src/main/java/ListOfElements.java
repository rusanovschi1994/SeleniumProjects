import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class ListOfElements {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        setDriver("https://atehno.md/");

        driver.findElement(By.xpath("//div[@class=\"catalog-menu-link\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"nav-catalog_categories animated fadeIn\"]//a[text()=\"Телефоны\"]/following-sibling::span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class=\"col-xs-3\"]//span[text()=\"Мобильные телефоны\"])[1]")).click();

        List<WebElement> checkBox = driver.findElements(By.xpath("//h3[text()=\"Количество ядер процессора\"]/following-sibling::ul//input[@type=\"checkbox\"]/parent::div"));

        if(checkBox.size() == 7){
            System.out.println("It's OK");
        }else{
            System.out.println("FAIL");
        }
    }

    public static void setDriver(String url){

        String nameUrl = url;
        driver.get(nameUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }


}
