package io.tromba.testdriver.core;

import io.tromba.testdriver.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Manager class for WebDrivers.
 */
public class TestdriverManager {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    /**
     * Set the driver for a given method.
     * @param method the method with which to associate the driver.
     * @param driver the driver to use.
     */
    public synchronized void setDriver(String method, WebDriver driver) {
        drivers.put(generateKey(method), driver);
    }

    /**
     * get the drvier for a method
     * @param method the method for which we want the driver.
     * @return the driver for that method.
     */
    public WebDriver getDriver(String method) {
        return drivers.get(generateKey(method));
    }

    /**
     * Destroy the driver for a method.
     * @param method the method for which we want to destroy the driver.
     */
    public synchronized void destroyDriver(String method) {
        drivers.remove(method);
    }

    /**
     * Get all the drivers.
     * @return the Set of drivers currently in use.
     */
    public Set<String> getDriverSet() {
        return drivers.keySet();
    }

    /**
     * Return the driver for the test calling this method.
     * @return the correct driver.
     */
    public WebDriver driver() {
        Set<String> methods = getDriverSet();
        StackTraceElement stackTraceElements[] = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement: stackTraceElements) {
            String methodName = stackTraceElement.getMethodName();
            if (methods.contains(generateKey(methodName))) {
                return getDriver(methodName);
            }
        }
        throw new DriverNotFoundException();
    }

    private String generateKey(String method) {
        return method + Thread.currentThread().getId();
    }
}
