import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id=\"login_field\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class, 'auth-form-header')]/h1")
    private WebElement heading;

    @FindBy(xpath = "//div[@id=\"js-flash-container\"]//div[@role=\"alert\"]")
    private WebElement loginError;

    @FindBy(xpath = "//a[text()=\"Create an account\"]")
    private WebElement createAccountLink;


    public LoginPage typeUsername(String username){
        usernameField.sendKeys(username);
        return new LoginPage(driver);
    }

    public LoginPage typePassword(String password){
        passwordField.sendKeys(password);
        return new LoginPage(driver);
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        signInButton.click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return heading.getText();
    }

    public String getLoginError(){

        return loginError.getText();
    }

    public SignUpPage createAccount(){
        createAccountLink.click();
        return new SignUpPage(driver);
    }
}
