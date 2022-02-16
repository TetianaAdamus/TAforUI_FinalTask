package loremipsum.manager;

import loremipsum.pages.GeneratedPage;
import loremipsum.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    WebDriver driver;

    public HomePage getHomePage(){
        return new HomePage();
    }

    public GeneratedPage getGeneratePage(){
        return new GeneratedPage();
    }
}
