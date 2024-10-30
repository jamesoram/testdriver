package uk.co.leoaureum.testdriver.core;

import uk.co.leoaureum.testdriver.core.logging.TestdriverLogger;
import org.openqa.selenium.WebDriver;

/**
 * Data class for the essential components of a Testdriver test.
 */
public class TestEssential {

    private WebDriver driver;
    private TestdriverLogger logger;
    private String uuid;

    public TestEssential(WebDriver driver, TestdriverLogger logger) {
        this.uuid = logger.getMethod();
        this.driver = driver;
        this.logger = logger;
    }

    /**
     * Return the driver.
     * @return the correct WebDriver.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Get the logger.
     * @return the TestdriverLogger.
     */
    public TestdriverLogger getLogger() {
        return logger;
    }

    /**
     * Get the UUID
     * @return a String with the UUID.
     */
    public String getUuid() {
        return uuid;
    }
}
