package io.tromba.samples;

import io.tromba.testdriver.BaseTestdriverTest;
import io.tromba.testdriver.TestdriverManager;
import org.testng.annotations.Test;

/**
 * Smoke test.
 */
public class SampleTests extends BaseTestdriverTest {

    public SampleTests() {
        super(new TestdriverManager());
    }

    @Test
    public void testGetAPage() {
        driver().get("http://tromba.io");
    }
}