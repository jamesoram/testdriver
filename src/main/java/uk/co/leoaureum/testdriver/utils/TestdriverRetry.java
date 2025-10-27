package uk.co.leoaureum.testdriver.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.logging.Logger;

/**
 * Copyright (C) James Oram 2014-2025
 * Implementation of IRetryAnalyzer.
 */
public class TestdriverRetry implements IRetryAnalyzer {
    private final Logger logger = Logger.getLogger(TestdriverRetry.class.getName());
    private static final int MAX_RETRIES = Integer.parseInt(TestdriverConfig.getInstance().getMaxRetries());
    private final ThreadLocal<Integer> retries = new ThreadLocal<>() {
        @Override
        public synchronized Integer initialValue() {
            return 0;
        }
    };

    /**
     * If the retry count hasn't been reached, try again.
     * @param result the test result.
     * @return true if we retry, otherwise false.
     */
    @Override
    public boolean retry(ITestResult result) {
        if (retries.get() < MAX_RETRIES) {
            retries.set(retries.get() + 1);
            logger.info("Retrying test " + result.getName());
            return true;
        } else {
            logger.info("Maximum amount of retries reached for test " + result.getMethod());
            retries.set(0);
            return false;
        }
    }
}
