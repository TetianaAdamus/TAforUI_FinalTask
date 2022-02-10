package bbc1.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FormTests extends BaseTest {

    @DataProvider(name = "dataForForm")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"", "name", "email", "number", "Kyiv", "20"},
                {"text", "name", "", "number", "", ""},
        };
    }

    @Test(dataProvider = "dataForForm")
    public void checkForm(String text, String name, String email, String number, String location, String age) {
        businessLogicLayer.fillQuestionForm(text, name, email, number, location, age);
        assertTrue(businessLogicLayer.inputErrorMessage().contains("can't be blank")
                || businessLogicLayer.inputErrorMessage().contains("matches another recent question"));
    }

    @Test
    public void checkFormCheckbox() {
        businessLogicLayer.fillQuestionForm("text", "name", "email", "number", "location", "age");
        businessLogicLayer.clickCheckbox();
        assertTrue(businessLogicLayer.inputErrorMessage().contains("can't be blank")
                || businessLogicLayer.inputErrorMessage().contains("matches another recent question"));
    }

}
