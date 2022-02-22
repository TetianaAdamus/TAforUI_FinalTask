package loremipsum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Waiter;

import java.util.List;


public class GeneratedPage extends BasePage {

    @FindBy(xpath = "//div[@id='Panes']/div[1]/p")
    WebElement russianFirstParagraph;

    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    WebElement firstParagraph;

    @FindBy(xpath = "//div[@id='lipsum']/p")
    List<WebElement> allParagraphs;


    public String getRussianFirstParagraph(){
        Waiter.waitVisibilityOfElement(russianFirstParagraph);
        return russianFirstParagraph.getText();
    }

    public String getFirstParagraphText(){
        Waiter.waitVisibilityOfElement(firstParagraph);
        return firstParagraph.getText();
    }

    public int wordsInGeneratedText() {
        return firstParagraph.getText().split(" ").length;
    }

    public int bytesInGeneratedText(){
        return firstParagraph.getText().length();
    }

    public int paragraphsContainWord(String word){
        int loremNumber = 0;
        for (WebElement paragraph : allParagraphs) {
            if (paragraph.getText().trim().toLowerCase().contains(word)) {
                loremNumber = loremNumber + 1;
            }
        }
        return loremNumber;
    }
}

