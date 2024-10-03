package uk.co.leoaureum.testdriver.core.listeners;

import uk.co.leoaureum.testdriver.core.TestdriverManager;
import uk.co.leoaureum.testdriver.core.WebDriverFactory;
import uk.co.leoaureum.testdriver.core.logging.BasicTestdriverLogger;
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
            WebDriver driver = WebDriverFactory.createInstance(method.getTestMethod().getMethodName());

//            WebDriver augmentedDriver = new EventFiringDecorator().decorate(new Augmenter().augment(driver));
            TestdriverLogger logger = getLogger();
//            EventLoggingWebDriver loggingWebDriver = new EventLoggingWebDriver(logger);
//            augmentedDriver.register(loggingWebDriver);
//            testdriverManager.setDriver(method.getTestMethod().getMethodName(), augmentedDriver, logger);
            testdriverManager.setDriver(method.getTestMethod().getMethodName(), driver, logger);
//            augmentedDriver.manage().timeouts().implicitlyWait(MAX_WAIT, TimeUnit.SECONDS);
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
                    File savedScreenshot = new File("target" + File.separator + uuid + ".jpg");
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
