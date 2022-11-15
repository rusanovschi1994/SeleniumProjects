import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headingText = By.xpath("//div[contains(@class, 'm-4')]/h1");
    private By emailField = By.xpath("//input[@id=\"email\"]");
    private By continueButton = By.xpath("//div[contains(@class, 'd-flex flex-items-center flex-column')]/button");
    private By passwordField = By.xpath("//input[@id=\"password\"]");

}
