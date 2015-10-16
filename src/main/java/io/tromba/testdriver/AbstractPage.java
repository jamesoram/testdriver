package io.tromba.testdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Abstract Page is a basic page representation from which all pages should inherit.
 */
public class AbstractPage {

    protected WebDriver driver;
    protected TestdriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new TestdriverWait(driver, 30);
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
