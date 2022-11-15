import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By usernameField = By.xpath("//input[@id=\"login_field\"]");
    private final By passwordField = By.xpath("//input[@id=\"password\"]");
    private final By signInButton = By.xpath("//input[@type=\"submit\"]");
    private final By heading = By
            .xpath("//div[contains(@class, 'auth-form-header')]/h1[text() = \"Sign in to GitHub\"]");
    private final By loginError = By.xpath("//div[@id=\"js-flash-container\"]//div[@role=\"alert\"]");
    private final By createAccountLink = By.xpath("//a[text()=\"Create an account\"]");


    public LoginPage typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return new LoginPage(driver);
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return new LoginPage(driver);
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){

        return driver.findElement(heading).getText();
    }

    public String getLoginErrorText(){

        return driver.findElement(loginError).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccountLink).click();
        return new SignUpPage(driver);
    }
}
