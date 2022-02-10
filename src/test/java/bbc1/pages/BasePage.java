package bbc1.pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSingleton;
import utils.Waiter;

import java.util.List;

public class BasePage {
    @FindBy(xpath = "//button[@aria-label='Close']")
    List<WebElement> popUpElement;

    public BasePage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }

    public void closePopup() {
        Waiter.waitForPageLoadComplete();
        if(popUpElement.size()>0)
        popUpElement.get(0).click();
    }
}
