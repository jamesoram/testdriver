package uk.co.leoaureum.samples;

import uk.co.leoaureum.testdriver.core.BaseTestdriverTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test that should fail.
 */
public class FailureTests extends BaseTestdriverTest {

    @Test(timeOut = 1000, enabled = false)
    public void testFailure() {
        Assert.fail();
    }
}
