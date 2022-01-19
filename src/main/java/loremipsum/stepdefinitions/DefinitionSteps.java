package loremipsum.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import loremipsum.manager.PageFactoryManager;
import loremipsum.pagefactory.pages.GeneratedPage;
import loremipsum.pagefactory.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 45;

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    GeneratedPage generatedPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @After
    public void tearDown() {
        driver.close();
    }


}
