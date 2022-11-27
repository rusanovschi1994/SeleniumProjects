import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;

public class SignUpPage {

    private final By emailField = By.cssSelector("input#email");
    private final By confirmEmailField = By.cssSelector("input#confirm");
    private final By passwordField = By.cssSelector("input#password");
    private final By displayNameField = By.cssSelector("input#displayname");
    private final By dayField = By.cssSelector("input#day");
    private final By monthDropDown = By.cssSelector("select#month");
    private String optionMonthDropDown = "//select[@id=\"month\"]/option[text()=\"%s\"]";
    private final By yearField = By.cssSelector("input#year");
    private String genderRadioButton = "//label[contains(@for, \"gender_option\")]/span[text()=\"%s\"]";
    private String errorByText = "//div[@aria-label=\"Error indicator\" and text()=\"%s\"]";
    private final By errorLabel
            = By.xpath("//div[@aria-label=\"Error indicator\" and string-length(text())>0]|//div[@aria-label=\"Error indicator\"]/span");
    private final By notReceiveMessCheckBox = By.xpath("//label[@for=\"marketing-opt-checkbox\"]/span[2]");
    private final By shareCheckBox = By.xpath("//label[@for=\"third-party-checkbox\"]//span[2]/span");
    private final By agreeCheckBox = By.xpath("//label[@for=\"privacy-policy-checkbox\"]//span[2]/span");
    private final By signUpButton = By.xpath("//button[@type=\"submit\"]");

    public SignUpPage open(){

        Selenide.open("/");
        return this;
    }

    public SignUpPage typeEmail(String email){

        $(emailField).setValue(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email){

        $(confirmEmailField).setValue(email);
        return this;
    }

    public SignUpPage typePassword(String password){

        $(passwordField).setValue(password);
        return this;
    }

    public SignUpPage typeDisplayName(String displayName){

        $(displayNameField).setValue(displayName);
        return this;
    }

    public SignUpPage setDay(String day){

        $(dayField).setValue(day);
        return this;
    }

    public SignUpPage setMonth(String month){

        $(monthDropDown).selectOption(month);
        return this;
    }

    public SignUpPage setYear(String year){

        $(yearField).setValue(year);
        return this;
    }

    public SignUpPage setGender(String gender){

        $(By.xpath(format(genderRadioButton, gender))).click();
        return this;
    }

    public SignUpPage setShareCheckBox(boolean value){

        $(shareCheckBox).setSelected(true);
        return this;
    }

    public SignUpPage setNotReceiveCheckBox(boolean value){

        $(notReceiveMessCheckBox).setSelected(value);
        return this;
    }

    public SignUpPage setAgreeCheckBox(boolean value){

        $(agreeCheckBox).setSelected(value);
        return this;
    }

    public void clickSignUpButton(){

        $(signUpButton).pressEnter();
    }

    public ElementsCollection getErrors(){

       return $$(errorLabel);
    }

    public SelenideElement getErrorByNumber(int number){

        return $$(errorLabel).get(number - 1);
    }

    public boolean isErrorVisible(String message){

        return $(By.xpath(format(errorByText, message))).isDisplayed();
    }

    public SelenideElement getError(String message){

        return $(By.xpath(format(errorByText, message)));
    }
}
