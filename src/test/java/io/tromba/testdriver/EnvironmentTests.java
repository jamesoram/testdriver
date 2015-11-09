package io.tromba.testdriver;

import io.tromba.testdriver.environment.EnvironmentHandler;
import io.tromba.testdriver.environment.UrlEnvironmentHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests for the environment handlers.
 */
public class EnvironmentTests {

    @Test
    public void testProductionEnvironment() {

        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler();
        final String expectedUrl = "http://tromba.io";
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING;

        // do stuff
        String foundUrl = "";
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testStagingEnvironment() {
        final String expectedUrl = "http://tromba-staging.int";
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING;

        // magic here
        String foundUrl = "";
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testProductionStandard() {
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING + ".io";
        final String expectedUrl = "http://tromba.io";

        String foundUrl = "";
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testStagingStandard() {
        final String initialUrl  = "http://tromba"  + UrlEnvironmentHandler.MAGIC_STRING + "io";
        final String expectedUrl = "http://tromba.staging.io";

        String foundUrl = "";
        Assert.assertEquals(foundUrl, expectedUrl);
    }
}
