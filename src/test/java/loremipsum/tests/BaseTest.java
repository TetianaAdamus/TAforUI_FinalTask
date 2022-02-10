package loremipsum.tests;


import loremipsum.manager.BusinessLogicLayer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.DriverSingleton;

public class BaseTest {
    public BusinessLogicLayer businessLogicLayer;
    public static final String LIPSUM_URL = "https://www.lipsum.com/";

    @BeforeTest
    public void driverSetUp() {
        DriverSingleton.getDriver();
        businessLogicLayer = getBusinessLogicLayer();
    }

    @BeforeMethod
    public void testsSetUp() {
        DriverSingleton.openPage(LIPSUM_URL);
    }


    @AfterTest
    public void driverTearDown() {
        DriverSingleton.tearDown();
    }

    public BusinessLogicLayer getBusinessLogicLayer() {
        return new BusinessLogicLayer();
    }
}
