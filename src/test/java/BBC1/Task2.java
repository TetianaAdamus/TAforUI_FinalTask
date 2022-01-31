package BBC1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.assertEquals;

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
        driver.get("https://www.bbc.com/");
    }

    @Test
    public void checkRequestSubmission(){
        driver.findElement(By.xpath("//nav[@role='navigation'] //a[contains(text(), 'News')]")).click();
        driver.findElement(By.xpath("//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']//a[@href='/news/coronavirus'] ")).click();
        driver.findElement(By.xpath("//li[contains(@class,'gs-o-list-ui__item--flush gel-long-primer')]//span[text()='Your Coronavirus Stories']")).click();
        driver.findElement(By.xpath("//a[@href='/news/52143212']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        if (driver.findElements(By.xpath("//button[@aria-label='Close']")).size()>0){
            driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Name']")));
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Tania");
        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("tania.adamus@com");
        driver.findElement(By.xpath("//input[@placeholder='Contact number']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@placeholder='Location ']")).sendKeys("Kyiv");
        driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("20");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='input-error-message']")));
        assertEquals(driver.findElement(By.xpath("//div[@class='input-error-message']")).getText().trim(), "can't be blank");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
