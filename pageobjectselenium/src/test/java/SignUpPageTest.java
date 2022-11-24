import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://github.com/signup");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithInvalidEmail(){
        signUpPage.registerContinueWithEmail("aaa");
        String emailError = signUpPage.getErrorEmail();
        Assert.assertEquals("Email is invalid or already taken", emailError);
    }

//    @Test
//    public void signUpWithInvalidPassword(){
//        signUpPage.registerContinueWithEmail("username1@gmail.com");
//        signUpPage.registerContinueWithPassword("1111");
//        String passwordError = signUpPage.getErrorPassword();
//        Assert.assertEquals("Password is too short", passwordError);
//    }

//    @Test
//    public void signUpWithInvalidUsername(){
//        signUpPage.registerContinueWithEmail("username1@gmail.com");
//        signUpPage.registerContinueWithPassword("65464ASHHHDD!!@asdfwr");
//        signUpPage.registerContinueWithUsername("username!");
//        String usernameError = signUpPage.getErrorUsername();
//        Assert
//            .assertEquals("Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen.", usernameError);
//    }

    @After
    public void tearDown(){

        driver.quit();
    }

}
