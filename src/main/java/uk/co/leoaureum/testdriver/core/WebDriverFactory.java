package uk.co.leoaureum.testdriver.core;

import uk.co.leoaureum.testdriver.core.logging.LogLevel;
import uk.co.leoaureum.testdriver.core.logging.TestdriverLogger;
import uk.co.leoaureum.testdriver.utils.TestdriverConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory for WebDrivers.
 */
public class WebDriverFactory {

    public static final String URL = TestdriverConfig.getGrid();
    public static final String browser = TestdriverConfig.getBrowser();
    public static final String version = TestdriverConfig.getVersion();
    public static final String platform = TestdriverConfig.getPlatform();

    /**
     * Create a new WebDriver by connecting to the Selenium Grid.
     * @return the newly-created driver.
     */
    public static WebDriver createInstance(String name, TestdriverLogger logger) {
        Map<String, String> caps = new HashMap<>();
        caps.put("browserName", browser);
        caps.put("se:name", name);
        caps.put("platformName", platform);
        Capabilities capabilities = new DesiredCapabilities(caps);
        try {
            logger.log(LogLevel.INFO, "creating " + browser);
            return new RemoteWebDriver(new URL(URL), capabilities);
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Malformed Remote WebDriver URL: " + URL + "\n" + ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error: "+ e.getMessage());
        }
    }
}
