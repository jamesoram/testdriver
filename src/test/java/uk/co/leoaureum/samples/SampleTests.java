package uk.co.leoaureum.samples;

import uk.co.leoaureum.testdriver.core.BaseTestdriverTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Smoke test.
 */
public class SampleTests extends BaseTestdriverTest {

    @Test
    public void testGetAPage() {
        driver().get("http://leoaureum.co.uk/");
    }

    @Test(dataProvider = "queries")
    public void testSearchGoogle(String query) {
        driver().get("https://bing.com/");
        new SampleBingPage(driver()).search(query);
        Assert.assertTrue(driver().getTitle().contains("Bing"));
    }

    @Test(enabled = false)
    public void testRetries() {
        driver().get("https://google.com");
        driver().findElement(By.id("something"));
    }

    @DataProvider(name = "queries", parallel = true)
    public Object[][] provideQueries() {
        return new Object[][] { { "Selenium" }, { "webdriver" }, { "BDD" }, { "wireshark" }, { "charles proxy" },
                { "Cucumber-jvm" }, { "Behat" } };
    }
}
