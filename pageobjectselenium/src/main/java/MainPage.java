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


    public SignInPage clickSignIn(){
        driver.findElement(singInButton).click();
        return new SignInPage(driver);
    }

    public SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage signUpForm(){
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage registration(String email){
        this.typeEmail(email);
        this.signUpForm();
        return new SignUpPage(driver);
    }

    public SearchPage typeToSearch(String text){
        driver.findElement(searchGitHub).sendKeys(text, Keys.ENTER);
        return new SearchPage(driver);
    }
}
