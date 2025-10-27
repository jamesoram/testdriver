package uk.co.leoaureum.testdriver.environment;

import java.util.List;

/**
 * Copyright (C) James Oram 2014-2025
 * Interface for handling environments.
 */
public interface EnvironmentHandler {

    List<String> getStartUrls(String environment);
}
