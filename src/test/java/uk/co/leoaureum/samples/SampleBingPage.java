package uk.co.leoaureum.samples;

import org.openqa.selenium.Keys;
import uk.co.leoaureum.testdriver.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Sample page object for Google search
 */
public class SampleBingPage extends AbstractPage {

    @FindBy(id = "sb_form_q")
    private WebElement searchInput;

    public SampleBingPage(WebDriver driver) {
        super(driver);
    }

    public SampleBingPage search(String query) {
        wait.forElementVisible(searchInput);
        searchInput.sendKeys(query);
        return this;
    }
}
