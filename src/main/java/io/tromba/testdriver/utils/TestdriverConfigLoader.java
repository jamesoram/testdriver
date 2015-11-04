package io.tromba.testdriver.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Class for loading and holding the framework configuration.
 */
public class TestdriverConfigLoader {

    private String file;
    private Config config;

    public TestdriverConfigLoader(String file) {
        this.file = file;
        this.config = ConfigFactory.load(file);
    }

    public TestdriverConfigLoader() {
        this("testdriver.conf");
    }

    /**
     * Return the value for a given key.
     * @param key the key for which to find the value.
     * @return the value associated with the key.
     */
    public String get(String key) {
        return config.getString(key);
    }
}
