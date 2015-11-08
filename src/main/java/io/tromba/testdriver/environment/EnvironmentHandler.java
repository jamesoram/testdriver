package io.tromba.testdriver.environment;

/**
 * Interface for handling environments.
 */
public interface EnvironmentHandler {

    String getStartUrl();

    void loadEnvironment();
}
