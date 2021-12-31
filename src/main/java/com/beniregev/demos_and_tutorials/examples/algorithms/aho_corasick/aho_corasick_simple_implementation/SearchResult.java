package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.aho_corasick_simple_implementation;

import java.util.Set;

public class SearchResult<T> {
    State<T> lastMatchedState;
    byte[] bytes;
    int lastIndex;

    SearchResult(State<T> s, byte[] bs, int i) {
        this.lastMatchedState = s;
        this.bytes = bs;
        this.lastIndex = i;
    }

    /**
     * Returns a list of the outputs of this match.
     */
    public Set<T> getOutputs() {
        return lastMatchedState.getOutputs();
    }

    /**
     * Returns the index where the search terminates. Note that this is one byte
     * after the last matching character.
     */
    public int getLastIndex() {
        return lastIndex;
    }
}
