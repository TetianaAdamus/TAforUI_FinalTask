package loremipsum.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverSingleton;

import java.time.Duration;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }


}
