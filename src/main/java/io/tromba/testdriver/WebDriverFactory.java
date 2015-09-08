package io.tromba.testdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Factory for WebDrivers.
 */
public class WebDriverFactory {

    public WebDriver createInstance() {
        return new ChromeDriver();
    }
}
