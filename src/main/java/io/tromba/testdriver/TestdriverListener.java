package io.tromba.testdriver;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

/**
 * TestNG listener to create and destroy drivers before and after the tests are fun.
 */
public class TestdriverListener implements IInvokedMethodListener {

    private TestdriverManager testdriverManager = new TestdriverManager();

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = WebDriverFactory.createInstance();
            testdriverManager.setDriver(method.getTestMethod().getMethodName(), driver);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            try {
                WebDriver driver = testdriverManager.getDriver(method.getTestMethod().getMethodName());
                driver.close();
                driver.quit();
            } catch (Exception e) {
                throw new RuntimeException("An error occurred: " + e.getMessage());
            }
            testdriverManager.destroyDriver(method.getTestMethod().getMethodName());
        }
    }
}
