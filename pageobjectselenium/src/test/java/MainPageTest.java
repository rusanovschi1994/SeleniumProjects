import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainPageTest {

    private WebDriver driver;
    private MainPage main;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        main = new MainPage(driver);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = main.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void signUpTest(){
        SignUpPage signUpPage = main.clickSignUp();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Welcome to GitHub! Let's begin the adventure", heading);
    }

    @Test
    public void loginWithInvalidCredsTest(){
        LoginPage loginPage = main.clickSignIn();
        loginPage.loginWithInvalidCreds("test123", "qweqweqwe");
        String error = loginPage.getLoginErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void signUpWithInvalidEmail(){
        SignUpPage signUpPage = main.registrationForm("andrei@gmail.com");
        String errorEmail = signUpPage.getErrorEmail();
        Assert.assertEquals("Email is invalid or already taken", errorEmail);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
