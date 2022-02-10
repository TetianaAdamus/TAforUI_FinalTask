package loremipsum.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

import java.util.List;


public class HomePage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Pyccкий')]")
    WebElement russian;

    @FindBy(xpath = "//input[@value='Generate Lorem Ipsum']")
    WebElement generateButton;

    @FindBy(xpath = "//input[@id='amount']")
    WebElement inputField;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> radioButtonList;

    public void changeLanguage() {
        russian.click();
    }

    public HomePage radioClick(String value) {
        RadioButton radioButton = new RadioButton();
        radioButton.SetValue(value);
        return new HomePage();
    }

    public void generationButtonClick() {
        generateButton.click();
    }

    public HomePage putAmount(int amount) {
        if (inputField.getAttribute("value") != "") {
            inputField.clear();
        }
        inputField.sendKeys(String.valueOf(amount));
        return new HomePage();
    }

    public void clearCheckbox() {
      Waiter.waitElementIsClickable(checkbox);
        checkbox.click();
    }

    class RadioButton {

        public void SetValue(String value) {
            Waiter.waitForPageLoadComplete();
            if (value.equals("paragraphs") || value.equals("words") || value.equals("bytes") || value.equals("lists")) {
                if (value.equals("paragraphs")) {
                    value = "paras";
                }
                for (WebElement element : radioButtonList) {
                    if (element.getAttribute("value").equals(value)) {
                        element.click();
                    }
                }
            } else throw new IllegalArgumentException("Choose correct value from list");
        }
    }
}
