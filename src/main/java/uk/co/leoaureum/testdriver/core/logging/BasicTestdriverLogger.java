package uk.co.leoaureum.testdriver.core.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logger for testdriver tests.
 */
public class BasicTestdriverLogger implements TestdriverLogger {

    private static final Logger logger = Logger.getLogger(BasicTestdriverLogger.class.getName());
    private final List<LogEntry> entries = new ArrayList<>();
    private final String method;

    public BasicTestdriverLogger(String methodName) {
        this.method = UUID.randomUUID() + " " + methodName;
    }

    /**
     * Adds the received parameters to the LogEntry list.
     * @param logLevel the level of the log (see LogLevel)
     * @param message the message we expect it to contain
     */
    public void log(LogLevel logLevel, String message) {
        LogEntry entry = new LogEntry(method, logLevel, message);
        logger.log(Level.INFO, entry.getEntryAsString());
        entries.add(entry);
    }

    /**
     * Prints all the logs.
     */
    public void write() {
        for (LogEntry entry: entries) {
            logger.log(Level.FINE, entry.getEntryAsString());
        }
    }
}
