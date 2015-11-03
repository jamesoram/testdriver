package io.tromba.testdriver.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Class for loading and holding the framework configuration.
 */
public class TestdriverConfig {

    private String file;
    private Config config;

    public TestdriverConfig(String file) {
        this.file = file;
        this.config = ConfigFactory.load(file);
    }

    public TestdriverConfig() {
        this("testdriver.conf");
    }

    public String get(String key) {
        return config.getString(key);
    }
}
