package io.tromba.testdriver.core;

import io.tromba.testdriver.utils.TestdriverConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Factory for WebDrivers.
 */
public class WebDriverFactory {

    private static final String URL = TestdriverConfig.getInstance().getGrid();

    /**
     * Create a new WebDriver by connecting to the Selenium Grid.
     * @return the newly-created driver.
     */
    public static WebDriver createInstance() {
        Capabilities capabilities = DesiredCapabilities.chrome();
        try {
            return new RemoteWebDriver(new URL(URL), capabilities);
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Malformed Remote WebDriver URL: " + URL + "\n" + ex.getMessage());
        }
    }
}
