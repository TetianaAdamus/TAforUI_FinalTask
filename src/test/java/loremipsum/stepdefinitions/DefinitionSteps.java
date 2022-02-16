package loremipsum.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import loremipsum.manager.PageFactoryManager;
import loremipsum.pages.GeneratedPage;
import loremipsum.pages.HomePage;
import org.openqa.selenium.WebDriver;
import util.DriverSingleton;


public class DefinitionSteps {

    PageFactoryManager pageFactoryManager;

    HomePage homePage;
    GeneratedPage generatedPage;

    @Before
    public void testsSetUp() {
        WebDriver driver = DriverSingleton.getDriver();
        pageFactoryManager = new PageFactoryManager();
    }

    @After
    public void tearDown() {
        DriverSingleton.tearDown();
    }

    @Given("User opens Home page")
    public void openPage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage();
    }




}
