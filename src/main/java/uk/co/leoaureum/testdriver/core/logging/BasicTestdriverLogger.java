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
    private String id;

    public BasicTestdriverLogger(String methodName) {
        this.method = methodName + "_" + UUID.randomUUID();
    }

    /**
     * Adds the received parameters to the LogEntry list.
     * @param logLevel the level of the log (see LogLevel)
     * @param message the message we expect it to contain
     */
    public void log(LogLevel logLevel, String message, Level level) {
        LogEntry entry = new LogEntry(method, logLevel, message);
        logger.log(level, entry.getEntryAsString());
        entries.add(entry);
    }

    public void log(LogLevel logLevel, String message) {
        log(logLevel, message, Level.FINE);
    }

    public void log(String message) {
        log(LogLevel.INFO, message, Level.INFO);
    }

    /**
     * Prints all the logs.
     */
    public void write() {
        for (LogEntry entry: entries) {
            logger.log(Level.FINE, entry.getEntryAsString());
        }
    }

    public List<LogEntry> getEntries() {
        return entries;
    }

    public String getMethod() {
        return method;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
