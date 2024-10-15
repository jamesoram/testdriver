package uk.co.leoaureum.testdriver.utils;

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

    private static String browser;

    private static String version;

    private static String platform;

    private TestdriverConfig() {
        TestdriverConfigLoader configLoader = new TestdriverConfigLoader();
        grid = configLoader.get("grid");
        maxWaitInSeconds = configLoader.get("maxWaitInSeconds");
        maxImplicitWaitInSeconds = configLoader.get("maxImplicitWaitInSeconds");
        globalTimeoutInMillis = configLoader.get("globalTimeoutInMillis");
        maxRetries = configLoader.get("maxRetries");
        browser = configLoader.get("browser");
        version = configLoader.get("version");
        platform = configLoader.get("platform");
    }

    /**
     * Ugly singleton for config.
     * @return the config instance.
     */
    public static TestdriverConfig getInstance() {
        synchronized (TestdriverConfig.class) {
            if (null == testdriverConfig) {
                testdriverConfig = new TestdriverConfig();
            }
            return testdriverConfig;
        }
    }

    public static String getGrid() {
        return grid;
    }

    public static String getBrowser() {
        return browser;
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

    public static String getVersion() {
        return version;
    }

    public static String getPlatform() {
        return platform;
    }
}
