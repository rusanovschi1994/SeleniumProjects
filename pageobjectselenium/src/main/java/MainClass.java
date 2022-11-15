import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainClass {

    private static WebDriver driver;

    public static void main(String[] args) {

        getDriver("https://github.com/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignIn();

        //LoginPage loginPage = new LoginPage(driver);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginWithInvalidCreds("rusanov@gmail.com", "andrei1111");
    }

    public static void getDriver(String url){

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
}
