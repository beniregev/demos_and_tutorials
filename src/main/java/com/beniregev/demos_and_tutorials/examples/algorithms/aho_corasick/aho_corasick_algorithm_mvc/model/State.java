package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.aho_corasick_algorithm_mvc.model;

import java.util.HashMap;

public class State {
    String stateContentCharacter;
    String fullKeyword;
    State failState;
    HashMap<String, State> nextStateCollection;

    /**Called when root is created.*/
    public State(){
        super();
        this.stateContentCharacter = null;
        this.failState = null;
        this.fullKeyword = null;
        this.nextStateCollection = new HashMap<>();
    }

    /**Called each time a new state is created*/
    public State(String stateContentCharacter, State failState){
        super();
        this.stateContentCharacter = stateContentCharacter;
        this.failState = failState;
        this.fullKeyword = null;
        this.nextStateCollection = new HashMap<>();
    }

    public String getStateContentCharacter() {
        return stateContentCharacter;
    }

    public void setStateContentCharacter(String stateContentCharacter) {
        this.stateContentCharacter = stateContentCharacter;
    }

    public String getFullKeyword() {
        return fullKeyword;
    }

    public void setFullKeyword(String fullKeyword) {
        this.fullKeyword = fullKeyword;
    }

    public State getFailState() {
        return failState;
    }

    public void setFailState(State failState) {
        this.failState = failState;
    }

    public HashMap<String, State> getNextStateCollection() {
        return nextStateCollection;
    }

    public void setNextStateCollection(HashMap<String, State> nextStateCollection) {
        this.nextStateCollection = nextStateCollection;
    }
}
