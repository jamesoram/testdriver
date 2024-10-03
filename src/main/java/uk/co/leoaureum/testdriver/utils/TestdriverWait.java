package uk.co.leoaureum.testdriver.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Class for wait conditions.
 */
public class TestdriverWait extends WebDriverWait {

    /**
     * Constructor.
     * @param driver the WebDriver instance to use.
     * @param timeOutInSeconds Maximum amount to wait.
     */
    public TestdriverWait(WebDriver driver, long timeOutInSeconds) {
        super(driver, Duration.ofSeconds(timeOutInSeconds));
    }

    /**
     * Wait for an element to be visible.
     * @param element the element to wait for.
     */
    public void forElementVisible(WebElement element) {
        until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for an element to not be stale.
     * @param element the element to wait for.
     */
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

    /**
     * This should only be used for debugging purposes.
     * @param timeInMillis the time to wait.
     */
    @Deprecated
    public void sleep(int timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}
