package io.tromba.testdriver;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests for the environment handlers.
 */
public class EnvironmentTests {

    @Test
    public void testProductionEnvironment() {
        final String expectedUrl = "http://tromba.io";
        final String initialUrl  = "http://tromba%ENV";

        // do stuff
        String foundUrl = "";
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testStagingEnvironment() {
        final String expectedUrl = "http://tromba-staging.int";
        final String initialUrl  = "http://tromba%ENV";

        // magic here
        String foundUrl = "";
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testProductionStandard() {
        final String initialUrl  = "http://tromba%ENV.io";
        final String expectedUrl = "http://tromba.io";

        String foundUrl = "";
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testStagingStandard() {
        final String initialUrl  = "http://tromba%ENV.io";
        final String expectedUrl = "http://tromba.staging.io";

        String foundUrl = "";
        Assert.assertEquals(foundUrl, expectedUrl);
    }
}
