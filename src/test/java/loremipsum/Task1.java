package loremipsum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.assertEquals;
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
        driver.get("https://www.lipsum.com/");
    }

    @Test
    public void choseRussianLanguage() {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(), 'Pyccкий')]"));
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        assertTrue(driver.findElement(By.xpath("//div[@id='Panes']/div[1]/p")).getText().contains("рыба"));
    }

    @Test
    public void LoremIpsumStart() {
        WebElement element = driver.findElement(By.xpath("//input[@value='Generate Lorem Ipsum']"));
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        assertTrue(driver.findElement(By.xpath("//div[@id='lipsum']/p[1]")).getText().startsWith("Lorem ipsum dolor sit amet, consectetur adipiscing elit"));
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
