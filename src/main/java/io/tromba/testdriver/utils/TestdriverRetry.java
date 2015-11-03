package io.tromba.testdriver.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implementation of IRetryAnalyzer.
 */
public class TestdriverRetry implements IRetryAnalyzer {

    private static final int MAX_RETRIES = Integer.parseInt(TestdriverConfig.getInstance().getMaxRetries());
    private ThreadLocal<Integer> retries = new ThreadLocal<Integer>() {
        @Override
        public synchronized Integer initialValue() {
            return new Integer(0);
        }
    };

    public boolean retry(ITestResult result) {
        if (retries.get() < MAX_RETRIES) {
            retries.set(retries.get() + 1);
            return true;
        } else {
            retries.set(0);
            return false;
        }
    }
}
