package com.beniregev.demos_and_tutorials.rule;

import com.beniregev.demos_and_tutorials.exception.RestrictedLogLevel.LogLevel;
import org.junit.runner.Description;


/**
 * @author AMERICANWELL\leon.kay
 */
public interface TestDocumenter {

    void reportStartNewTest(Description description);

    void reportEndTest();

    void log(String message, Object... args);

    /**
     * Log an Expected Error
     *
     * @param t
     * @param message
     * @param args
     */
    void logError(Throwable t, String message, Object... args);

    /**
     * Log at a specific level
     *
     * @param level
     * @param message
     * @param args
     */
    void log(LogLevel level, String message, Object... args);

    /**
     * Report a Test Failure
     *
     * @param t
     * @param message
     * @param args
     */
    void reportError(Exception t, String message, Object... args);
}
