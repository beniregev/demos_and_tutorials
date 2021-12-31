package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.aho_corasick_simple_implementation;

/**
 * Simple interface for mapping bytes to States.
 *
 * @author binyamin.regev
 * @since jdk-1.7.0
 */
interface EdgeList<T> {
    State<T> get(byte ch);

    void put(byte ch, State<T> state);

    byte[] keys();
}
