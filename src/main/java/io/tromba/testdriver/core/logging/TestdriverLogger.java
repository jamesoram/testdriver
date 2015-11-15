package io.tromba.testdriver.core.logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Logger for testdriver tests.
 */
public class TestdriverLogger {

    private List<LogEntry> entries = new ArrayList<LogEntry>();

    public void log(LogLevel logLevel, String message) {
        LogEntry entry = new LogEntry(logLevel);
        entry.setMessage(message);
    }
}
