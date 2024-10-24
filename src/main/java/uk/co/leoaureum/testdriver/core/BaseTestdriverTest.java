package uk.co.leoaureum.testdriver.core;

import uk.co.leoaureum.testdriver.core.listeners.TestdriverAnnotationTransformer;
import uk.co.leoaureum.testdriver.core.listeners.TestdriverListener;
import uk.co.leoaureum.testdriver.core.logging.LogLevel;
import uk.co.leoaureum.testdriver.core.logging.TestdriverLogger;
import uk.co.leoaureum.testdriver.environment.EnvironmentHandler;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import uk.co.leoaureum.testdriver.utils.TestdriverReporter;

/**
 * Base test from which all testdriver tests will inherit.
 */
@Listeners({ TestdriverListener.class, TestdriverAnnotationTransformer.class, TestdriverReporter.class})
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
    public synchronized WebDriver driver() {
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
     * @param expected what was expected
     * @param found what was actually found
     */
    public void assertEquals(String expected, String found) {
        logger().log(LogLevel.ASSERTION, "Asserting that " + expected + " equals " + found);
        Assert.assertEquals(expected, found);
    }
}
