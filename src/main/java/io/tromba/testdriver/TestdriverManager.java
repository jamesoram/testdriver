package io.tromba.testdriver;

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
        drivers.put(method, driver);
    }

    public WebDriver getDriver(String method) {
        return drivers.get(method);
    }

    public synchronized void destroyDriver(String method) {
        drivers.remove(method);
    }

    public Set<String> getTestMethods() {
        return drivers.keySet();
    }
}
