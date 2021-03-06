package com.beniregev.demos_and_tutorials.rule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Binyamin Regev
 * An annotation for setting notes on a unit test.
 * Can be used later for documentation generation of use cases
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TestDoc {
    /**
     * The description of what the unit test should be testing
     *
     * @return
     */
    String should();

    /**
     * A description of the expectation of the test
     *
     * @return
     */
    String expectedTo() default "";

    /**
     * A test case ID for reference by QA.
     *
     * @return
     */
    String testCaseId() default "";
}
