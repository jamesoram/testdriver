package uk.co.leoaureum.testdriver.core.logging;

import org.testng.ISuite;
import java.util.*;

/**
 * Copyright (C) James Oram 2014-2025
 */
public class TestdriverResults {

    private final Map<String, List<LogEntry>> logs = new HashMap<>();
    private final Map<String, String> methodIds = new HashMap<>();
    private final List<ISuite> suites = new ArrayList<>();

    public TestdriverResults() {
    }

    public void addLogs(String method, List<LogEntry> entries, String id) {
        logs.put(method, entries);
        methodIds.put(method, id);
    }

    public Set<String> getMethods() {
        return logs.keySet();
    }

    public List<LogEntry> getEntries(String method) {
        return logs.get(method);
    }

    public boolean isFailed(String method) {
        String id = methodIds.get(method);

        return suites.stream()
                // Stream through each suite
                .flatMap(suite -> suite.getAllMethods().stream()
                        // Filter methods that match the id and the method name
                        .filter(tnMethod -> tnMethod.getId().equals(id) && method.contains(tnMethod.getMethodName()))
                        // Now flatMap to get all test results from each suite
                        .flatMap(tnMethod -> suite.getResults().values().stream()
                                // Flatten each result set into a stream of failed test results for this method
                                .flatMap(result -> result.getTestContext().getFailedTests().getResults(tnMethod).stream())
                        )
                )
                // Check if any failed test result is not successful
                .anyMatch(result1 -> !result1.isSuccess());
    }


    public String getId(String method) {
        return methodIds.get(method);
    }

    public void addInfo(List<ISuite> results) {
        suites.addAll(results);
    }
}
