package loremipsum.manager;

import loremipsum.pagefactory.pages.GeneratedPage;
import loremipsum.pagefactory.pages.HomePage;
import org.openqa.selenium.WebDriver;

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
