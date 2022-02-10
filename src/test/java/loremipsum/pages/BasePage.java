package loremipsum.pages;

import org.openqa.selenium.support.PageFactory;
import utils.DriverSingleton;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverSingleton.getDriver(), this);
    }




}
