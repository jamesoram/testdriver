package io.tromba.samples;

import io.tromba.testdriver.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Sample page object for Google search
 */
public class SampleGooglePage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement searchInput;

    public SampleGooglePage(WebDriver driver) {
        super(driver);
    }

    public SampleGooglePage search(String query) {
        wait.forElementVisible(searchInput);
        searchInput.sendKeys(query);
        return this;
    }
}
