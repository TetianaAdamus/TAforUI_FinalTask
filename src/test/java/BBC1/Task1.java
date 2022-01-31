package BBC1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver.get("https://www.bbc.com/");
    }

    @Test
    public void checkHeadlineArticleTitle() {
       driver.findElement(By.xpath("//nav[@role='navigation'] //a[contains(text(), 'News')]")).click();
        assertEquals(driver.findElement(By.xpath("//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")).getText(), "Downing Street parties report thrown into doubt");
    }

    @Test
    public void checkSecondaryArticlesTitles() {
        driver.findElement(By.xpath("//nav[@role='navigation'] //a[contains(text(), 'News')]")).click();
        List<WebElement> actualTitleList = driver.findElements(By.xpath("//h3[@class='gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']"));
        List<String> actualListString = new ArrayList<>();
        for (WebElement elem : actualTitleList) {
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
        for (String title : expectedTitleList) {
            assertTrue(actualListString.contains(title));
        }
    }

    @Test
    public void checkSearchBar() {
        driver.findElement(By.xpath("//nav[@role='navigation'] //a[contains(text(), 'News')]")).click();
        String category = driver.findElement(By.xpath("//a[contains(@class,'gs-c-section-link gs-c-section-link--truncate')]")).getText();
        driver.findElement(By.xpath("//input[@id='orb-search-q']")).sendKeys(category, Keys.ENTER);
        String firstFoundTitle = driver.findElement(By.xpath("//p[@class='ssrcss-6arcww-PromoHeadline e1f5wbog4']")).getText();
        if (category.contains("&")) {
            int index = category.indexOf('&');
            String firstWord = category.substring(0, index).trim();
            String secondWord = category.substring(index + 1).trim();
            assertTrue(firstFoundTitle.contains(firstWord) || firstFoundTitle.contains(secondWord));
        } else assertTrue(firstFoundTitle.contains(category));
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
