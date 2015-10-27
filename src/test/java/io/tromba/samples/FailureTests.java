package io.tromba.samples;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test that should fail.
 */
public class FailureTests {

    @Test(timeOut = 1000)
    public void testFailure() {
        Assert.fail();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}
