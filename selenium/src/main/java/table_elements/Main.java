package table_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

    public static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        setDriver("https://www.w3schools.com/html/html_tables.asp");

        WebElement tableElement = driver.findElement(By.xpath("//table[@id=\"customers\"]"));

        Table table = new Table(tableElement, driver);

        System.out.println("Rows number is: " + table.getRows().size());

        //getValueFromCell(int rowNumber, int columnNumber)
        System.out.println(table.getValueFromCell(3, 2));
        System.out.println(table.getValueFromCell(5, 1));

        //getValueFromCell(int rowNumber, String columnName)
        System.out.println(table.getValueFromCell(4, "Contact"));
        System.out.println(table.getValueFromCell(6, "Country"));
        System.out.println(table.getValueFromCell(2, "Company"));

        driver.quit();
    }

    public static void setDriver(String url){

        String nameUrl = url;
        driver.get(nameUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
