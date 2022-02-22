package loremipsum.manager;

import loremipsum.pages.GeneratedPage;
import loremipsum.pages.HomePage;

public class PageFactoryManager {


    public HomePage getHomePage(){
        return new HomePage();
    }

    public GeneratedPage getGeneratePage(){
        return new GeneratedPage();
    }
}


