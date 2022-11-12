import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IsEnabledIsSelectedIsDisplayed {

    static WebDriver driver;
    static Actions action;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);

//        setDriver("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_disabled");
//        WebElement el2 = driver.findElement(By.id("runbtn"));
//
//        System.out.println(el2.isEnabled());
//
//        if(el2.isEnabled())
//            el2.click();
        setDriver("https://darwin.md/ru");
        WebElement el1 = driver.findElement(By.xpath("//span[text()=\"Все категории\"]"));
        WebElement el2 = driver.findElement(By.xpath("//a[@class=\"sub-menu \"]/span[text()=\"Apple\"]"));
        System.out.println(el1.isDisplayed());
        System.out.println(el2.isDisplayed());

        if(!el2.isDisplayed()){
            action.moveToElement(el1).build().perform();
            System.out.println("After actions: " + el2.isDisplayed());
        }

    }

    public static void setDriver(String url){

        String nameUrl = url;
        driver.get(nameUrl);
        driver.manage().window().maximize();
    }
}
