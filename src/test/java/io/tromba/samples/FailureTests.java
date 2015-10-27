package io.tromba.samples;

import io.tromba.testdriver.core.BaseTestdriverTest;
import io.tromba.testdriver.core.TestdriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test that should fail.
 */
public class FailureTests extends BaseTestdriverTest {

    public FailureTests() {
        super(new TestdriverManager());
    }

    @Test(timeOut = 1000)
    public void testFailure() {
        Assert.fail();
    }
}
