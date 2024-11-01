package uk.co.leoaureum.testdriver.core.logging;

import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.*;

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
        for (ISuite suite : suites) {
            for (ITestNGMethod tnMethod : suite.getAllMethods()) {
                if (tnMethod.getId().equals(id) && method.contains(tnMethod.getMethodName())) {
                    System.out.println("Found id " + id);
                    for (ISuiteResult result : suite.getResults().values()) {
                        Set<ITestResult> testResult = result.getTestContext().getFailedTests().getResults(tnMethod);
                        for (ITestResult result1 : testResult) {
                            if (!result1.isSuccess()) {
                                return true;
                            }
                        }

                    }
                }
            }
        }
        return false;
    }

    public String getId(String method) {
        return methodIds.get(method);
    }

    public void addInfo(List<ISuite> results) {
        suites.addAll(results);
    }
}
