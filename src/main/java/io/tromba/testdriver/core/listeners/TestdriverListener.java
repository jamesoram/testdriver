package io.tromba.testdriver.core.listeners;

import io.tromba.testdriver.core.TestdriverManager;
import io.tromba.testdriver.core.WebDriverFactory;
import io.tromba.testdriver.core.logging.BasicTestdriverLogger;
import io.tromba.testdriver.core.logging.TestdriverLogger;
import io.tromba.testdriver.utils.TestdriverConfig;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

/**
 * TestNG listener to create and destroy drivers before and after the tests are run.
 */
public class TestdriverListener implements IInvokedMethodListener {

    private static final int MAX_WAIT = Integer.valueOf(TestdriverConfig.getInstance().getMaxImplicitWaitInSeconds());
    private TestdriverManager testdriverManager = new TestdriverManager();

    /**
     * Runs before each test invocation. Sets up the driver for each test.
     * @param method the method which is about to run.
     * @param testResult the result of the test.
     */
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = WebDriverFactory.createInstance();
            TestdriverLogger logger = getLogger();
            testdriverManager.setDriver(method.getTestMethod().getMethodName(), driver, logger);
            driver.manage().timeouts().implicitlyWait(MAX_WAIT, TimeUnit.SECONDS);
        }
    }

    /**
     * Runs after each test invocation. Destroys and closes the driver.
     * @param method the method that has just run.
     * @param testResult the test result.
     */
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            try {
                String key = method.getTestMethod().getMethodName();
                WebDriver driver = testdriverManager.getDriver(key);
                testdriverManager.destroyDriver(key);
                driver.close();
                driver.quit();
            } catch (Exception e) {
                throw new RuntimeException("An error occurred - Are you pointing to the correct Selenium Grid? "
                        + e.getMessage());
            }
            testdriverManager.destroyDriver(method.getTestMethod().getMethodName());
        }
    }

    private TestdriverLogger getLogger() {
        // TODO make this configurable
        return new BasicTestdriverLogger();
    }
}
