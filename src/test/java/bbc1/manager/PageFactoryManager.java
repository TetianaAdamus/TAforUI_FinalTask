package bbc1.manager;

import bbc1.pages.*;

public class PageFactoryManager {

    public HomePage getHomePage(){
        return new HomePage();
    }

    public NewsPage getNewsPage(){
        return new NewsPage();
    }

    public FormPage getFormPage(){
        return new FormPage();
    }

    public CoronavirusPage getCoronavirusPage(){
        return new CoronavirusPage();
    }

    public SearchResultsPage getSearchResultsPage(){
        return new SearchResultsPage();
    }
}
