package bbc1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),'Your Coronavirus Stories')]")
    WebElement yourCoronavirusStoriesItem;

    @FindBy(xpath = "//a[@href='/news/52143212']")
    WebElement goToQuestionForm;

    public CoronavirusPage yourCoronavirusStoriesTab() {
        yourCoronavirusStoriesItem.click();
        return new CoronavirusPage();
    }

    public FormPage goToFormPage() {
        goToQuestionForm.click();
        return new FormPage();
    }
}
