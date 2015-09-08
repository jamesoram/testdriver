package io.tromba.testdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by jao on 08/09/15.
 */
public class WebDriverFactory {

    public WebDriver createInstance() {
        return new ChromeDriver();
    }
}
