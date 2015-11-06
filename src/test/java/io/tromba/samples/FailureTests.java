package io.tromba.samples;

import io.tromba.testdriver.core.BaseTestdriverTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test that should fail.
 */
public class FailureTests extends BaseTestdriverTest {

    @Test(timeOut = 1000)
    public void testFailure() {
        Assert.fail();
    }
}
