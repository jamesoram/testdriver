package io.tromba.testdriver.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class for wait conditions.
 */
public class TestdriverWait extends WebDriverWait {

    public TestdriverWait(WebDriver driver, long timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    public void forElementVisible(WebElement element) {
        until(ExpectedConditions.visibilityOf(element));
    }

    public void forElementNotStale(final WebElement element) {
        until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                try {
                    element.isDisplayed();
                    return true;
                } catch (StaleElementReferenceException ex) {
                    return false;
                }
            }
        });
    }

    private ExpectedCondition<Boolean> not(final ExpectedCondition<?> toInvert) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    Object result = toInvert.apply(driver);
                    return (result == null || result == Boolean.FALSE);
                } catch (Exception e) {
                    return true;
                }
            }
        };
    }

    // this should only be used for debugging purposes
    @Deprecated
    public void sleep(int timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}
