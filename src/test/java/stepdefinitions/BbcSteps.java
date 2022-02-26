package stepdefinitions;

import bbc1.manager.PageFactoryManager;
import bbc1.pages.*;
import io.cucumber.java.Before;


public class BbcSteps {
    private PageFactoryManager pageFactoryManager;
    private HomePage homePage;
    private NewsPage newsPage;
    private FormPage formPage;
    private CoronavirusPage coronavirusPage;
    private SearchResultsPage searchResultsPage;

    @Before
    public void testsSetUp() {
        pageFactoryManager = new PageFactoryManager();

    }
}
