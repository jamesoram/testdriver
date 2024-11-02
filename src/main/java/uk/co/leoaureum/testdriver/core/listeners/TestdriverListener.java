package uk.co.leoaureum.testdriver.core.listeners;

import org.openqa.selenium.support.events.EventFiringDecorator;
import uk.co.leoaureum.testdriver.core.TestdriverManager;
import uk.co.leoaureum.testdriver.core.WebDriverFactory;
import uk.co.leoaureum.testdriver.core.logging.BasicTestdriverLogger;
import uk.co.leoaureum.testdriver.core.logging.EventLoggingWebDriver;
import uk.co.leoaureum.testdriver.core.logging.LogLevel;
import uk.co.leoaureum.testdriver.core.logging.TestdriverLogger;
import uk.co.leoaureum.testdriver.utils.TestdriverConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;

/**
 * TestNG listener to create and destroy drivers before and after the tests are run.
 */
public class TestdriverListener implements IInvokedMethodListener {

    private static final String MAX_WAIT = TestdriverConfig.getInstance().getMaxImplicitWaitInSeconds();
    private final TestdriverManager testdriverManager = new TestdriverManager();

    /**
     * Runs before each test invocation. Sets up the driver for each test.
     * @param method the method which is about to run.
     * @param testResult the result of the test.
     */
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        String methodName = TestdriverManager.generateKey(method.getTestMethod().getMethodName());
        TestdriverLogger logger = getLogger(methodName);
        if (method.isTestMethod()) {
            WebDriver driver = WebDriverFactory.createInstance(methodName, logger);
            EventLoggingWebDriver loggingWebDriver = new EventLoggingWebDriver(logger);

            WebDriver augmentedDriver = new EventFiringDecorator<>(loggingWebDriver).decorate(driver);
            testdriverManager.setDriver(methodName, augmentedDriver, logger);
            method.getTestMethod().setId(testdriverManager.getUuid(methodName));
            logger.setId(method.getTestMethod().getId());
            augmentedDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(MAX_WAIT)));
        } else {
            String message = "Method does not appear to be a test method. " + methodName;
            System.err.println(message);
            logger.log(LogLevel.ERROR, message);
        }
    }

    /**
     * Runs after each test invocation. Destroys and closes the driver.
     * @param method the method that has just run.
     * @param testResult the test result.
     */
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String uuid;
            final String key = TestdriverManager.generateKey(method.getTestMethod().getMethodName());
            try {
                WebDriver driver = testdriverManager.getDriver(key);
                uuid = testdriverManager.getUuid(key);
                if (!method.getTestResult().isSuccess()) {
                    byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                    String fileName = "target" + File.separator + uuid + ".jpg";
                    try (FileOutputStream fos = new FileOutputStream(fileName)) {
                        fos.write(screenshot);
                        getLogger(key).log(LogLevel.ERROR, "File created: " + fileName);
                    }
                }
                driver.quit();
            } catch (Exception e) {
                throw new RuntimeException("An error occurred - Are you pointing to the correct Selenium Grid" +
                        " and is your testdriver.conf correct?\n"
                        + e.getMessage());
            } finally {
                testdriverManager.destroyDriver(key);
            }
        }
    }

    private TestdriverLogger getLogger(String methodName) {
        // TODO make this configurable
        return new BasicTestdriverLogger(methodName);
    }
}
