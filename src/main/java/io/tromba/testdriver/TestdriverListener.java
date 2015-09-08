package io.tromba.testdriver;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * TestNG listener to create and destroy drivers before and after the tests are fun.
 */
public class TestdriverListener implements IInvokedMethodListener {

    private TestdriverManager testdriverManager = new TestdriverManager();

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        WebDriver driver = new WebDriverFactory().createInstance();
        testdriverManager.setDriver(method, driver);
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        try {
            WebDriver driver = testdriverManager.getDriver(method);
            driver.close();
            driver.quit();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred: " + e.getMessage());
        }
        testdriverManager.destroyDriver(method);
    }
}
