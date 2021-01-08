package com.beniregev.demos_and_tutorials.rule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Binyamin Regev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface TestFixture {

    /**
     * The Name of member variable to Store in the FixtureRule.
     * be referenced in {@link @FixtureConfig} for invoking Mocking Functions with Parameters.
     * Note, member variables annotated with this, do Not Have to be mocks.
     *
     * @return -
     */
    String value();
}
