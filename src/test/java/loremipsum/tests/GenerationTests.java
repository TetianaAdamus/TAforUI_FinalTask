package loremipsum.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import loremipsum.pages.BusinessLogicLayer;

public class GenerationTests extends BaseTest {

    public static final long TIME_TO_WAIT = 20;
    public static final String WORD_TO_CHECK = "рыба";
    public static final String LOREM_START = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    public static final int INPUT_AMOUNT = 10;
    public static final String RADIO_OPTION_WORD = "words";
    public static final String RADIO_OPTION_BYTE = "bytes";
    public static final String WORDS_START = "Lorem ipsum";
    public static final String SEARCH_WORD = "lorem";
    public final BusinessLogicLayer businessLogicLayer = new BusinessLogicLayer(driver);
    public BusinessLogicLayer businessLogicLayer1;



    @Test
    public void checkChangedText(){ // так працює
        getBusinessLogicLayerPage().chooseLanguge();
        getBusinessLogicLayerPage().waitVisibilityOfElement(TIME_TO_WAIT, getBusinessLogicLayerPage().generatedPage.getRussianFirstParagraphElement());
        assertTrue(getBusinessLogicLayerPage().getFirstParagraph().contains(WORD_TO_CHECK));
    }

    @Test
    public void checkChangedText2(){ //NullPointerException
        businessLogicLayer.chooseLanguge();
        businessLogicLayer.waitForPageLoadComplete(TIME_TO_WAIT);
        assertTrue(businessLogicLayer.getFirstParagraph().contains(WORD_TO_CHECK));
    }

    @Test
    public void checkChangedText3(){ // так працює
        businessLogicLayer1 = new BusinessLogicLayer(driver);
        businessLogicLayer1.chooseLanguge();
        businessLogicLayer1.waitVisibilityOfElement(TIME_TO_WAIT, businessLogicLayer1.generatedPage.getRussianFirstParagraphElement());
        assertTrue(businessLogicLayer1.getFirstParagraph().contains(WORD_TO_CHECK));
    }

    @Test
    public void checkTextStarts(){
        getBusinessLogicLayerPage().implicitWait(TIME_TO_WAIT);
        getBusinessLogicLayerPage().clickGenerationButton();
        assertTrue(getBusinessLogicLayerPage().getFirstParagraphStarts(LOREM_START));
    }

    @Test
    public void checkWordGeneration(){
        getBusinessLogicLayerPage().textGeneration(RADIO_OPTION_WORD, INPUT_AMOUNT);
        assertEquals(getBusinessLogicLayerPage().generationTextLength(), INPUT_AMOUNT);
    }

    @Test
    public void checkByteGeneration() {
        getBusinessLogicLayerPage().textGeneration(RADIO_OPTION_BYTE, INPUT_AMOUNT);
        assertEquals(getBusinessLogicLayerPage().generationWordLength(), INPUT_AMOUNT);

    }
    @Test
    public void checkGenerationTextBeginning(){
        getBusinessLogicLayerPage().checkboxClear();
        getBusinessLogicLayerPage().clickGenerationButton();
        getBusinessLogicLayerPage().waitForPageLoadComplete(TIME_TO_WAIT);
        assertFalse(getBusinessLogicLayerPage().getFirstParagraphStarts(WORDS_START));
    }

    @Test
    public void checkWordInGeneratedText(){
        assertTrue(getBusinessLogicLayerPage().checkTextContainsWord(SEARCH_WORD, LIPSUM_URL,TIME_TO_WAIT)>=2);
    }




}
