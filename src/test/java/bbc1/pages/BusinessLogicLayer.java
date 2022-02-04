package bbc1.pages;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class BusinessLogicLayer extends BasePage{
    public final HomePage homePage = new HomePage(driver);
    public final NewsPage newsPage = new NewsPage(driver);

    public BusinessLogicLayer(WebDriver driver) {
        super(driver);
    }

    public String getHeadArticleTitle(){
        homePage.goToNewsItem();
        return newsPage.headArticleTitle();
    }

    public void goToNews(){
        homePage.goToNewsItem();
    }

//    public void closeNewsPopup(){
//        homePage.goToNewsItem();
//        newsPage.closePopup();
//    }

    public List<String> getActualTitles(){
        return newsPage.actualTitlesList();
    }

    public List<String> getExpectedTitles(){
        return newsPage.expectedTitlesList();
    }




}
