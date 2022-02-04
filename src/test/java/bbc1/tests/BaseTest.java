package bbc1.tests;

import bbc1.pages.BusinessLogicLayer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.DriverSingleton;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    WebDriver driver;
    public BusinessLogicLayer businessLogicLayer;

    public static final String BBC_URL = "https://www.bbc.com/";

    @BeforeTest
    public void driverSetUp() {
        chromedriver().setup();
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        businessLogicLayer = new BusinessLogicLayer(driver);
    }


    @BeforeMethod
    public void testsSetUp(){
        driver.get(BBC_URL);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

