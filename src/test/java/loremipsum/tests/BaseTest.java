package loremipsum.tests;


import loremipsum.pages.BusinessLogicLayer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.DriverSingleton;

public class BaseTest {
    WebDriver driver;
    public BusinessLogicLayer businessLogicLayer;
    public static final String LIPSUM_URL = "https://www.lipsum.com/";

    @BeforeTest
    public void driverSetUp() {
        driver = DriverSingleton.getDriver();
        businessLogicLayer = getBusinessLogicLayer();
    }

    @BeforeMethod
    public void testsSetUp(){
        driver.get(LIPSUM_URL);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public BusinessLogicLayer getBusinessLogicLayer() {
        return new BusinessLogicLayer(driver);
    }
}
