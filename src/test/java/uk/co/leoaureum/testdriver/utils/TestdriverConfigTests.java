package uk.co.leoaureum.testdriver.utils;

import com.typesafe.config.ConfigException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Copyright (C) James Oram 2014-2025
 * Tests for TestdriverConfig.
 */
public class TestdriverConfigTests {

    @Test
    public void testConfigIsLoaded() {
        TestdriverConfigLoader config = new TestdriverConfigLoader();
        Assert.assertEquals(config.get("grid"), "http://localhost:4444/wd/hub");
    }

    @Test(expectedExceptions = ConfigException.class)
    public void testInvalidConfigFileIsNotLoaded() {
        TestdriverConfigLoader config = new TestdriverConfigLoader("invalid");
        config.get("grid");
    }
}
