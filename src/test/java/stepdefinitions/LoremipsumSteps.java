package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loremipsum.manager.PageFactoryManager;
import loremipsum.pages.GeneratedPage;
import loremipsum.pages.HomePage;
import util.Waiter;

import static org.junit.Assert.*;


public class LoremipsumSteps {

    private PageFactoryManager pageFactoryManager;
    private HomePage homePage;
    private GeneratedPage generatedPage;
    private static int wordAverage = 0;

    @Before
    public void testsSetUp() {
        pageFactoryManager = new PageFactoryManager();
    }

    @Given("User opens Home page")
    public void openPage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage();
    }

    @When("User chooses the Russian language")
    public void chooseRussianLanguage() {
        homePage.changeLanguage();
    }

    @Then("User checks the first paragraph contains {string}")
    public void checkFirstParagraphContainsWord(String word) {
        generatedPage = pageFactoryManager.getGeneratePage();
        assertTrue(generatedPage.getRussianFirstParagraph().contains(word));
    }

    @When("User puts text generation button")
    public void clickTextGenerationButton() {
        homePage.generationButtonClick();

    }

    @Then("User checks the generated text starts with {string}")
    public void checkStartPhrase(String startPhrase) {
        generatedPage = pageFactoryManager.getGeneratePage();
        assertTrue(generatedPage.getFirstParagraphText().startsWith(startPhrase));
    }

    @When("User chooses radiobutton {string}")
    public void chooseRadiobutton(String radiobutton) {
        homePage.radioClick(radiobutton);
    }

    @And("User puts {int} in the number field")
    public void putNumber(int number) {
        homePage.putAmount(number);
    }

    @Then("User checks the generated text contains {int} {string}")
    public void checkGeneratedText(int number, String value) {
        generatedPage = pageFactoryManager.getGeneratePage();
        if (value.equals("words")) {
            assertEquals(number, generatedPage.wordsInGeneratedText());
        }
        if (value.equals("bytes")) {
            assertEquals(number, generatedPage.bytesInGeneratedText());
        }
    }

    @When("User clears the checkbox")
    public void checkboxClear() {
        homePage.clearCheckbox();
    }


    @Then("User checks the generated text does not start with {string}")
    public void checkStart(String startPhrase) {
        generatedPage = pageFactoryManager.getGeneratePage();
        assertFalse(generatedPage.getFirstParagraphText().startsWith(startPhrase));
    }

    @And("User calculates number of {string} in the text")
    public int numberOfWordInText(String word) {
        generatedPage = pageFactoryManager.getGeneratePage();
        wordAverage = wordAverage + generatedPage.paragraphsContainWord(word);
        return wordAverage;
    }

    @And("User repeats the same action {int} times for the same {string}")
    public int wordCalculationCycle(int number, String word) {
        for (int i = 1; i < number; i++) {
            homePage.openHomePage();
            Waiter.waitForPageLoadComplete();
            homePage.generationButtonClick();
            Waiter.waitForPageLoadComplete();
            numberOfWordInText(word);
        }
        return wordAverage;
    }

    @Then("User checks the result divided into {int} is more than {int}")
    public void checkWordCalculationCycleResult(int number, int checkedNumber) {
        assertTrue(wordAverage/number>=checkedNumber);
        wordAverage = 0;
    }
}
