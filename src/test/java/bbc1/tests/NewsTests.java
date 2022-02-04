package bbc1.tests;

import bbc1.pages.BusinessLogicLayer;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class NewsTests extends BaseTest{

    public final String HEAD_ARTICLE_TITLE = "Islamic State leader killed in Syria raid, US says";

    @Test
    public void checkHeadArticleTitle(){
        assertEquals(businessLogicLayer.getHeadArticleTitle(), HEAD_ARTICLE_TITLE);

    }

//    @Test
//    public void checkSecondaryArticlesTitles() {
//        businessLogicLayer.closeNewsPopup();
//        for (String title : businessLogicLayer.getExpectedTitles()) {
//            assertTrue(businessLogicLayer.getActualTitles().contains(title));
//        }
//    }

}
