package bbc1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//nav[@role='navigation'] //a[contains(text(), 'News')]")
    WebElement newsLink;

    public NewsPage goToNewsItem() {
        newsLink.click();
        return new NewsPage();
    }

}
