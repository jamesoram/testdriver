package uk.co.leoaureum.testdriver.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Copyright (C) James Oram 2014-2025
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
        until((ExpectedCondition<Boolean>) webDriver -> {
            try {
                element.isDisplayed();
                return true;
            } catch (StaleElementReferenceException ex) {
                return false;
            }
        });
    }

    /**
     * Wait for an element to be invisible.
     * @param element the element that needs to disappear.
     */
    public void forElementNotVisible(WebElement element) {
        until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Wait for an element to be clickable.
     * @param element the element that needs to be clickable.
     */
    public void forElementToBeClickable(WebElement element) {
        until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wait for an element to not be clickable.
     * @param element The element that needs to stop being clickable.
     */
    public void forElementToNotBeClickable(WebElement element) {
        until(not(ExpectedConditions.elementToBeClickable(element)));
    }

    private ExpectedCondition<Boolean> not(final ExpectedCondition<?> toInvert) {
        return driver -> {
            try {
                Object result = toInvert.apply(driver);
                return (result == null || result == Boolean.FALSE);
            } catch (Exception e) {
                return true;
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
