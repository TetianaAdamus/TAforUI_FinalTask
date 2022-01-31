package loremipsum;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.*;

public class Task2 {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver.get("https://www.lipsum.com/");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {10},
                {1},
                {0},
                {5},
                {20}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void checkWordGeneration(int numberInput) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(xpath("//input[@id='words']")).click();
        WebElement element = driver.findElement(xpath("//input[@id='amount']"));
        if (!element.getAttribute("value").equals("")) {
            element.clear();
        }
        element.sendKeys(String.valueOf(numberInput));
        driver.findElement(xpath("//input[@value='Generate Lorem Ipsum']")).click();
        int wordsNumber = driver.findElement(xpath("//div[@id='lipsum']/p[1]")).getText().split(" ").length;
        assertEquals(wordsNumber, numberInput);
    }

    @Test(dataProvider = "dataProvider")
    public void checkByteGeneration(int numberInput) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(xpath("//input[@id='bytes']")).click();
        WebElement element = driver.findElement(xpath("//input[@id='amount']"));
        if (element.getAttribute("value") != "") {
            element.clear();
        }
        element.sendKeys(String.valueOf(numberInput));
        driver.findElement(xpath("//input[@value='Generate Lorem Ipsum']")).click();
        int wordsNumber = driver.findElement(xpath("//div[@id='lipsum']/p[1]")).getText().length();
        assertEquals(wordsNumber, numberInput);
    }


    @Test
    public void checkLoremInputStart() {
        driver.findElement(xpath("//input[@type='checkbox']")).click();
        driver.findElement(xpath("//input[@value='Generate Lorem Ipsum']")).click();
        assertFalse(driver.findElement(xpath("//div[@id='lipsum']/p[1]")).getText().startsWith("Lorem ipsum"));
    }

    @Test
    public void checkTextContainsWordLorem() {
        int loremAverage = 0;
        for (int i = 0; i < 10; i++) {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            driver.findElement(xpath("//input[@value='Generate Lorem Ipsum']")).click();
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            List<WebElement> elementList = driver.findElements(xpath("//div[@id='lipsum']/p"));
            int loremNumber = 0;
            for (WebElement paragraph : elementList) {
                if (paragraph.getText().trim().toLowerCase().contains("lorem")) {
                    loremNumber = loremNumber + 1;
                }
            }
            loremAverage = loremAverage + loremNumber;
            driver.navigate().to("https://www.lipsum.com/");
        }
        assertTrue(loremAverage / 10 >= 2);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
