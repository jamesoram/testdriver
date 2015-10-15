package io.tromba.testdriver;

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

    public synchronized void setDriver(String method, WebDriver driver) {
        drivers.put(generateKey(method), driver);
    }

    public WebDriver getDriver(String method) {
        return drivers.get(generateKey(method));
    }

    public synchronized void destroyDriver(String method) {
        drivers.remove(method);
    }

    public Set<String> getDriverSet() {
        return drivers.keySet();
    }

    private String generateKey(String method) {
        return method + Thread.currentThread().getId();
    }

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
}
