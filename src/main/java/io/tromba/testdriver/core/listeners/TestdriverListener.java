package io.tromba.testdriver.core.listeners;

import io.tromba.testdriver.core.TestdriverManager;
import io.tromba.testdriver.core.WebDriverFactory;
import io.tromba.testdriver.core.logging.BasicTestdriverLogger;
import io.tromba.testdriver.core.logging.EventLoggingWebDriver;
import io.tromba.testdriver.core.logging.LogLevel;
import io.tromba.testdriver.core.logging.TestdriverLogger;
import io.tromba.testdriver.utils.TestdriverConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.File;
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
            EventFiringWebDriver augmentedDriver = new EventFiringWebDriver(new Augmenter().augment(driver));
            TestdriverLogger logger = getLogger();
            EventLoggingWebDriver loggingWebDriver = new EventLoggingWebDriver(logger);
            augmentedDriver.register(loggingWebDriver);
            testdriverManager.setDriver(method.getTestMethod().getMethodName(), augmentedDriver, logger);
            augmentedDriver.manage().timeouts().implicitlyWait(MAX_WAIT, TimeUnit.SECONDS);
        }
    }

    /**
     * Runs after each test invocation. Destroys and closes the driver.
     * @param method the method that has just run.
     * @param testResult the test result.
     */
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String uuid = "";
            final String key = method.getTestMethod().getMethodName();
            try {
                WebDriver driver = testdriverManager.getDriver(key);
                uuid = testdriverManager.getUuid(key);
                if (!method.getTestResult().isSuccess()) {
                    String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
                    File savedScreenshot = new File(uuid);
                    savedScreenshot.createNewFile();
                    getLogger().log(LogLevel.INFO, screenshot);
                }
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("An error occurred - Are you pointing to the correct Selenium Grid?\n"
                        + e.getMessage());
            } finally {
                testdriverManager.destroyDriver(key);
            }
        }
    }

    private TestdriverLogger getLogger() {
        // TODO make this configurable
        return new BasicTestdriverLogger();
    }
}
