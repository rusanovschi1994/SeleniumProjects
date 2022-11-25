import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.String.format;

public class SignUpPage {

    private WebDriver driver;
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

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpPage typeEmail(String email){

        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email){

        driver.findElement(confirmEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password){

        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeDisplayName(String displayName){

        driver.findElement(displayNameField).sendKeys(displayName);
        return this;
    }

    public SignUpPage setDay(String day){

        driver.findElement(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage setMonth(String month){

        driver.findElement(monthDropDown).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(format(optionMonthDropDown, month)))).click();
        return this;
    }

    public SignUpPage setYear(String year){

        driver.findElement(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setGender(String gender){

        driver.findElement(By.xpath(format(genderRadioButton, gender))).click();
        return this;
    }

    public SignUpPage setShareCheckBox(boolean value){

        WebElement checkBox = driver.findElement(shareCheckBox);
        if(!checkBox.isSelected() == value){
            checkBox.click();
        }

        return this;
    }

    public SignUpPage setNotReceiveCheckBox(boolean value){

        WebElement checkBox = driver.findElement(notReceiveMessCheckBox);
        if(!checkBox.isSelected() == value){

            checkBox.click();
        }

        return this;
    }

    public SignUpPage setAgreeCheckBox(boolean value){

        WebElement checkBox = driver.findElement(agreeCheckBox);
        if(!checkBox.isSelected() == value){

            checkBox.click();
        }

        return this;
    }

    public void clickSignUpButton(){

        WebElement button = driver.findElement(signUpButton);

        new Actions(driver)
                .moveToElement(button)
                .click(button)
                .build()
                .perform();
    }

    public List<WebElement> getErrors(){

       return driver.findElements(errorLabel);
    }

    public String getErrorByNumber(int number){

        return driver.findElements(errorLabel).get(number - 1).getText();
    }

    public boolean isErrorVisible(String message){

        return driver.findElements(By.xpath(format(errorByText, message))).size() > 0
                && driver.findElements(By.xpath(format(errorByText, message))).get(0).isDisplayed();
    }
}
