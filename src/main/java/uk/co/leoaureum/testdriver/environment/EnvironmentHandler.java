package uk.co.leoaureum.testdriver.environment;

import java.util.List;

/**
 * Interface for handling environments.
 */
public interface EnvironmentHandler {

    List<String> getStartUrls(String environment);
}
