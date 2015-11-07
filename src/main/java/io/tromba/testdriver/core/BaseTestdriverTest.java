package io.tromba.testdriver.core;

import io.tromba.testdriver.core.listeners.TestdriverAnnotationTransformer;
import io.tromba.testdriver.core.listeners.TestdriverListener;
import io.tromba.testdriver.environment.EnvironmentHandler;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

/**
 * Base test from which all testdriver tests will inherit.
 */
@Listeners({ TestdriverListener.class, TestdriverAnnotationTransformer.class })
public class BaseTestdriverTest {

    private EnvironmentHandler environmentHandler;
    private TestdriverManager testdriverManager = new TestdriverManager();

    public BaseTestdriverTest() {

    }

    public BaseTestdriverTest(EnvironmentHandler environmentHandler) {
        this.environmentHandler = environmentHandler;
    }

    @BeforeTest
    public void getStartUrl() {
        if (null != environmentHandler) {
            driver().get(environmentHandler.getStartUrl());
        }
    }

    /**
     * Get the driver that belongs to the calling test.
     * @return the correct webdriver.
     */
    public WebDriver driver() {
        return testdriverManager.driver();
    }
}
