package io.tromba.testdriver.core.listeners;

import io.tromba.testdriver.core.TestdriverManager;
import io.tromba.testdriver.core.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

/**
 * TestNG listener to create and destroy drivers before and after the tests are run.
 */
public class TestdriverListener implements IInvokedMethodListener {

    private static final int MAX_WAIT = 30;
    private TestdriverManager testdriverManager = new TestdriverManager();

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = WebDriverFactory.createInstance();
            testdriverManager.setDriver(method.getTestMethod().getMethodName(), driver);
            driver.manage().timeouts().implicitlyWait(MAX_WAIT, TimeUnit.SECONDS);
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            try {
                WebDriver driver = testdriverManager.getDriver(method.getTestMethod().getMethodName());
                driver.close();
                driver.quit();
            } catch (Exception e) {
                throw new RuntimeException("An error occurred - Are you pointing to the correct Selenium Grid? "
                        + e.getMessage());
            }
            testdriverManager.destroyDriver(method.getTestMethod().getMethodName());
        }
    }
}
