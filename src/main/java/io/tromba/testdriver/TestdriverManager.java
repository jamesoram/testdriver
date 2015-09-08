package io.tromba.testdriver;

import io.tromba.testdriver.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;

import java.util.Map;

/**
 * Created by jao on 08/09/15.
 */
public class TestdriverManager {

    private Map<IInvokedMethod, WebDriver> drivers;

    public void setDriver(IInvokedMethod method, WebDriver driver) {
        drivers.put(method, driver);
    }

    public WebDriver getDriver(IInvokedMethod method) throws DriverNotFoundException {
        WebDriver driver = drivers.get(method);

        if (null == driver) {
            throw new DriverNotFoundException();
        }

        return driver;
    }
}
