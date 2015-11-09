package io.tromba.testdriver.environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Simple environment handler based on URLs.
 */
public class UrlEnvironmentHandler implements EnvironmentHandler {

    public static final String MAGIC_STRING = "%ENV";
    private Map<String, String> environmentDns;
    private List<String> urls;

    public UrlEnvironmentHandler(List<String> urls, Map<String, String> environment) {
        setUrls(urls);
        environmentDns = environment;
    }

    public UrlEnvironmentHandler(String environmentFileName) {
        throw new RuntimeException("not implemented");
    }

    public UrlEnvironmentHandler() {
        urls = new ArrayList<String>();
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getStartUrls(String environment) {
        List<String> formattedUrls = new ArrayList<String>();

        String replacement = environmentDns.get(environment);
        if (null == replacement) {
            replacement = "";
        }
        for (String url : urls) {
            formattedUrls.add(url.replace(MAGIC_STRING, replacement));
        }
        return formattedUrls;
    }
}
