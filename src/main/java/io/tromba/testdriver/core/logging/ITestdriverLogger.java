package io.tromba.testdriver.core.logging;

/**
 * Interface for all Testdriver loggers.
 */
public interface ITestdriverLogger {

    /**
     * Add log with level logLevel and message message.
     * @param logLevel the level of the log (see LogLevel)
     * @param message the message we expect it to contain
     */
    public void log(LogLevel logLevel, String message);

    /**
     * Ensure all logging buffers are emptied.
     */
    public void write();
}
