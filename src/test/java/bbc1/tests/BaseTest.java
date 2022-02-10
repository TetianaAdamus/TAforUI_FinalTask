package bbc1.tests;

import bbc1.manager.BusinessLogicLayer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.DriverSingleton;

public class BaseTest {
    public BusinessLogicLayer businessLogicLayer;
    public static final String BBC_URL = "https://www.bbc.com/";

    @BeforeTest
    public void driverSetUp() {
        DriverSingleton.getDriver();
        businessLogicLayer = new BusinessLogicLayer();
    }


    @BeforeMethod
    public void testsSetUp() {
        DriverSingleton.openPage(BBC_URL);
    }


    @AfterTest
    public void tearDown() {
        DriverSingleton.tearDown();
    }
}

