import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();

        setDriver("https://www.udemy.com/");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("confirm('Do you want to leave?')");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver
                .switchTo()
                .alert()
                .accept();
    }

    public static void setDriver(String url){

        String nameUrl = url;
        driver.get(nameUrl);
        driver.manage().window().maximize();
    }
}
