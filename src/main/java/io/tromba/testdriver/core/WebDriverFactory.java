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

    private static final TestdriverConfig config = TestdriverConfig.getInstance();
    private static final String URL = config.getGrid();
    private static final String browser = config.getBrowser();

    /**
     * Create a new WebDriver by connecting to the Selenium Grid.
     * @return the newly-created driver.
     */
    public static WebDriver createInstance() {
        Capabilities capabilities = null;
        if (browser.equals("chrome")) {
            capabilities = DesiredCapabilities.chrome();
        } else if (browser.equals("firefox")) {
            capabilities = DesiredCapabilities.firefox();
        } else if (browser.equals("ie")) {
            capabilities = DesiredCapabilities.internetExplorer();
        } else {
            capabilities = DesiredCapabilities.phantomjs();
        }

        try {
            return new RemoteWebDriver(new URL(URL), capabilities);
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Malformed Remote WebDriver URL: " + URL + "\n" + ex.getMessage());
        }
    }
}
