import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By headingText = By.xpath("//div[contains(@class, 'm-4')]/h1");
    private final By emailField = By.xpath("//input[@id=\"email\"]");
    private final By passwordField = By.xpath("//input[@id=\"password\"]");
    private final By usernameField = By.xpath("//input[@id=\"login\"]");
    private final By registerEmailButton = By
            .xpath("//button[@data-optimizely-event=\"click.signup_continue.email\"]");
    private final By registerPasswordButton = By
            .xpath("//button[@data-optimizely-event=\"click.signup_continue.password\"]");
    private final By registerUsernameButton = By
            .xpath("//button[@data-optimizely-event=\"click.signup_continue.username\"]");
    private final By errorEmail = By
            .xpath("//div[contains(@class, 'js-continue-hint-container')]//p[text()=\"Email is invalid or already taken\"]");
    private final By errorPassword = By
            .xpath("//p[@id=\"password-err\"]/p[contains(@class, 'password-validity-summary')]");

    public SignUpPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public SignUpPage registerContinueWithEmail(String email){
        this.typeEmail(email);
        driver.findElement(registerEmailButton).click();
        return this;
    }

    public SignUpPage registerContinueWithPassword(String password){
        this.typePassword(password);
        driver.findElement(registerPasswordButton).click();
        return this;
    }

    public SignUpPage registerContinueWithUsername(String username){
        this.typeUsername(username);
        driver.findElement(registerUsernameButton).click();
        return this;
    }

    public String getHeadingText(){
        return driver.findElement(headingText).getText();
    }

    public String getErrorEmail(){
        return driver.findElement(errorEmail).getText();
    }

    public String getErrorPassword(){
        return driver.findElement(errorPassword).getText();
    }
}
