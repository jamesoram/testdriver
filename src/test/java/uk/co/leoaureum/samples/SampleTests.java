package uk.co.leoaureum.samples;

import uk.co.leoaureum.testdriver.core.BaseTestdriverTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

/**
 * Smoke test.
 */
public class SampleTests extends BaseTestdriverTest {

    @Test
    public void testGetAPage() {
        driver().get("http://leoaureum.co.uk/");
    }

    @Test(dataProvider = "queries")
    public void testSearchBing(String query) {
        driver().get("https://bing.com/");
        new SampleBingPage(driver()).type(query);
    }

    @DataProvider(name = "queries", parallel = true)
    public Object[][] provideQueries() {
        return new Object[][] { { "Selenium" }, { "webdriver" } };
    }
}
