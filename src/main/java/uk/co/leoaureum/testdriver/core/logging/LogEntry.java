package uk.co.leoaureum.testdriver.core.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Copyright (C) James Oram 2014-2025
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

    public String getFormattedTime() {
        Date date = new Date(timeInMillis);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
         return "UTC " + formatter.format(date);
    }

    public String getOrigin() {
        return origin;
    }

    public String getFilename() {
        return getOrigin() + ".jpg";
    }
}
