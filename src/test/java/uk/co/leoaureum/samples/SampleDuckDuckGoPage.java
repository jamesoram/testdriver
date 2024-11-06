package uk.co.leoaureum.samples;

import org.openqa.selenium.Keys;
import uk.co.leoaureum.testdriver.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Sample page object for Google search
 */
public class SampleDuckDuckGoPage extends AbstractPage {

    @FindBy(id = "searchbox_input")
    private WebElement searchInput;

    public SampleDuckDuckGoPage(WebDriver driver) {
        super(driver);
    }

    public SampleDuckDuckGoResultsPage type(String query) {
        wait.forElementVisible(searchInput);
        searchInput.sendKeys(query + Keys.ENTER);
        return new SampleDuckDuckGoResultsPage(driver);
    }
}
