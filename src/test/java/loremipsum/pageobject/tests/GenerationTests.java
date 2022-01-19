package loremipsum.pageobject.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GenerationTests extends BaseTest {

    public static final long TIME_TO_WAIT = 30;
    public static final String WORD_TO_CHECK = "рыба";
    public static final String LOREM_START = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    public static final int INPUT_AMOUNT = 10;
    public static final String RADIO_OPTION_WORD = "words";
    public static final String RADIO_OPTION_BYTE = "bytes";
    public static final String WORDS_START = "Lorem ipsum";
    public static final String SEARCH_WORD = "lorem";



    @Test
    public void checkChangedText(){
        getBBLPage().chooseLanguge();
        getBBLPage().waitForPageLoadComplete(TIME_TO_WAIT);
        assertTrue(getBBLPage().getFirstParagraph().contains(WORD_TO_CHECK));
    }

    @Test
    public void checkTextStarts(){
        getBBLPage().waitImplicity(TIME_TO_WAIT);
        getBBLPage().clickGenerationButton();
        assertTrue(getBBLPage().getFirstParagraphStarts(LOREM_START));
    }

    @Test
    public void checkWordGeneration(){
        getBBLPage().textGeneration(RADIO_OPTION_WORD, INPUT_AMOUNT);
        assertEquals(getBBLPage().generationTextLength(), INPUT_AMOUNT);
    }

    @Test
    public void checkByteGeneration() {
        getBBLPage().textGeneration(RADIO_OPTION_BYTE, INPUT_AMOUNT);
        assertEquals(getBBLPage().generationWordLength(), INPUT_AMOUNT);

    }
    @Test
    public void checkGenerationTextBeginning(){
        getBBLPage().checkboxClear();
        getBBLPage().clickGenerationButton();
        getBBLPage().waitForPageLoadComplete(TIME_TO_WAIT);
        assertFalse(getBBLPage().getFirstParagraphStarts(WORDS_START));
    }

    @Test
    public void checkWordInGeneratedText(){
        assertTrue(getBBLPage().checkTextContainsWord(SEARCH_WORD, LIPSUM_URL,TIME_TO_WAIT)>=2);
    }


}
