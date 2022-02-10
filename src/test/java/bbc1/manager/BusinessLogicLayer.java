package bbc1.manager;

import bbc1.pages.*;

import java.util.List;

public class BusinessLogicLayer {
    private final HomePage homePage = new HomePage();
    private final NewsPage newsPage = new NewsPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();
    private final FormPage formPage = new FormPage();


    public String getHeadArticleTitle() {
        homePage.goToNewsItem();
        return newsPage.headArticleTitle();
    }

    public void closeNewsPopup() {
        homePage.goToNewsItem()
                .closePopup();
    }

    public List<String> getActualTitles() {
        return newsPage.actualTitlesList();
    }

    public List<String> getExpectedTitles() {
        return newsPage.expectedTitlesList();
    }

    public boolean searchByCategory() {
        closeNewsPopup();
        String category = newsPage.getCategoryText();
        newsPage.searchByWord(category);
        String firstFoundTitle = searchResultsPage.firstFoundTitleString();
        if (category.contains("&")) {
            int index = category.indexOf('&');
            String firstWord = category.substring(0, index).trim();
            String secondWord = category.substring(index + 1).trim();
            return (firstFoundTitle.contains(firstWord) || firstFoundTitle.contains(secondWord));
        } else return (firstFoundTitle.contains(category));
    }


    public void fillQuestionForm(String text, String name, String email, String number, String location, String age) {
        homePage.goToNewsItem()
                .goToCoronavirusPage()
                .yourCoronavirusStoriesTab()
                .goToFormPage()
                .closePopup();
        formPage.formToTest(text, name, email, number, location, age);
    }

    public String inputErrorMessage() {
        return formPage.inputErrorMessageText();
    }

    public void clickCheckbox() {
        formPage.CheckboxClick();
    }
}
