package loremipsum.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {
    private static final String RUSSIAN = "//a[contains(text(), 'Pyccкий')]";
    private static final String GENERATE_BUTTON = "//input[@value='Generate Lorem Ipsum']";
    private static final String INPUT_FIELD = "//input[@id='amount']";
    private static final String CHECKBOX = "//input[@type='checkbox']";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void changeLanguage(){
        driver.findElement(By.xpath(RUSSIAN)).click();
    }

    public void radioClick(String value){
        RadioButton radioButton = new RadioButton(driver);
        radioButton.SetValue(value);
    }

    public void generationButtonClick(){
        driver.findElement(By.xpath(GENERATE_BUTTON)).click();
    }

    public void putAmount(int amount){
        WebElement element = driver.findElement(xpath(INPUT_FIELD));
        if (element.getAttribute("value") != "") {
            element.clear();
        }
        element.sendKeys(String.valueOf(amount));
    }

    public void clearCheckbox(){
        driver.findElement(By.xpath(CHECKBOX)).click();
    }

}

 class RadioButton extends BasePage {

    private static final String RADIO_BUTTON = "//input[@type='radio']";


    public RadioButton(WebDriver driver) {
        super(driver);
    }

    public void SetValue(String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(RADIO_BUTTON))));
        if (value.equals("paragraphs") || value.equals("words") || value.equals("bytes") || value.equals("lists")) {
            if (value.equals("paragraphs")) {
                value = "paras";}
            List<WebElement> list = driver.findElements(By.xpath(RADIO_BUTTON));
            for (WebElement element:list) {
                if (element.getAttribute("value").equals(value)){
                    element.click();
                }
            }
        }
        else  throw new IllegalArgumentException("Choose correct value from list");
    }

}
