import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DropDown {

    private static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        setDriver("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@role=\"button\" and text()=\"Create new account\"]")).click();

        //complete registration data
        completeRegistrationData("First name", "Vitalie");
        completeRegistrationData("Last name", "Tiltu");
        completeRegistrationData("email", "tiltu@gmail.com");
        completeRegistrationData("Re-enter email", "tiltu@gmail.com");
        completeRegistrationData("password", "1111");


        //select Birthday
        selectOption("Month", "Sep");
        selectOption("Day", "4");
        selectOption("Year", "1994");

        //select gender

        selectGenderButton("Male");
    }

    public static void setDriver(String url){

        String nameUrl = url;
        driver.get(nameUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void selectOption(String listName, String option){

        String listXpath = String.format("//span/select[@title=\"%s\"]", listName);
        String optionXpath = String.format(listXpath + "/option[text()=\"%s\"]", option);

        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        driver.findElement(By.xpath(listXpath)).click();
    }

    public static void completeRegistrationData(String field, String writeData){

        String fieldXpath = String.format("//input[@class=\"inputtext _58mg _5dba _2ph-\" and contains(@aria-label, '%s')]", field);

        try {
            driver.findElement(By.xpath(fieldXpath)).sendKeys(writeData);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectGenderButton(String gender){

        String genderXpath = String.format("//span[@class=\"_5k_3\"]//label[text()=\"%s\"]", gender);
        driver.findElement(By.xpath(genderXpath)).click();
    }
}


