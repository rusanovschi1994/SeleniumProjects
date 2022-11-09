import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckBoxAndRadioButton {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        driver("https://www.pandashop.md/");

        driver.findElement(By.xpath("//span[text()=\"Каталог товаров\"]")).click();
        driver.findElement(By.xpath("//span[text()=\"Автотовары\"]/parent::a")).click();
        driver.findElement(By.xpath("//div[text()=\"Шины, диски, аккумуляторы\"]//ancestor::div[@class=\"categoriesList-item-inner\"]/preceding-sibling::a"))
                .click();
        driver.findElement(By.xpath("//div[text()=\"Шины\"]//ancestor::div[@class=\"categoriesList-item-inner\"]/preceding-sibling::a"))
                .click();

        try {
            Thread.sleep(3000);
            selectCheckBox("Ardent");
            Thread.sleep(3000);
            selectCheckBox("Belshina");
            Thread.sleep(3000);
            unselectCheckBox("Ardent");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()=\"Шина Belshina Artmotion Snow HP Bel-494 225/60 R18\"]/parent::a"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()=\"Купить\"]/parent::div"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class=\"btn btn-green w-100\"]/parent::div"))
                .click();

        Thread.sleep(10000);
        driver.quit();
    }

    public static void selectCheckBox(String name){

        String xPath = "//a[text()=\"%s\"]/ancestor::span/preceding-sibling::input";
        if(!driver.findElement(By.xpath(String.format(xPath, name))).isSelected()){
            driver.findElement(By.xpath(String.format(xPath, name))).click();
        }
    }

    public static void unselectCheckBox(String name){
        String xPath = "//a[text()=\"%s\"]/ancestor::span/preceding-sibling::input";
        if(driver.findElement(By.xpath(String.format(xPath, name))).isSelected()){
            driver.findElement(By.xpath(String.format(xPath, name))).click();
        }
    }

    public static void driver(String url){

      driver.get(url);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
