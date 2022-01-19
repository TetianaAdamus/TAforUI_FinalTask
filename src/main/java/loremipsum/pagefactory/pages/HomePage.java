package loremipsum.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage {
    @FindBy (xpath = "//a[contains(text(), 'Pyccкий')]")
    WebElement russian;

    @FindBy(xpath = "//input[@value='Generate Lorem Ipsum']")
    WebElement generateButton;

    @FindBy(xpath = "//input[@id='amount']")
    WebElement inputField;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkbox;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void changeLanguage(){
        russian.click();
    }

    public void radioClick(String value){
        RadioButton radioButton = new RadioButton(driver);
        radioButton.SetValue(value);
    }

    public void generationButtonClick(){
        generateButton.click();
    }

    public void putAmount(int amount){
        if (inputField.getAttribute("value") != "") {
            inputField.clear();
        }
        inputField.sendKeys(String.valueOf(amount));
    }

    public void clearCheckbox(){
        waitElementIsClicable(60,checkbox);
        checkbox.click();
    }
}

class RadioButton extends BasePage {

    @FindBy(xpath = "//input[@type='radio']")
    List <WebElement> radioButtonList;

 public RadioButton(WebDriver driver) {
       super(driver);
   }

   public void SetValue(String value) {
     waitForPageLoadComplete(30);
       if (value.equals("paragraphs") || value.equals("words") || value.equals("bytes") || value.equals("lists")) {
           if (value.equals("paragraphs")) {
               value = "paras";}
           for (WebElement element:radioButtonList) {
               if (element.getAttribute("value").equals(value)){
                   element.click();
               }
           }
       }
       else  throw new IllegalArgumentException("Choose correct value from list");
   }

}
