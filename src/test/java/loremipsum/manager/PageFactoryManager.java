package loremipsum.manager;

import loremipsum.pages.GeneratedPage;
import loremipsum.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.DriverSingleton;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public GeneratedPage getGeneratePage(){
        return new GeneratedPage(driver);
    }
}


