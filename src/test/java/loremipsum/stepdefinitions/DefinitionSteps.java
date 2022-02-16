package loremipsum.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import loremipsum.manager.PageFactoryManager;
import loremipsum.pages.GeneratedPage;
import loremipsum.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.DriverSingleton;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class DefinitionSteps {
    WebDriver driver;

    PageFactoryManager pageFactoryManager;

    HomePage homePage;
    GeneratedPage generatedPage;

    @Before
    public void testsSetUp() {
        WebDriver driver = DriverSingleton.getDriver();
        pageFactoryManager = new PageFactoryManager(driver);

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

    @When("User chooses the Russian language")
    public void chooseRussianLanguage() {
        homePage.changeLanguage();
    }
}
