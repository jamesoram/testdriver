package io.tromba.testdriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Base test from which all testdriver tests will inherit.
 */
public class BaseTestdriverTest {

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {

    }
}
