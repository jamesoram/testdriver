package io.tromba.testdriver.environment;

import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Simple URL-based handler for multi-variate tests.
 */
public class UrlMvtHandler implements MvtHandler {

    private List<String> mvts;
    private String mvtGetParameter = "mvt";

    public UrlMvtHandler(List<String> mvts) {
        setMvts(mvts);
    }

    public List<String> getMvts() {
        return mvts;
    }

    public void setMvts(List<String> mvts) {
        this.mvts = mvts;
    }

    public void addMvts(List<String> mvts, WebDriver driver) {
        String url = driver.getCurrentUrl();
        // fudge - use a lib
        for (String mvt: mvts) {
            if (!url.contains("?mvt=")) {
                if (!url.endsWith("/")) {
                    url += "/";
                }
                url += "?mvt=";
            }
            url += mvt;
        }
    }
}
