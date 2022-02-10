package loremipsum.manager;

import loremipsum.pages.GeneratedPage;
import loremipsum.pages.HomePage;
import utils.DriverSingleton;
import utils.Waiter;

public class BusinessLogicLayer {

    public final HomePage homePage = new HomePage();
    public final GeneratedPage generatedPage = new GeneratedPage();


    public void chooseLanguage() {
        homePage.changeLanguage();
    }

    public String getFirstParagraph() {
        return generatedPage.getRussianFirstParagraph();
    }

    public void clickGenerationButton() {
        homePage.generationButtonClick();
    }

    public boolean getFirstParagraphStarts(String word) {
        return generatedPage.getFirstParagraphText().startsWith(word);
    }


    public void textGeneration(String value, int amountInput) {
        homePage.radioClick(value)
                .putAmount(amountInput)
                .generationButtonClick();
    }

    public int generationTextLength() {
        return generatedPage.wordsInGeneratedText();
    }

    public int generationWordLength() {
        return generatedPage.bytesInGeneratedText();
    }

    public BusinessLogicLayer checkboxClear() {
        homePage.clearCheckbox();
        return new BusinessLogicLayer();
    }

    public int checkTextContainsWord(String word, String url) {
        int loremAverage = 0;
        for (int i = 0; i < 10; i++) {
            Waiter.waitForPageLoadComplete();
            homePage.generationButtonClick();
            Waiter.waitForPageLoadComplete();
            loremAverage = loremAverage + generatedPage.paragraphsContainWord(word);
            DriverSingleton.getDriver().navigate().to(url);
        }
        return loremAverage / 10;
    }
}



