package loremipsum.tests;


import loremipsum.pages.BusinessLogicLayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    WebDriver driver;
    public static final String LIPSUM_URL = "https://www.lipsum.com/";

    @BeforeMethod
    public void driverSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @BeforeMethod
    public void testsSetUp(){
        driver.get(LIPSUM_URL);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public BusinessLogicLayer getBusinessLogicLayerPage(){
        return new BusinessLogicLayer(driver);
    }


}
