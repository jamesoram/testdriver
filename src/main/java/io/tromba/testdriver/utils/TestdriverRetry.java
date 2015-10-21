package io.tromba.testdriver.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implementation of IRetryAnalyzer.
 */
public class TestdriverRetry implements IRetryAnalyzer {

    private static final int MAX_RETRIES = 3;
    private ThreadLocal<Integer> retries = new ThreadLocal<Integer>() {
        @Override
        public synchronized Integer initialValue() {
            return new Integer(0);
        }
    };

    public boolean retry(ITestResult result) {
        retries.set(retries.get() + 1);

        if (retries.get() <= MAX_RETRIES) {

            return true;
        } else {
            retries.set(0);
            return false;
        }
    }
}
