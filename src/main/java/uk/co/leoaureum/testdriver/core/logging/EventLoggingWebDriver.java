package uk.co.leoaureum.testdriver.core.logging;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Copyright (C) James Oram 2014-2025
 * Wrapper to log WebDriver events.
 */
public class EventLoggingWebDriver implements WebDriverListener {

    private final TestdriverLogger logger;

    public EventLoggingWebDriver(TestdriverLogger logger) {
        this.logger = logger;
    }

    @Override
    public void beforeGet(WebDriver webDriver, String url) {
        logger.log(LogLevel.INFO, "Starting navigation to: " + url);
    }

    @Override
    public void afterGet(WebDriver webDriver, String url) {
        logger.log(LogLevel.INFO, "Navigated to: " + url);
    }

    @Override
    public void beforeBack(WebDriver.Navigation navigation) {
        logger.log(LogLevel.INFO, "About to navigate back");
    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {
        logger.log(LogLevel.INFO, "Navigated back");
    }

    @Override
    public void beforeForward(WebDriver.Navigation navigation) {
        logger.log(LogLevel.INFO, "About to navigate forward");
    }

    @Override
    public void afterForward(WebDriver.Navigation navigation) {
        logger.log(LogLevel.INFO, "Navigated forward");
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.log(LogLevel.INFO, "About to FindBy: " + locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.log(LogLevel.INFO, "After to FindBy: " + locator.toString());
    }

    @Override
    public void beforeClick(WebElement webElement) {
        logger.log(LogLevel.INFO, "About to click on " + (webElement == null ? "" : webElement.toString()));
    }

    @Override
    public void afterClick(WebElement webElement) {
        logger.log(LogLevel.INFO, "Clicked on " + (webElement == null ? "" : webElement.toString()));
    }

    @Override
    public void beforeSendKeys(WebElement webElement, CharSequence... charSequences) {
        logger.log(LogLevel.INFO, "About to change value of " + (webElement == null ? "" : webElement.toString()));
    }

    @Override
    public void afterSendKeys(WebElement webElement, CharSequence... charSequences) {
        logger.log(LogLevel.INFO, "Changed value of " + (webElement == null ? "" : webElement.toString()));
    }

    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
        logger.log(LogLevel.INFO, "About to execute script " + script);
    }

    @Override
    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
        logger.log(LogLevel.INFO, "Executed script " + script);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.log(LogLevel.INFO, "Caught exception: " + e.getMessage());
    }

    @Override
    public void beforeGetText(WebElement webElement) {
        logger.log(LogLevel.INFO, "About to get text from element");
    }

    @Override
    public void afterGetText(WebElement webElement, String s) {
        logger.log(LogLevel.INFO, "Got text from element " + s);
    }

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {
        logger.log(LogLevel.INFO, "About to refresh");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        logger.log(LogLevel.INFO, "Finished refreshing");
    }

    @Override
    public void afterAlert(WebDriver.TargetLocator targetLocator, Alert alert) {
        logger.log(LogLevel.INFO, "Received alert");
    }

    @Override
    public void beforeAlert(WebDriver.TargetLocator targetLocator) {
        logger.log(LogLevel.INFO, "About to accept alert");
    }
}
