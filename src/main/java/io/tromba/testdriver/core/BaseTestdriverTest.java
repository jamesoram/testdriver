package io.tromba.testdriver.core;

import io.tromba.testdriver.core.listeners.TestdriverListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

/**
 * Base test from which all testdriver tests will inherit.
 */
@Listeners({ TestdriverListener.class, TestdriverAnnotationTransformer.class })
public class BaseTestdriverTest {

    private TestdriverManager testdriverManager;

    public BaseTestdriverTest(TestdriverManager testdriverManager) {
        this.testdriverManager = testdriverManager;
    }

    public WebDriver driver() {
        return testdriverManager.driver();
    }
}
