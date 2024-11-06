package uk.co.leoaureum.samples;

import uk.co.leoaureum.testdriver.core.BaseTestdriverTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.co.leoaureum.testdriver.core.logging.LogLevel;


/**
 * Smoke test.
 */
public class SampleTests extends BaseTestdriverTest {

    @Test
    public void testGetAPage() {
        driver().get("http://leoaureum.co.uk/");
        System.out.println(getTestId());
    }

    @Test(dataProvider = "queries")
    public void testSearch(String query) {
        driver().get("https://duckduckgo.com/");
        String result = new SampleDuckDuckGoPage(driver()).type(query).getFirstResultText();
        logger().log(LogLevel.INFO, "Expecting " + result + " to contain " + query);
        assertTrue(result.toLowerCase().contains(query.toLowerCase()));
        for (int i = 0; i < 1000; i++) {
            assertTrue(driver().getTitle().toLowerCase().contains(query.toLowerCase()));
        }
    }

    @DataProvider(name = "queries", parallel = true)
    public Object[][] provideQueries() {
        return new Object[][] { { "Selenium" }, { "webdriver" }, { "test" }, { "BDD" }, { "testdriver" } };
    }
}
