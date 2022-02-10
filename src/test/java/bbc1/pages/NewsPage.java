package bbc1.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")
    WebElement headArticle;

    @FindBy(xpath = "//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    List<WebElement> actualTitleElementsList;

    @FindBy(xpath = "//a[contains(@class,'gs-c-section-link gs-c-section-link--truncate')]")
    WebElement category;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    WebElement searchField;

    @FindBy(xpath = "//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']//a[@href='/news/coronavirus']")
    WebElement coronavirusItem;


    public String headArticleTitle() {
        return headArticle.getText().trim();
    }

    public List<String> actualTitlesList() {
        List<String> actualTitleList = new ArrayList<>();
        for (WebElement elem : actualTitleElementsList) {
            actualTitleList.add(elem.getText());
        }
        return actualTitleList;
    }

    public List<String> expectedTitlesList() {
        List<String> expectedTitleList = new ArrayList<>();
        expectedTitleList.add("Russia begins military drills with Belarus");
        expectedTitleList.add("US consumer prices rise at fastest rate since 1982");
        expectedTitleList.add("US-born Chinese skater pilloried after Games falls");
        expectedTitleList.add("Winter Olympics hit by complaints from athletes");
        expectedTitleList.add("Germany probes millionaire's alleged 417km/h drive");
        expectedTitleList.add("Australian parliament apologises to rape accuser");
        expectedTitleList.add("Afghanistan: Watching the destruction of a nation?");
        expectedTitleList.add("China encroaching along Nepal border - report");
        expectedTitleList.add("Severe hunger threatens 13m in Horn of Africa - UN");
        expectedTitleList.add("China encroaching along Nepal border - report");
        expectedTitleList.add("Severe hunger threatens 13m in Horn of Africa - UN");
        expectedTitleList.add("Blood pressure warning over paracetamol use");
        return expectedTitleList;
    }


    public String getCategoryText() {
        return category.getText();
    }

    public void searchByWord(String word) {
        searchField.sendKeys(word, Keys.ENTER);
    }

    public CoronavirusPage goToCoronavirusPage() {
        coronavirusItem.click();
        return new CoronavirusPage();
    }

}
