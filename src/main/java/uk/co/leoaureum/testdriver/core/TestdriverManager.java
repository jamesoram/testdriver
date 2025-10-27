package uk.co.leoaureum.testdriver.core;

import uk.co.leoaureum.testdriver.core.logging.TestdriverLogger;
import uk.co.leoaureum.testdriver.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import uk.co.leoaureum.testdriver.utils.TestdriverReporter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Copyright (C) James Oram 2014-2025
 * Manager class for WebDrivers.
 */
public class TestdriverManager {

    private static final Map<String, TestEssential> testEssentials = new HashMap<>();

    /**
     * Set the driver for a given method.
     * @param method the method with which to associate the driver.
     * @param driver the driver to use.
     * @param logger the logger to use.
     */
    public synchronized void setDriver(String method, WebDriver driver, TestdriverLogger logger) {
        TestEssential testEssential = new TestEssential(driver, logger);
        String key = generateKey(method);
        testEssentials.put(key, testEssential);
    }

    /**
     * Get the driver for a method
     * @param method the method for which we want the driver.
     * @return the driver for that method.
     */
    public WebDriver getDriver(String method) {
        TestEssential testEssential = getTestEssential(method);
        return testEssential.getDriver();
    }

    /**
     * Get the UUID for the specified test.
     * @param method the method name of the test.
     * @return a String containing the correct UUID.
     */
    public String getUuid(String method) {
        return getTestEssential(method).getUuid();
    }

    /**
     * Get the UUID for the running test.
     * @return String containing the correct UUID.
     */
    public String getUuid() {
        return getUuid(findKey());
    }

    /**
     * Destroy the driver for a method.
     * @param method the method for which we want to destroy the driver.
     */
    public synchronized void destroyDriver(String method) {
        TestdriverLogger logger = getTestEssential(method).getLogger();
        TestdriverReporter.addLogger(logger);
        logger.write();
        testEssentials.remove(method);
    }

    /**
     * Get all the testEssentials.
     * @return the Set of testEssentials currently in use.
     */
    public Set<String> getDriverSet() {
        return testEssentials.keySet();
    }

    /**
     * Return the driver for the test calling this method.
     * @return the correct driver.
     */
    public WebDriver driver() {
        return getDriver(findKey());
    }

    /**
     * Return the logger for the test calling this method.
     * @return the correct logger.
     */
    public TestdriverLogger logger() {
        return getLogger(findKey());
    }

    private TestdriverLogger getLogger(String method) {
        return getTestEssential(method).getLogger();
    }

    private String findKey() {
        Set<String> keys = getDriverSet();

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement: stackTraceElements) {
            String currentKey = generateKey(stackTraceElement.getMethodName());
            if (keys.contains(generateKey(currentKey))) {
                return currentKey;
            }
        }
        throw new DriverNotFoundException();
    }

    public synchronized static String generateKey(String method) {
        return method + Thread.currentThread().getId();
    }

    private TestEssential getTestEssential(String method) {
        TestEssential testEssential = testEssentials.get(generateKey(method));
        if (null == testEssential) {
            throw new RuntimeException("Could not find driver for method: " + method +
                    ". Please check that the grid is running correctly and there is connectivity");
        }
        return testEssential;
    }
}
