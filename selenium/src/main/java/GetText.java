import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetText {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\selenium\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/all/transport");

        WebElement element = driver.findElement(By.cssSelector(".page-title-text-tSffu.page-title-inline-zBPFx"));
        String par = element.getText();

        System.out.println(par);

    }
}
