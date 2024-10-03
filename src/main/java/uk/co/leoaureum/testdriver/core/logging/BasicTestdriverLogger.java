package uk.co.leoaureum.testdriver.core.logging;

import java.util.ArrayList;
import java.util.List;

/**
 * Logger for testdriver tests.
 */
public class BasicTestdriverLogger implements TestdriverLogger {

    private List<LogEntry> entries = new ArrayList<LogEntry>();

    /**
     * Adds the received parameters to the LogEntry list.
     * @param logLevel the level of the log (see LogLevel)
     * @param message the message we expect it to contain
     */
    public void log(LogLevel logLevel, String message) {
        LogEntry entry = new LogEntry(logLevel);
        entry.setMessage(message);
        entries.add(entry);
    }

    /**
     * Prints all the logs.
     */
    public void write() {
        for (LogEntry entry: entries) {
            System.out.println(entry.getMessage());
        }
    }
}
