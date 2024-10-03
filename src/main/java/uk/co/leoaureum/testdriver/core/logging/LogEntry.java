package uk.co.leoaureum.testdriver.core.logging;

/**
 * Entry for the Testdriver logger.
 */
public class LogEntry {

    private LogLevel logLevel;

    private long timeInMillis;

    private String testId;

    private String message;

    public LogEntry(LogLevel level) {
        timeInMillis = System.currentTimeMillis();
        logLevel = level;
    }

    public LogEntry(LogLevel level, String message) {
        this(level);
        setMessage(message);
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
