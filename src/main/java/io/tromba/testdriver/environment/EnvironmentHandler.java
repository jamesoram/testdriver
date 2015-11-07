package io.tromba.testdriver.environment;

/**
 * Interface for handling environments.
 */
public interface EnvironmentHandler {

    public String getStartUrl();

    public void loadEnvironment();
}
