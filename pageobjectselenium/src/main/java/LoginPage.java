import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.xpath("//input[@id=\"login_field\"]");
    private By passwordField = By.xpath("//input[@id=\"password\"]");
    private By signInButton = By.xpath("//input[@type=\"submit\"]");
    private By heading = By.xpath("//div[contains(@class, 'auth-form-header')]/h1");
    private By loginError = By.xpath("//div[@id=\"js-flash-container\"]//div[@role=\"alert\"]");
    private By createAccountLink = By.xpath("//a[text()=\"Create an account\"]");


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

    public String getLoginError(){
        return driver.findElement(loginError).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccountLink).click();
        return new SignUpPage(driver);
    }
}
