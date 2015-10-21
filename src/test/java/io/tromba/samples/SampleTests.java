package io.tromba.samples;

import io.tromba.testdriver.core.BaseTestdriverTest;
import io.tromba.testdriver.core.TestdriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Smoke test.
 */
public class SampleTests extends BaseTestdriverTest {

    public SampleTests() {
        super(new TestdriverManager());
    }

    @Test
    public void testGetAPage() {
        driver().get("http://tromba.io");
    }

    @Test(dataProvider = "queries")
    public void testSearchGoogle(String query) {
        driver().get("https://google.com");
        driver().findElement(By.id("lst-ib")).sendKeys(query);
        Assert.assertTrue(driver().getTitle().contains("Google"));
    }

    @DataProvider(name = "queries", parallel = true)
    public Object[][] provideQueries() {
        return new Object[][] { { "Selenium" }, { "webdriver" }, { "BDD" }, { "wireshark" }, { "charles proxy" },
                { "Cucumber-jvm" }, { "Behat" } };
    }
}