package io.tromba.testdriver;

import io.tromba.testdriver.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import java.util.Set;

/**
 * Base test from which all testdriver tests will inherit.
 */
@Listeners({ io.tromba.testdriver.TestdriverListener.class })
public class BaseTestdriverTest {

    private TestdriverManager testdriverManager;

    public BaseTestdriverTest(TestdriverManager testdriverManager) {
        this.testdriverManager = testdriverManager;
    }

    public WebDriver driver() {
        Set<String> methods = testdriverManager.getTestMethods();
        StackTraceElement stackTraceElements[] = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement: stackTraceElements) {
            String methodName = stackTraceElement.getMethodName();
            if (methods.contains(methodName)) {
                return testdriverManager.getDriver(methodName);
            }
        }
        throw new DriverNotFoundException();
    }
}
