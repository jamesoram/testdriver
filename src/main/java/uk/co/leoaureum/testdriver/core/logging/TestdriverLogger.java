package uk.co.leoaureum.testdriver.core.logging;

import java.util.List;

/**
 * Interface for all Testdriver loggers.
 */
public interface TestdriverLogger {

    /**
     * Add log with level logLevel and text message.
     * @param logLevel the level of the log (see LogLevel)
     * @param message the message we expect it to contain
     */
    void log(LogLevel logLevel, String message);

    /**
     * Ensure all logging buffers are emptied.
     */
    void write();

    /**
     * Name of the originating method
     * @return
     */
    String getMethod();

    /**
     * List of log entries.
     * @return
     */
    List<LogEntry> getEntries();

    /**
     * Set identifier to find a logger.
     * @param id
     */
    void setId(String id);

    /**
     * Get the logger's id.
     * @return logger's id.
     */
    String getId();
}
