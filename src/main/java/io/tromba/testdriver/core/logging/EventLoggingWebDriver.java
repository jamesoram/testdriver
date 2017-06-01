package io.tromba.testdriver.core.logging;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Wrapper to log WebDriver events.
 */
public class EventLoggingWebDriver implements WebDriverEventListener {

    private TestdriverLogger logger;

    public EventLoggingWebDriver(TestdriverLogger logger) {
        this.logger = logger;
    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "Starting navigation to: " + s);
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "Navigated to: " + s);
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        logger.log(LogLevel.INFO, "About to navigate back");
    }

    public void afterNavigateBack(WebDriver webDriver) {
        logger.log(LogLevel.INFO, "Navigated back");
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        logger.log(LogLevel.INFO, "About to navigate forward");
    }

    public void afterNavigateForward(WebDriver webDriver) {
        logger.log(LogLevel.INFO, "Navigated forward");
    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "About to FindBy: " + by.toString());
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "After to FindBy: " + by.toString());
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "About to click on " + webElement == null ? "" : webElement.toString());
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "Clicked on " + webElement == null ? "" : webElement.toString());
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.log(LogLevel.INFO, "About to change value of " + webElement == null ? "" : webElement.toString());
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.log(LogLevel.INFO, "Changed value of " + webElement == null ? "" : webElement.toString());
    }

    public void beforeScript(String s, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "About to execute script " + s);
    }

    public void afterScript(String s, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "Executed script " + s);
    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.log(LogLevel.INFO, "Caught exception: " + throwable.getMessage());
    }

    public void beforeNavigateRefresh(WebDriver driver) {
        logger.log(LogLevel.INFO, "About to refresh");
    }

    public void afterNavigateRefresh(WebDriver driver) {
        logger.log(LogLevel.INFO, "Finished refreshing");
    }

    public void afterAlertAccept(WebDriver driver) {
        logger.log(LogLevel.INFO, "Accepted alert");
    }

    public void beforeAlertAccept(WebDriver driver) {
        logger.log(LogLevel.INFO, "About to accept alert");
    }

    public void afterAlertDismiss(WebDriver webDriver) {
        logger.log(LogLevel.INFO, "Dismissed alert");
    }

    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.log(LogLevel.INFO, "About to dismiss alert");
    }
}
