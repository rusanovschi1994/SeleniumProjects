import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest(){
        loginPage.loginWithInvalidCreds("", "");
        String error = loginPage.getLoginErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCredsTest(){
        loginPage.loginWithInvalidCreds("errr", "124d");
        String error = loginPage.getLoginErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccountTest(){
        SignUpPage signUp = loginPage.createAccount();
        String headingText = signUp.getHeadingText();
        Assert.assertEquals("Welcome to GitHub! Let's begin the adventure", headingText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
