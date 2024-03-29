package com.beniregev.demos_and_tutorials.examples.algorithms_and_problems.aho_corasick.aho_corasick_simple_implementation;

import java.util.HashSet;
import java.util.Set;

class State<T> {
    // Arbitrarily chosen constant. If this state ends up getting
    // deeper than THRESHOLD_TO_USE_SPARSE, then we switch over to a
    // sparse edge representation. I did a few tests, and there's a
    // local minima here. We may want to choose a more sophisticated
    // strategy.
    private static final int THRESHOLD_TO_USE_SPARSE = 3;

    private int depth;
    private EdgeList<T> edgeList;
    private State<T> fail;
    private Set<T> outputs;

    public State(int depth) {
        this.depth = depth;
        if (depth > THRESHOLD_TO_USE_SPARSE)
            this.edgeList = new SparseEdgeList<T>();
        else
            this.edgeList = new DenseEdgeList<T>();
        this.fail = null;
        this.outputs = new HashSet<T>();
    }

    public State<T> extend(byte b) {
        if (this.edgeList.get(b) != null)
            return this.edgeList.get(b);
        State<T> nextState = new State<T>(this.depth + 1);
        this.edgeList.put(b, nextState);
        return nextState;
    }

    public State<T> extendAll(byte[] bytes) {
        State<T> state = this;
        for (int i = 0; i < bytes.length; i++) {
            if (state.edgeList.get(bytes[i]) != null)
                state = state.edgeList.get(bytes[i]);
            else
                state = state.extend(bytes[i]);
        }
        return state;
    }

    /**
     * Returns the size of the tree rooted at this State. Note: do not call this
     * if there are loops in the edgelist graph, such as those introduced by
     * AhoCorasick.prepare().
     */
    public int size() {
        byte[] keys = edgeList.keys();
        int result = 1;
        for (int i = 0; i < keys.length; i++)
            result += edgeList.get(keys[i]).size();
        return result;
    }

    public State<T> get(byte b) {
        return this.edgeList.get(b);
    }

    public void put(byte b, State<T> s) {
        this.edgeList.put(b, s);
    }

    public byte[] keys() {
        return this.edgeList.keys();
    }

    public State<T> getFail() {
        return this.fail;
    }

    public void setFail(State<T> f) {
        this.fail = f;
    }

    public void addOutput(T o) {
        this.outputs.add(o);
    }

    public Set<T> getOutputs() {
        return this.outputs;
    }
}
