package BBC1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.assertTrue;

public class Task1 {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
    }

    @Test
    public void choseRussianLanguage() {
        WebElement element = driver.findElement(By.xpath("//a[contains(@href,'http://ru.lipsum.com')]"));
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        assertTrue(driver.findElement(By.xpath("//div[@id='Panes']/div[1]")).getText().contains("рыба"));
    }




    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
