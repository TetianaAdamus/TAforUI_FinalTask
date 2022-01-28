package loremipsum.pageobject.tests;


import loremipsum.pageobject.pages.BBL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    WebDriver driver;
    public static final String LIPSUM_URL = "https://www.lipsum.com/";

    @BeforeTest
    public void driverSetUp() {
        chromedriver().setup();
    }


    @BeforeMethod
    public void testsSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LIPSUM_URL);
    }


    @AfterTest
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
