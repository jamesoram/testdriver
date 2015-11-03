package io.tromba.testdriver.utils;

/**
 * Class to hold configuration for testdriver.
 */
public class TestdriverConfig {

    private static TestdriverConfig testdriverConfig;

    private static String grid;

    private static String maxWaitInSeconds;

    private static String maxImplicitWaitInSeconds;

    private static String globalTimeoutInMillis;

    private static String maxRetries;

    private TestdriverConfig() {
        TestdriverConfigLoader configLoader = new TestdriverConfigLoader();
        grid = configLoader.get("grid");
        maxWaitInSeconds = configLoader.get("maxWaitInSeconds");
        maxImplicitWaitInSeconds = configLoader.get("maxImplicitWaitInSeconds");
        globalTimeoutInMillis = configLoader.get("globalTimeoutInMillis");
        maxRetries = configLoader.get("maxRetries");
    }

    // ugly singleton for mvp
    public TestdriverConfig getInstance() {
        synchronized (this) {
            if (null == testdriverConfig) {
                testdriverConfig = new TestdriverConfig();
            }
            return testdriverConfig;
        }
    }

    public static String getGrid() {
        return grid;
    }

    public static String getMaxWaitInSeconds() {
        return maxWaitInSeconds;
    }

    public static String getMaxImplicitWaitInSeconds() {
        return maxImplicitWaitInSeconds;
    }

    public static String getGlobalTimeoutInMillis() {
        return globalTimeoutInMillis;
    }

    public static String getMaxRetries() {
        return maxRetries;
    }
}
