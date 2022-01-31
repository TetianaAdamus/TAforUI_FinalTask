package loremipsum.pages;

import org.openqa.selenium.WebDriver;

public class BusinessLogicLayer extends BasePage {
    public final HomePage homePage = new HomePage(driver);
    public final GeneratedPage generatedPage = new GeneratedPage(driver);

    public BusinessLogicLayer(WebDriver driver) {
        super(driver);
    }

    public void chooseLanguge() {
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
        homePage.radioClick(value);
        homePage.putAmount(amountInput);
        homePage.generationButtonClick();
    }

    public int generationTextLength() {
        return generatedPage.wordsInGeneratedText();
    }

    public int generationWordLength() {
        return generatedPage.bytesInGeneratedText();
    }

    public void checkboxClear(){
        homePage.clearCheckbox();
    }

    public int checkTextContainsWord(String word, String url, long timeToWait) {
        int loremAverage = 0;
        for (int i = 0; i < 10; i++) {
            waitForPageLoadComplete(timeToWait);
            homePage.generationButtonClick();
            waitForPageLoadComplete(timeToWait);
            loremAverage = loremAverage +generatedPage.paragraphsContainWord(word);
            driver.navigate().to(url);
        }
        return loremAverage / 10;
    }
}



