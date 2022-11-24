import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.basic.BasicButtonUI;
import java.time.Duration;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

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

    private final By errorUsername = By
            .xpath("//p[@id=\"login-err\"]//div[contains(text(), 'Username')]");

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
        //setWebDriverWait(registerEmailButton);
        driver.findElement(registerEmailButton).click();
        return this;
    }

    public SignUpPage registerContinueWithPassword(String password){
        this.typePassword(password);
        //setWebDriverWait(registerPasswordButton);
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

    public String getErrorUsername(){

        return driver.findElement(errorUsername).getText();
    }

    public WebDriverWait setWebDriverWait(By field){
        webDriverWait = (new WebDriverWait(driver, Duration.ofSeconds(10)));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(field));
        return webDriverWait;
    }
}
