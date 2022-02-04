package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    public static final long TIME_TO_WAIT = 30;

    public static void implicitWait() {
        DriverSingleton.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_TO_WAIT));
    }

    public static void waitForPageLoadComplete() {
        new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(TIME_TO_WAIT)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    public static void waitVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(TIME_TO_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementIsClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(TIME_TO_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
