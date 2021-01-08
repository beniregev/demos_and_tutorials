package com.beniregev.demos_and_tutorials.rule;



import com.beniregev.demos_and_tutorials.exception.RestrictedLogLevel;
import com.beniregev.demos_and_tutorials.exception.RestrictedLogLevel.LogLevel;
import com.beniregev.demos_and_tutorials.util.Logger;
import org.apache.commons.logging.Log;
import org.junit.runner.Description;
import org.springframework.util.StringUtils;

import com.ibm.icu.impl.Assert;

/**
 * @author Binyamin Regev
 */
public class LogDocumenter implements TestDocumenter {

    private final Log log;

    /**
     * @param log
     */
    public LogDocumenter(final Log log) {
        super();
        this.log = log;
    }


    /* (non-Javadoc)
     * @see com.americanwell.caretalks.test.rule.TestDocumenter#reportStartNewTest(org.junit.runner.Description)
     */
    @Override
    public void reportStartNewTest(final Description description) {
        log("\n===============================\n");
        final String testName = String.format("%s(%s)", description.getMethodName(),
                description.getTestClass().getSimpleName());
        log("Starting Test {0}", testName);
        final TestDoc annotation = description.getAnnotation(TestDoc.class);
        if (annotation != null) {
            log("\tshould {0}", annotation.should());
            if (!StringUtils.isEmpty(annotation.expectedTo())) {
                log("\tand is expected to {0}", annotation.expectedTo());
            }
        }
    }

    /* (non-Javadoc)
     * @see com.americanwell.caretalks.test.rule.TestDocumenter#reportEndTest(org.junit.runner.Description)
     */
    @Override
    public void reportEndTest() {
        log("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
    }

    /* (non-Javadoc)
     * @see com.americanwell.caretalks.test.rule.TestDocumenter#log(java.lang.String)
     */
    @Override
    public void log(final String message, final Object... args) {
        Logger.info(log, message, args);
    }

    /* (non-Javadoc)
     * @see com.americanwell.caretalks.test.rule.TestDocumenter#log(java.lang.String)
     */
    @Override
    public void logError(final Throwable t, final String message, final Object... args) {
        Logger.info(log, t, message, args);
    }

    @Override
    public void log(final LogLevel level, final String message, final Object... args) {
        if (level == LogLevel.DEBUG) {
            Logger.debug(log, message, args);
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void reportError(final Exception t, final String message, final Object... args) {
        Logger.error(log, "There was an unexpected exception");
        Logger.error(log, t, message, args);
        Assert.fail(t);
    }
}
