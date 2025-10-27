package uk.co.leoaureum.samples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.leoaureum.testdriver.pages.AbstractPage;

/**
 * Copyright (C) James Oram 2014-2025
 */
public class SampleDuckDuckGoResultsPage extends AbstractPage {

    @FindBy(xpath = "id('r1-0')//h2")
    private WebElement firstResultH2;

    /**
     * Sets up the basics for the results page.
     *
     * @param driver the driver to use.
     */
    public SampleDuckDuckGoResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstResultText() {
        return firstResultH2.getText();
    }
}
