import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SignUpSteps;

@RunWith(SerenityRunner.class)
public class WhenSignUp {

    @Steps
    private SignUpSteps step;

    @Managed
    private WebDriver driver;

    public WhenSignUp(SignUpSteps step, WebDriver driver) {
        this.step = step;
        this.driver = driver;
    }

    @Test
    public void typeInvalidYear(){

        step.open_page_signup();
        step.set_day("11");
        step.set_month("December");
        step.set_year("99");
        step.select_gender("Male");
        step.should_see_error("Enter a valid year.");
        step.should_not_see_error("Enter a name for your profile.");
    }

    @Test
    public void typeInvalidConfirmEmail(){

        step.open_page_signup();
        step.type_email("rusanovschi1994@mail.ru");
        step.type_confirmation_email("rus@gmail.com");
        step.type_password("1111");
        step.type_name("Cristi");
        step.should_see_error("The email addresses don't match.");
    }

    @Test
    public void signUpWithEmptyPassword(){

        step.open_page_signup();
        step.type_email("sadasdasd");
        step.type_confirmation_email("sdwwwwrwer");
        step.type_name("Test");
        step.should_not_see_error("You need to enter a password.");
    }

    @Test
    public void typeInvalidValues(){

        step.open_page_signup();
        step.type_email("sdasdas@");
        step.type_confirmation_email("ttt@gmaiul");
        step.type_password("1111");
        step.type_name("123");
        step.set_day("12");
        step.set_month("December");
        step.set_year("99");
        step.select_gender("Male");
        step.set_share(true);
        step.set_agree_policy(true);
        step.should_see_error_size(4);
        step.should_see_error_by_number("Your password is too short.", 3);
        }
}
