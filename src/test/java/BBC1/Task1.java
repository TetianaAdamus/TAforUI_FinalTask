package BBC1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Task1 {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
    }

    @Test
    public void checkHeadlineArticleTitle() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement element = driver.findElement(By.xpath("//nav[@role='navigation'] //a[contains(text(), 'News')]"));
        element.click();
        assertEquals(driver.findElement(By.xpath("//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")).getText(), "Downing Street parties report thrown into doubt");
    }

    @Test
    public void checkSecondaryArticlesTitles() {
        WebElement element = driver.findElement(By.xpath("//nav[@role='navigation'] //a[contains(text(), 'News')]"));
        element.click();
        List<WebElement> actualTitleList = driver.findElements(By.xpath("//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']"));
        List<String> actualListString = new ArrayList<>();
        for (WebElement elem: actualTitleList) {
            actualListString.add(elem.getText());
        }
        List<String> expectedTitleList = new ArrayList<>();
        expectedTitleList.add("Doctors among those begging for food in Tigray");
        expectedTitleList.add("US ignored Russia's security concerns, Putin says");
        expectedTitleList.add("Decoding Putin's next move on Ukraine");
        expectedTitleList.add("Japanese doctor dies after 11-hour shooting siege");
        expectedTitleList.add("Netflix to face Queen's Gambit defamation case");
        expectedTitleList.add("Bridge collapse in US city injures 10");
        expectedTitleList.add("Former SS member speaks of shame over Nazi past");
        expectedTitleList.add("Doubts over timing of Djokovic Covid test");
        expectedTitleList.add("Chicago trains drive through fire");
        expectedTitleList.add("Bankers' rate 'rigging' not criminal, says US");
        for (String title: expectedTitleList){
        assertTrue(actualListString.contains(title));
        }
    }



    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
