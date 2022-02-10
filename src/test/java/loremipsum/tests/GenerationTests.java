package loremipsum.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import utils.Waiter;

public class GenerationTests extends BaseTest {

    public static final String WORD_TO_CHECK = "рыба";
    public static final String LOREM_START = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    public static final String RADIO_OPTION_WORD = "words";
    public static final String RADIO_OPTION_BYTE = "bytes";
    public static final String WORDS_START = "Lorem ipsum";
    public static final String SEARCH_WORD = "lorem";


    @Test
    public void checkChangedText() {
        businessLogicLayer.chooseLanguage();
        Waiter.waitVisibilityOfElement(businessLogicLayer.generatedPage.getRussianFirstParagraphElement());
        assertTrue(businessLogicLayer.getFirstParagraph().contains(WORD_TO_CHECK));
    }

    @Test
    public void checkTextStarts() {
        Waiter.implicitWait();
        businessLogicLayer.clickGenerationButton();
        assertTrue(businessLogicLayer.getFirstParagraphStarts(LOREM_START));
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {10},
                {1},
                {0},
                {5},
                {20}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void checkWordGeneration(int numberInput) {
        businessLogicLayer.textGeneration(RADIO_OPTION_WORD, numberInput);
        assertEquals(businessLogicLayer.generationTextLength(), numberInput);
    }

    @Test(dataProvider = "dataProvider")
    public void checkByteGeneration(int numberInput) {
        businessLogicLayer.textGeneration(RADIO_OPTION_BYTE, numberInput);
        assertEquals(businessLogicLayer.generationWordLength(), numberInput);

    }

    @Test
    public void checkGenerationTextBeginning() {
        businessLogicLayer.checkboxClear().clickGenerationButton();
        Waiter.waitForPageLoadComplete();
        assertFalse(businessLogicLayer.getFirstParagraphStarts(WORDS_START));
    }

    @Test
    public void checkWordInGeneratedText() {
        assertTrue(businessLogicLayer.checkTextContainsWord(SEARCH_WORD, LIPSUM_URL) >= 2);
    }

}
