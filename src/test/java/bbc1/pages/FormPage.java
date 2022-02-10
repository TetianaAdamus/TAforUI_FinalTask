package bbc1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'text-input__input') or contains(@class, 'text-input--long')]")
    List<WebElement> fieldsList;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//button[@class='button']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='input-error-message']")
    WebElement inputErrorMessage;


    public Map<String, String> MapForForm(String text, String name, String email, String number, String location, String age) {
        Map<String, String> map = new HashMap<>();
        map.put("question", text);
        map.put("name", name);
        map.put("email", email);
        map.put("number", number);
        map.put("location", location);
        map.put("age", age);
        return map;
    }

    public void formToTest(String text, String name, String email, String number, String location, String age) {
        FillForm fillForm = new FillForm();
        fillForm.fillForm(MapForForm(text, name, email, number, location, age));
    }

    public String inputErrorMessageText() {
        Waiter.waitVisibilityOfElement(inputErrorMessage);
        return inputErrorMessage.getText();
    }

    public void CheckboxClick() {
        checkbox.click();
    }


    class FillForm {
        public void fillForm(Map<String, String> map) {
            for (WebElement field : fieldsList) {
                if (field.getAttribute("placeholder").equals("What questions would you like us to answer?")) {
                    field.sendKeys(map.get("question"));
                }
                if (field.getAttribute("placeholder").equals("Name")) {
                    field.sendKeys(map.get("name"));
                }
                if (field.getAttribute("placeholder").equals("Email address")) {
                    field.sendKeys(map.get("email"));
                }
                if (field.getAttribute("placeholder").equals("Contact number")) {
                    field.sendKeys(map.get("number"));
                }
                if (field.getAttribute("placeholder").equals("Location")) {
                    field.sendKeys(map.get("location"));
                }
                if (field.getAttribute("placeholder").equals("Age")) {
                    field.sendKeys(map.get("age"));
                }
            }
            checkbox.click();
            submitButton.click();
        }
    }
}
