package io.tromba.testdriver.environment;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple environment handler based on URLs.
 */
public class UrlEnvironmentHandler implements EnvironmentHandler {

    public static final String MAGIC_STRING = "%ENV";

    private Map<String, String> environments;

    public UrlEnvironmentHandler(Map<String, String> environments) {
        setEnvironments(environments);
    }

    public UrlEnvironmentHandler(String environmentFileName) {
        // load envs from file
    }

    public UrlEnvironmentHandler() {
        environments = new HashMap<String, String>();
    }

    public void setEnvironments(Map<String, String> environments) {
        this.environments = environments;
    }

    public String getStartUrl(String environment) {
        return environments.get(environment);
    }
}
