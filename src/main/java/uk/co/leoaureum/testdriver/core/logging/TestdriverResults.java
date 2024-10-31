package uk.co.leoaureum.testdriver.core.logging;

import org.testng.ISuite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestdriverResults {

    private final Map<String, List<LogEntry>> logs = new HashMap<>();

    public TestdriverResults() {
    }

    public void addLogs(String method, List<LogEntry> entries) {
        logs.put(method,entries);
    }

    public Set<String> getMethods() {
        return logs.keySet();
    }

    public List<LogEntry> getEntries(String method) {
        return logs.get(method);
    }

    public boolean isFailed(String method) {
        List<LogEntry> entries = logs.get(method);
        for (LogEntry entry : entries) {
            if (entry.getLogLevel().equals(LogLevel.ERROR)) {
                return true;
            }
        }
        return false;
    }

    public void addInfo(List<ISuite> results) {

    }
}
