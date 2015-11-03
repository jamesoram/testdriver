package io.tromba.testdriver;

import com.typesafe.config.ConfigException;
import io.tromba.testdriver.utils.TestdriverConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests for TestdriverConfig.
 */
public class TestdriverconfigTests {

    @Test
    public void testConfigIsLoaded() {
        TestdriverConfigLoader config = new TestdriverConfigLoader();
        Assert.assertEquals(config.get("grid"), "http://test:31337");
    }

    @Test(expectedExceptions = ConfigException.class)
    public void testInvalidConfigFileIsNotLoaded() {
        TestdriverConfigLoader config = new TestdriverConfigLoader("invalid");
        config.get("grid");
    }
}
