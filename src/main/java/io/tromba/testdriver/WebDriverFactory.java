package io.tromba.testdriver;

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

    private static final String url = "http://localhost:4444/wd/hub";

    public static WebDriver createInstance() {
        Capabilities capabilities = DesiredCapabilities.chrome();
        try {
            return new RemoteWebDriver(new URL(url), capabilities);
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Malformed Remote WebDriver URL: " + url + "\n" + ex.getMessage());
        }
    }
}
