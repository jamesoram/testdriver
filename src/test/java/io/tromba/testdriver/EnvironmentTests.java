package io.tromba.testdriver;

import io.tromba.testdriver.environment.EnvironmentHandler;
import io.tromba.testdriver.environment.UrlEnvironmentHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests for the environment handlers.
 */
public class EnvironmentTests {

    @Test
    public void testProductionEnvironment() {
        final String expectedUrl = "http://tromba.io";
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING;

        List<String> urlList = new ArrayList<String>();
        urlList.add(initialUrl);
        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler(urlList);
        String foundUrl = environmentHandler.getStartUrls(".io").get(0);
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testStagingEnvironment() {
        final String expectedUrl = "http://tromba-staging.int";
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING;

        List<String> urlList = new ArrayList<String>();
        urlList.add(initialUrl);
        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler(urlList);

        String foundUrl = environmentHandler.getStartUrls("-staging.int").get(0);
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testProductionStandard() {
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING + ".io";
        final String expectedUrl = "http://tromba.io";

        List<String> urlList = new ArrayList<String>();
        urlList.add(initialUrl);
        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler(urlList);

        String foundUrl = environmentHandler.getStartUrls("").get(0);
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testStagingStandard() {
        final String initialUrl  = "http://tromba"  + UrlEnvironmentHandler.MAGIC_STRING + ".io";
        final String expectedUrl = "http://tromba.staging.io";

        List<String> urlList = new ArrayList<String>();
        urlList.add(initialUrl);
        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler(urlList);

        String foundUrl = environmentHandler.getStartUrls(".staging").get(0);
        Assert.assertEquals(foundUrl, expectedUrl);
    }
}
