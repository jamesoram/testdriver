package io.tromba.testdriver.environment;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple environment handler based on URLs.
 */
public class UrlEnvironmentHandler implements EnvironmentHandler {

    public static final String MAGIC_STRING = "%ENV";

    private List<String> urls;

    public UrlEnvironmentHandler(List<String> urls) {
        setEnvironments(urls);
    }

    public UrlEnvironmentHandler(String environmentFileName) {
        throw new RuntimeException("not implemented");
    }

    public UrlEnvironmentHandler() {
        urls = new ArrayList<String>();
    }

    public void setEnvironments(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getStartUrls(String environment) {
        List<String> formattedUrls = new ArrayList<String>();

        for (String url : urls) {
            formattedUrls.add(url.replace(MAGIC_STRING, environment));
        }
        return formattedUrls;
    }
}
