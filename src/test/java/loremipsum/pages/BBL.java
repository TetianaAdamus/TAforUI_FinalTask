package loremipsum.pages;

import org.openqa.selenium.WebDriver;
import util.Waiter;

public class BBL extends BasePage {
    public BBL(WebDriver driver) {
        super(driver);
    }


//    public void chooseLanguge() {
//        HomePage homePage = new HomePage(driver);
//        homePage.changeLanguage();
//    }
//
//    public String getFirstParagraph() {
//        GeneratedPage generatedPage = new GeneratedPage(driver);
//        return generatedPage.getRussianFirstParagraph();
//    }
//
//    public void clickGenerationButton() {
//        HomePage homePage = new HomePage(driver);
//        homePage.generationButtonClick();
//    }
//
//    public boolean getFirstParagraphStarts(String word) {
//        GeneratedPage generatedPage = new GeneratedPage(driver);
//        return generatedPage.getFirstParagraphText().startsWith(word);
//    }
//
//
//    public void textGeneration(String value, int amountInput) {
//        HomePage homePage = new HomePage(driver);
//        homePage.radioClick(value);
//        homePage.putAmount(amountInput);
//        homePage.generationButtonClick();
//    }
//
//    public int generationTextLength() {
//        GeneratedPage generatedPage = new GeneratedPage(driver);
//        return generatedPage.wordsInGeneratedText();
//    }
//
//    public int generationWordLength() {
//        GeneratedPage generatedPage = new GeneratedPage(driver);
//        return generatedPage.bytesInGeneratedText();
//    }
//
//    public void checkboxClear(){
//        HomePage homePage = new HomePage(driver);
//        homePage.clearCheckbox();
//    }
//
//    public int checkTextContainsWord(String word, String url, long timeToWait) {
//        int loremAverage = 0;
//        for (int i = 0; i < 10; i++) {
//            HomePage homePage = new HomePage(driver);
//            Waiter.waitForPageLoadComplete(timeToWait);
//            homePage.generationButtonClick();
//            GeneratedPage generatedPage = new GeneratedPage(driver);
//            Waiter.waitForPageLoadComplete(timeToWait);
//            loremAverage = loremAverage +generatedPage.paragraphsContainWord(word);
//            driver.navigate().to(url);
//        }
//        return loremAverage / 10;
//    }
}



