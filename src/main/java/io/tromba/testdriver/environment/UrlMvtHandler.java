package io.tromba.testdriver.environment;

import java.util.List;

/**
 * Simple URL-based handler for multi-variate tests.
 */
public class UrlMvtHandler implements MvtHandler {

    private List<String> mvts;

    public UrlMvtHandler(List<String> mvts) {
        setMvts(mvts);
    }

    public List<String> getMvts() {
        return mvts;
    }

    public void setMvts(List<String> mvts) {
        this.mvts = mvts;
    }
}
