package bbc1;

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
        assertEquals(driver.findElement(By.xpath("//h3[@class='gs-c-promo-heading__title gel-paragon-bold nw-o-link-split__text']")).getText().trim(), "Ukraine leader praises West's response on Russia");
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
        expectedTitleList.add("Ukraine leader praises West's response on Russia");
        expectedTitleList.add("NFL legend Brady confirms retirement");
        expectedTitleList.add("Amnesty report calls Israel an apartheid state");
        expectedTitleList.add("Ros Atkins on... the UK government parties report");
        expectedTitleList.add("Johnson focused on saving own skin - UK opposition");
        expectedTitleList.add("Whoopi Goldberg slammed for Holocaust remarks");
        expectedTitleList.add("Denmark lifts almost all Covid restrictions");
        expectedTitleList.add("NZ to allow in pregnant reporter helped by Taliban");
        expectedTitleList.add("US locks down all federal prisons after gang fight");
        expectedTitleList.add("NZ to allow in pregnant reporter helped by Taliban");
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
