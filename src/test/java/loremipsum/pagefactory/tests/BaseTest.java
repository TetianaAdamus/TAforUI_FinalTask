package loremipsum.pagefactory.tests;


import loremipsum.pagefactory.pages.BBL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    WebDriver driver;
    public static final String LIPSUM_URL = "https://www.lipsum.com/";

    @BeforeMethod
    public void driverSetUp() {
        chromedriver().setup();
    }


    @BeforeMethod
    public void testsSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LIPSUM_URL);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    public WebDriver getDriver() {
        return driver;
    }

    public BBL getBBLPage(){
        return new BBL(driver);
    }


}
