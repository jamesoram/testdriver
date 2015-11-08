package io.tromba.testdriver;

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
    }

    @Test
    public void testStagingEnvironment() {
        final String expectedUrl = "http://tromba-staging.int";
        final String initialUrl  = "http://tromba%ENV";

        // magic here
    }

    @Test
    public void testProductionStandard() {
        final String initialUrl  = "http://tromba%ENV.io";
        final String expectedUrl = "http://tromba.io";
    }

    @Test
    public void testStagingStandard() {
        final String initialUrl  = "http://tromba%ENV.io";
        final String expectedUrl = "http://tromba.staging.io";
    }
}
