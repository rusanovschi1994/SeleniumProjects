import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class SignUpPageTest {

    private SignUpPage page;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        baseUrl = "https://www.spotify.com/md-ru/signup";
        browser = "chrome";
    }

    @Test
    public void typeInvalidYear(){

        page = new SignUpPage();
        page
                .open()
                .setDay("11")
                .setMonth("December")
                .setYear("99")
                .setGender("Male");
        page.getError("Enter a valid year.").shouldBe(visible);
        page.getError("Enter a name for your profile.").shouldNotBe(visible);
    }

    @Test
    public void typeInvalidConfirmEmail(){

        page = new SignUpPage();
        page
                .typeEmail("rusanovschi1994@mail.ru")
                .typeConfirmEmail("rus@gmail.com")
                .typePassword("1111")
                .typeDisplayName("Cristi");
        page.getError("The email addresses don't match.").shouldBe(visible);
    }

    @Test
    public void signUpWithEmptyPassword(){

        page = new SignUpPage();
        page
                .open()
                .typeEmail("sadasdasd")
                .typeConfirmEmail("sdwwwwrwer")
                .typeDisplayName("Test");

        page.getError("You need to enter a password.").shouldNotBe(visible);
    }

    @Test
    public void typeInvalidValues(){

        page = new SignUpPage();
        page
                .open()
                .typeEmail("sdasdas@")
                .typeConfirmEmail("ttt@gmaiul")
                .typePassword("1111")
                .typeDisplayName("123")
                .setDay("12")
                .setMonth("December")
                .setYear("2020");
                //.setAgreeCheckBox(true);
                //.setShareCheckBox(true)
                //.setGender("Female");

        page.getErrors().shouldHave(size(3));
        page.getErrorByNumber(3).shouldHave(text("Your password is too short."));
    }
}
