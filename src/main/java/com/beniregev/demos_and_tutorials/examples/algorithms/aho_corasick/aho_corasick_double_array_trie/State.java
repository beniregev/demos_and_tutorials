package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.aho_corasick_double_array_trie;


import java.util.*;

/**
 *
 * @author binyamin.regev
 * @since JDK-1.6.0
 */
public class State {

    /**
     *
     */
    protected final int depth;

    /**
     * fail
     */
    private State failure = null;

    private Set<Integer> emits = null;

    private Map<Character, State> success = new TreeMap<Character, State>();

    private int index;

    /**
     *
     */
    public State() {
        this(0);
    }

    /**
     *
     * @param depth
     */
    public State(int depth) {
        this.depth = depth;
    }

    /**
     *
     * @return
     */
    public int getDepth() {
        return this.depth;
    }

    /**
     *
     * @param keyword
     */
    public void addEmit(int keyword) {
        if (this.emits == null) {
            this.emits = new TreeSet<Integer>(Collections.reverseOrder());
        }
        this.emits.add(keyword);
    }

    /**
     *
     * @return
     */
    public Integer getLargestValueId() {
        if (emits == null || emits.size() == 0) return null;

        return emits.iterator().next();
    }

    /**
     *
     * @param emits
     */
    public void addEmit(Collection<Integer> emits) {
        for (int emit : emits) {
            addEmit(emit);
        }
    }

    /**
     *
     * @return
     */
    public Collection<Integer> emit() {
        return this.emits == null ? Collections.<Integer>emptyList() : this.emits;
    }

    /**
     *
     * @return
     */
    public boolean isAcceptable() {
        return this.depth > 0 && this.emits != null;
    }

    /**
     *
     * @return
     */
    public State failure() {
        return this.failure;
    }

    /**
     *
     * @param failState
     */
    public void setFailure(State failState, int fail[]) {
        this.failure = failState;
        fail[index] = failState.index;
    }

    /**
     *
     * @param character
     * @param ignoreRootState
     * @return
     */
    private State nextState(Character character, boolean ignoreRootState) {
        State nextState = this.success.get(character);
        if (!ignoreRootState && nextState == null && this.depth == 0) {
            nextState = this;
        }
        return nextState;
    }

    /**
     *
     * @param character
     * @return
     */
    public State nextState(Character character) {
        return nextState(character, false);
    }

    /**
     *
     * @param character
     * @return
     */
    public State nextStateIgnoreRootState(Character character) {
        return nextState(character, true);
    }

    public State addState(Character character) {
        State nextState = nextStateIgnoreRootState(character);
        if (nextState == null) {
            nextState = new State(this.depth + 1);
            this.success.put(character, nextState);
        }
        return nextState;
    }

    public Collection<State> getStates() {
        return this.success.values();
    }

    public Collection<Character> getTransitions() {
        return this.success.keySet();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("State{");
        sb.append("depth=").append(depth);
        sb.append(", ID=").append(index);
        sb.append(", emits=").append(emits);
        sb.append(", success=").append(success.keySet());
        sb.append(", failureID=").append(failure == null ? "-1" : failure.index);
        sb.append(", failure=").append(failure);
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     * @return
     */
    public Map<Character, State> getSuccess() {
        return success;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}