import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class DefaultUnitTest {
    public static void main(String[] args) {
        chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.bbc.com");
        driver.close();

    }

}



