import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By singInButton = By.xpath("//a[contains(text(), 'Sign in')]");
    private By signUpButton = By.xpath("//a[contains(text(), 'Sign in')]/parent::div/following-sibling::a");
    private By searchGitHub = By.xpath("//input[@aria-label=\"Search GitHub\"]");
    private By emailField = By.id("user_email");
    private By signUpFormButton = By.xpath("//button[@type=\"submit\"]");


    public LoginPage clickSignIn(){
        driver.findElement(singInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage signUpFormWithEmail(){
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage registrationForm(String email){
        this.typeEmail(email);
        this.signUpFormWithEmail();
        return new SignUpPage(driver);
    }

    public SearchPage typeToSearch(String text){
        driver.findElement(searchGitHub).sendKeys(text, Keys.ENTER);
        return new SearchPage(driver);
    }
}
