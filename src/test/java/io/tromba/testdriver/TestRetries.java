package io.tromba.testdriver;

import io.tromba.samples.FailureTests;
import io.tromba.testdriver.core.BaseTestdriverTest;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

/**
 * Tests to ensure the listeners work.
 */
public class TestRetries extends BaseTestdriverTest {

    @Test(enabled = false)
    public void testRetries() {
        TestNG tng = new TestNG();
        tng.setVerbose(0);
        tng.setTestClasses(new Class[] { FailureTests.class });
        TestListenerAdapter tla = new TestListenerAdapter();
        tng.addListener(tla);
        tng.run();
        Assert.assertEquals(tla.getFailedTests().size(), 1);
        Assert.assertEquals(tla.getSkippedTests().size(), 3);
        Assert.assertEquals(tla.getPassedTests().size(), 0);
    }
}
