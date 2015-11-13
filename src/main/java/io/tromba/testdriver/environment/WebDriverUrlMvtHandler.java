package io.tromba.testdriver.environment;

import java.util.List;

/**
 * Simple URL-based handler for multi-variate tests.
 */
public class WebDriverUrlMvtHandler implements MvtHandler {

    private List<String> mvts;
    private String mvtGetParameter = "?mvt=";
    private String url;

    public WebDriverUrlMvtHandler(String url) {
        this.url = url;
    }

    public List<String> getMvts() {
        return mvts;
    }

    public void setMvts(List<String> mvts) {
        this.mvts = mvts;
    }

    public String addMvts(List<String> mvts) {
        for (String mvt: mvts) {
            if (url.contains("?")) {
                url += "&mvt=" + mvt;
            } else {
                if (!url.endsWith("/")) {
                    url += "/";
                }
                url += "?mvt=" + mvt;
            }
        }
        return url;
    }
}
