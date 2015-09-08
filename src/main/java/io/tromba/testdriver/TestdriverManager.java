package io.tromba.testdriver;

import io.tromba.testdriver.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;

import java.util.Map;

/**
 * Manager class for WebDrivers.
 */
public class TestdriverManager {

    private static Map<IInvokedMethod, WebDriver> drivers;

    public synchronized void setDriver(IInvokedMethod method, WebDriver driver) {
        drivers.put(method, driver);
    }

    public WebDriver getDriver(IInvokedMethod method) throws DriverNotFoundException {
        WebDriver driver = drivers.get(method);

        if (null == driver) {
            throw new DriverNotFoundException();
        }

        return driver;
    }

    public synchronized void destroyDriver(IInvokedMethod method) {
        drivers.remove(method);
    }
}
