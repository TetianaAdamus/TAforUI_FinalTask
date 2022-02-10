package bbc1.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NewsTests extends BaseTest {

    @Test
    public void checkHeadArticleTitle() {
        assertEquals(businessLogicLayer.getHeadArticleTitle(), "Truss in tense Moscow talks as UK pushes diplomacy");
    }

    @Test
    public void checkSecondaryArticlesTitles() {
        businessLogicLayer.closeNewsPopup();
        for (String title : businessLogicLayer.getExpectedTitles()) {
            assertTrue(businessLogicLayer.getActualTitles().contains(title));
        }
    }

    @Test
    public void checkSearchField() {
        assertTrue(businessLogicLayer.searchByCategory());
    }

}
