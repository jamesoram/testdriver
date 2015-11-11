package io.tromba.testdriver.environment;

import java.util.List;

/**
 * Interface for dealing with multi-variate tests.
 */
public interface MvtHandler {

    List<String> getMvts();

    void setMvts(List<String> mvts);

    String addMvts(List<String> mvts);
}
