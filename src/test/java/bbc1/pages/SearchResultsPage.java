package bbc1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//p[@class='ssrcss-6arcww-PromoHeadline e1f5wbog4']")
    WebElement firstFoundTitle;

    public String firstFoundTitleString() {
        return firstFoundTitle.getText();
    }
}
