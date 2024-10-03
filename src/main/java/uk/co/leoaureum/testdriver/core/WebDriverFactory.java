package uk.co.leoaureum.testdriver.core;

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

    private static final TestdriverConfig config = TestdriverConfig.getInstance();
    private static final String URL = config.getGrid();
    private static final String browser = config.getBrowser();
    private static final String version = config.getVersion();

    /**
     * Create a new WebDriver by connecting to the Selenium Grid.
     * @return the newly-created driver.
     */
    public static WebDriver createInstance(String name) {
        Map<String, String> caps = new HashMap<>();
        caps.put("browserName", "chrome");
        caps.put("se:name", name);
//        caps.put("platformName", "platformName");
        Capabilities capabilities = new DesiredCapabilities(caps);//(browser, version, Platform.ANY);
        try {
            return new RemoteWebDriver(new URL(URL), capabilities);
        } catch (MalformedURLException ex) {
            throw new RuntimeException("Malformed Remote WebDriver URL: " + URL + "\n" + ex.getMessage());
        }
    }
}
