import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignUpPageTest {

    private SignUpPage page;
    private WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.spotify.com/md-ru/signup");
        page = new SignUpPage(driver);
    }

    @Test
    public void typeInvalidYear(){

        page
                .setDay("11")
                .setMonth("December")
                .setYear("99")
                .setGender("Male");
        Assert.assertTrue(page.isErrorVisible("Enter a valid year."));
        Assert.assertFalse(page.isErrorVisible("Enter a name for your profile."));
    }

    @Test
    public void typeInvalidConfirmEmail(){

        page
                .typeEmail("rusanovschi1994@mail.ru")
                .typeConfirmEmail("rus@gmail.com")
                .typePassword("1111")
                .typeDisplayName("Cristi");
        Assert.assertTrue(page.isErrorVisible("The email addresses don't match."));
    }

    @Test
    public void signUpWithEmptyPassword(){

        page
                .typeEmail("sadasdasd")
                .typeConfirmEmail("sdwwwwrwer")
                .typeDisplayName("Test");

        Assert.assertFalse(page.isErrorVisible("You need to enter a password."));
    }

    @Test
    public void typeInvalidValues(){

        page
                .typeEmail("sdasdas@")
                .typeConfirmEmail("ttt@gmaiul")
                .typePassword("1111")
                .typeDisplayName("123")
                .setDay("12")
                .setMonth("December")
                .setYear("99")
                .setAgreeCheckBox(true)
                .setShareCheckBox(true)
                .setGender("Female");
        Assert.assertEquals(4, page.getErrors().size());
        Assert.assertEquals("Your password is too short.", page.getErrorByNumber(3));
    }

    @After
    public void tearDown(){

        driver.quit();
    }
}
