package io.tromba.testdriver.core;

import io.tromba.testdriver.core.listeners.TestdriverAnnotationTransformer;
import io.tromba.testdriver.core.listeners.TestdriverListener;
import io.tromba.testdriver.core.logging.LogLevel;
import io.tromba.testdriver.core.logging.TestdriverLogger;
import io.tromba.testdriver.environment.EnvironmentHandler;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

/**
 * Base test from which all testdriver tests will inherit.
 */
@Listeners({ TestdriverListener.class, TestdriverAnnotationTransformer.class })
public class BaseTestdriverTest {

    private EnvironmentHandler environmentHandler;
    private TestdriverManager testdriverManager = new TestdriverManager();

    public BaseTestdriverTest() {

    }

    public BaseTestdriverTest(EnvironmentHandler environmentHandler) {
        this.environmentHandler = environmentHandler;
    }

    /**
     * Get the driver that belongs to the calling test.
     * @return the correct WebDriver.
     */
    public WebDriver driver() {
        return testdriverManager.driver();
    }

    /**
     * Get the logger that belongs to the calling test.
     * @return the correct logger.
     */
    public TestdriverLogger logger() {
        return testdriverManager.logger();
    }

    /**
     * Log and assert a condition.
     * @param condition the condition to assert is true.
     */
    public void assertTrue(boolean condition) {
        logger().log(LogLevel.ASSERTION, "Asserting that " + condition + " is true");
        Assert.assertTrue(condition);
    }

    /**
     * Log and assert equality.
     * @param expected 
     * @param found
     */
    public void assertEquals(String expected, String found) {
        logger().log(LogLevel.ASSERTION, "Asserting that " + expected + " equals " + found);
        Assert.assertEquals(expected, found);
    }
}
