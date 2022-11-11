import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDown {

    static WebDriver driver;
    static WebDriverWait driverWait;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        setDriver("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@role=\"button\" and text()=\"Create new account\"]")).click();

        driverWait = (new WebDriverWait(driver, Duration.ofSeconds(5)));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"mbs _52lq fsl fwb fcb\"]")));
        driverWait.until(ExpectedConditions.titleContains("Facebook"));

        //complete registration data
        completeRegistrationData("First name", "Vitalie");
        completeRegistrationData("Last name", "Tiltu");
        completeRegistrationData("email", "rusanovschi1994@gmail.com");
        completeRegistrationData("Re-enter email", "rusanovschi1994@gmail.com");
        completeRegistrationData("password", "password1111");


        //select Birthday
        selectOption("Month", "Sep");
        selectOption("Day", "4");
        selectOption("Year", "1994");

        //select gender
        selectGenderButton("Male");

        driver.findElement(By.xpath("//div[@class=\"_1lch\"]/button[text()=\"Sign Up\"]")).click();
    }

    public static void setDriver(String url){

        String nameUrl = url;
        driver.get(nameUrl);
        driver.manage().window().maximize();
        //Implicit wait
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void selectOption(String listName, String option){
        String listXpath = String.format("//span[@class=\"_5k_4\"]/span/select[@title=\"%s\"]", listName);
        String optionXpath = String.format(listXpath + "/option[text()=\"%s\"]", option);

        driver.findElement(By.xpath(listXpath)).click();
        driverWait
                .until(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(By.xpath(String.format("//select[@title=\"%s\"]/option", listName))));
        driver.findElement(By.xpath(optionXpath)).click();
    }

    public static void completeRegistrationData(String field, String writeData){

        String fieldXpath = String.format("//input[@class=\"inputtext _58mg _5dba _2ph-\" and contains(@aria-label, '%s')]", field);

        driverWait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fieldXpath)));
        driver.findElement(By.xpath(fieldXpath)).sendKeys(writeData);
    }

    public static void selectGenderButton(String gender){

        String genderXpath = String.format("//span[@class=\"_5k_3\"]//label[text()=\"%s\"]", gender);
        driver.findElement(By.xpath(genderXpath)).click();
    }
}


