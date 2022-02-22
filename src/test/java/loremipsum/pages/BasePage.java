package loremipsum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.DriverSingleton;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }



}
