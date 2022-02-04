package bbc1.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends BasePage{
    @FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")
    WebElement headArticle;

    @FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    List<WebElement> actualTitleElementsList;

    @FindBy(xpath = "//button[@aria-label='Close']")
    WebElement popUpElement;

    @FindBy(xpath = "//button[@aria-label='Close']")
    List <WebElement> popUpElementsList;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String headArticleTitle(){
        return headArticle.getText().trim();
    }

    public List<String> actualTitlesList(){
        List<String> actualTitleList = new ArrayList<>();
        for (WebElement elem : actualTitleElementsList) {
            actualTitleList.add(elem.getText());
        }
        return actualTitleList;
    }

    public List<String> expectedTitlesList(){
        List<String> expectedTitleList = new ArrayList<>();
        expectedTitleList.add("Ukraine leader praises West's response on Russia");
        expectedTitleList.add("NFL legend Brady confirms retirement");
        expectedTitleList.add("Amnesty report calls Israel an apartheid state");
        expectedTitleList.add("Ros Atkins on... the UK government parties report");
        expectedTitleList.add("Denmark lifts almost all Covid restrictions");
        expectedTitleList.add("Wind forces plane to abort landing at London airport");
        expectedTitleList.add("NZ to allow in pregnant reporter helped by Taliban");
        expectedTitleList.add("US locks down all federal prisons after gang fight");
        expectedTitleList.add("Wordle inventor 'overwhelmed' as game is sold");
        expectedTitleList.add("US locks down all federal prisons after gang fight");
        return expectedTitleList;
    }

//    public void closePopup(){
//            Wait.waitElementIsClickable(popUpElement);
//            popUpElement.click();
//    }

}
