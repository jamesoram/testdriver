package uk.co.leoaureum.testdriver.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.co.leoaureum.testdriver.core.BaseTestdriverTest;

public class TestdriverLoggingTest extends BaseTestdriverTest {

    @Test(dataProvider = "provider")
    public void testUuidAndDriver(int x) {
        String id = getTestId();
        WebDriver driver = driver();
        for (int i = 0; i < 1000; i++) {
            assertEquals(id, getTestId());
            Assert.assertEquals(driver, driver());
        }
    }

    @DataProvider(name = "provider", parallel = true)
    public Object[] provider() {
        Object[][] data = new Object[10][1];
        for (int i = 0; i < 10; i++) {
            data[i][0] = i;  // Fill the array with integers 0 through 999
        }
        return data;
    }
}
