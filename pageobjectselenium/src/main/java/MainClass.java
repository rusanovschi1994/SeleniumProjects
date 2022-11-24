import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainClass {

    private static WebDriver driver;

    public static void main(String[] args) {

        getDriver("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignUp();

        SignUpPage signUpPage = new SignUpPage(driver);
        WebDriverWait webDriverWait = (new WebDriverWait(driver, Duration.ofSeconds(3)));
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("username1@gmail.com");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-optimizely-event=\"click.signup_continue.email\"]")));
        driver.findElement(By.xpath("//button[@data-optimizely-event=\"click.signup_continue.email\"]")).click();

        //LoginPage loginPage = new LoginPage(driver);
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        loginPage.loginWithInvalidCreds("rusanov@gmail.com", "andrei1111");
    }

    public static void getDriver(String url){

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }
}
