package uk.co.leoaureum.testdriver.environment;

import java.util.List;

/**
 * Copyright (C) James Oram 2014-2025
 * Simple URL-based handler for multi-variate tests.
 */
public class WebDriverUrlMvtHandler implements MvtHandler {

    private List<String> mvts;
    private String mvtGetParameter = "?mvt=";
    private String url;

    public WebDriverUrlMvtHandler(String url) {
        this.url = url;
    }

    /**
     * Return a list of all active MVTs.
     * @return the list of active MVTs.
     */
    public List<String> getMvts() {
        return mvts;
    }

    /**
     * Ensure the specified list of MVTs is active
     * @param mvts MVTs to activate.
     * @return a URL with the MVTs to activate.
     */
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
