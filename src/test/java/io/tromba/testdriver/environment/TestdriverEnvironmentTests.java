package io.tromba.testdriver.environment;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tests for the environment handlers.
 */
public class TestdriverEnvironmentTests {

    @Test
    public void testProductionEnvironment() {
        final String expectedUrl = "http://tromba.io";
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING;

        List<String> urlList = new ArrayList<String>();
        urlList.add(initialUrl);
        Map<String, String> envDns = new HashMap<String, String>();
        envDns.put("prod", ".io");
        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler(urlList, envDns);
        String foundUrl = environmentHandler.getStartUrls("prod").get(0);
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testStagingEnvironment() {
        final String expectedUrl = "http://tromba-staging.int";
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING;

        Map<String, String> envDns = new HashMap<String, String>();
        envDns.put("staging", "-staging.int");
        List<String> urlList = new ArrayList<String>();
        urlList.add(initialUrl);
        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler(urlList, envDns);
        String foundUrl = environmentHandler.getStartUrls("staging").get(0);
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testProductionStandard() {
        final String initialUrl  = "http://tromba" + UrlEnvironmentHandler.MAGIC_STRING + ".io";
        final String expectedUrl = "http://tromba.io";

        Map<String, String> envDns = new HashMap<String, String>();
        envDns.put("prod", "");
        List<String> urlList = new ArrayList<String>();
        urlList.add(initialUrl);
        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler(urlList, envDns);
        String foundUrl = environmentHandler.getStartUrls("").get(0);
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testStagingStandard() {
        final String initialUrl  = "http://tromba"  + UrlEnvironmentHandler.MAGIC_STRING + ".io";
        final String expectedUrl = "http://tromba.staging.io";

        Map<String, String> envDns = new HashMap<String, String>();
        envDns.put("staging", ".staging");
        List<String> urlList = new ArrayList<String>();
        urlList.add(initialUrl);
        EnvironmentHandler environmentHandler = new UrlEnvironmentHandler(urlList, envDns);
        String foundUrl = environmentHandler.getStartUrls("staging").get(0);
        Assert.assertEquals(foundUrl, expectedUrl);
    }

    @Test
    public void testSetMvt() {
        String mvt = "aer.1";
        String initialUrl = "http://tromba.io";
        String expectedUrl = "http://tromba.io/?mvt=" + mvt;
        List<String> mvts = new ArrayList<String>();
        mvts.add(mvt);

        WebDriverUrlMvtHandler urlMvtHandler = new WebDriverUrlMvtHandler(initialUrl);
        String result = urlMvtHandler.addMvts(mvts);
        Assert.assertEquals(result, expectedUrl);
    }

    @Test
    public void testSetMvts() {
        String mvt1 = "aer.1";
        String mvt2 = "something.0";
        String initialUrl = "http://tromba.io";
        String expectedUrl = "http://tromba.io/?mvt=" + mvt1 + "&mvt=" + mvt2;
        List<String> mvts = new ArrayList<String>();
        mvts.add(mvt1);
        mvts.add(mvt2);

        WebDriverUrlMvtHandler urlMvtHandler = new WebDriverUrlMvtHandler(initialUrl);
        String result = urlMvtHandler.addMvts(mvts);
        Assert.assertEquals(result, expectedUrl);
    }

    @Test
    public void testSetMvtsWithMoreGetParameters() {
        String mvt1 = "aer.1";
        String mvt2 = "something.0";
        String initialUrl = "http://tromba.io/somewhere/cool/?get=parameter";
        String expectedUrl = "http://tromba.io/somewhere/cool/?get=parameter&mvt=" + mvt1 + "&mvt=" + mvt2;
        List<String> mvts = new ArrayList<String>();
        mvts.add(mvt1);
        mvts.add(mvt2);

        WebDriverUrlMvtHandler urlMvtHandler = new WebDriverUrlMvtHandler(initialUrl);
        String result = urlMvtHandler.addMvts(mvts);
        Assert.assertEquals(result, expectedUrl);
    }
}
