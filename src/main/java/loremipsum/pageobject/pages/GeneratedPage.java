package loremipsum.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class GeneratedPage extends BasePage {
    private static final String RUSSIAN_FIRST_PARAGRAPH = "//div[@id='Panes']/div[1]/p";
    private static final String FIRST_PARAGRAPH = "//div[@id='lipsum']/p[1]";
    private static final String ALL_PARAGRAPHS = "//div[@id='lipsum']/p";

    public GeneratedPage(WebDriver driver) {
        super(driver);
    }

    public String getRussianFirstParagraph(){
        return driver.findElement(By.xpath(RUSSIAN_FIRST_PARAGRAPH)).getText();
    }

    public String getFirstParagraphText(){
        return driver.findElement(By.xpath(FIRST_PARAGRAPH)).getText();
    }

    public int wordsInGeneratedText() {
        return driver.findElement(xpath(FIRST_PARAGRAPH)).getText().split(" ").length;
    }

    public int bytesInGeneratedText(){
        return driver.findElement(xpath(FIRST_PARAGRAPH)).getText().length();
    }

    public int paragraphsContainWord(String word){
        List<WebElement> elementList = driver.findElements(xpath(ALL_PARAGRAPHS));
        int loremNumber = 0;
        for (WebElement paragraph : elementList) {
            if (paragraph.getText().trim().toLowerCase().contains(word)) {
                loremNumber = loremNumber + 1;
            }
        }
        return loremNumber;
    }
}

