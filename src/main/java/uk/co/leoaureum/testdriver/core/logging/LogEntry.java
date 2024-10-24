package uk.co.leoaureum.testdriver.core.logging;

/**
 * Entry for the Testdriver logger.
 */
public class LogEntry {

    private final LogLevel logLevel;
    private final long timeInMillis;
    private String message;
    private final String origin;

    public LogEntry(String origin, LogLevel level) {
        timeInMillis = System.currentTimeMillis();
        logLevel = level;
        this.origin = origin;
    }

    public LogEntry(String origin, LogLevel level, String message) {
        this(origin, level);
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEntryAsString() {
        return origin + " " + timeInMillis + " " + " " + message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public String getOrigin() {
        return origin;
    }
}
