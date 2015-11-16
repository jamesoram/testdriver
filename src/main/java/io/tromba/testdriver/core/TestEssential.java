package io.tromba.testdriver.core;

import io.tromba.testdriver.core.logging.TestdriverLogger;
import org.openqa.selenium.WebDriver;

/**
 * Data class for the essential components of a Testdriver test.
 */
public class TestEssential {

    private WebDriver driver;

    private TestdriverLogger logger;

    public TestEssential(WebDriver driver, TestdriverLogger logger) {
        this.driver = driver;
        this.logger = logger;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public TestdriverLogger getLogger() {
        return logger;
    }
}
