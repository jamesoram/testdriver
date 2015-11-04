package io.tromba.testdriver.pages;

import io.tromba.testdriver.utils.TestdriverConfig;
import io.tromba.testdriver.utils.TestdriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Abstract Page is a basic page representation from which all pages should inherit.
 */
public class AbstractPage {

    private static final int MAX_WAIT = Integer.parseInt(TestdriverConfig.getInstance().getMaxWaitInSeconds());
    protected WebDriver driver;
    protected TestdriverWait wait;

    /**
     * Sets up the basics for all pages.
     * @param driver the driver to use.
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new TestdriverWait(driver, MAX_WAIT);
    }

    protected WebElement findByLinkText(String text) {
        return driver.findElement(By.linkText(text));
    }

    protected WebElement findByXpathAndText(String xpath, String text) {
        return driver.findElement(By.xpath(String.format(xpath, text)));
    }

    protected List<WebElement> findElementsByXpathAndText(String xpath, String text) {
        return driver.findElements(By.xpath(String.format(xpath, text)));
    }
}
