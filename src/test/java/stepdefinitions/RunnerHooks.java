package stepdefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import util.DriverSingleton;

public class RunnerHooks {
    @BeforeAll
    public static void testsSetUp() {
        DriverSingleton.getDriver();

    }

    @AfterAll
    public static void driverTearDown() {
        DriverSingleton.tearDown();
    }
}
