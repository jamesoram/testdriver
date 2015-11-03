package io.tromba.testdriver;

import com.typesafe.config.ConfigException;
import io.tromba.testdriver.utils.TestdriverConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests for TestdriverConfig.
 */
public class TestdriverconfigTests {

    @Test
    public void testConfigIsLoaded() {
        TestdriverConfig config = new TestdriverConfig();
        Assert.assertEquals(config.get("grid"), "http://test:31337");
    }

    @Test(expectedExceptions = ConfigException.class)
    public void testInvalidConfigFileIsNotLoaded() {
        TestdriverConfig config = new TestdriverConfig("invalid");
        config.get("grid");
    }
}
