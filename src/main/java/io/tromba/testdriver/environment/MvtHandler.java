package io.tromba.testdriver.environment;

import org.testng.ITestNGMethod;

/**
 * Interface for dealing with multi-variate tests.
 */
public interface MvtHandler {

    String getMvts(ITestNGMethod method);
}
