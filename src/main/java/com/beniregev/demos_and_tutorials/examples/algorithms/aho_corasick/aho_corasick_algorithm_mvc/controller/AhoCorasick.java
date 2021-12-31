package com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.aho_corasick_algorithm_mvc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.aho_corasick_algorithm_mvc.model.Output;
import com.beniregev.demos_and_tutorials.examples.algorithms.aho_corasick.aho_corasick_algorithm_mvc.model.State;

public class AhoCorasick {
    State root = new State();
    State currState;
    int keywordInsertionCounter, lineNumberCounter, columnNumberCounter;
    String tempOutputStr = "";
    String reversedTempOutputStr = "";
    HashMap<String, Output> outputMap = new HashMap<>();
    long ahoCorasickTimeTotal=0;
    long ahoCorasickTimeFragment=0;
    long algoStart, algoEnd;

    public static ArrayList<Output> outputList = new ArrayList<>();

    /**
     * Move from 1 node of a trie to the others based on next input character
     */
    private State goTo(State node, String nextInputChar){
        return node.getNextStateCollection().get(nextInputChar);
    }

    /**
     * Prepare AhoCorasick goto function/ successful state of AhoCorasick trie
     */
    public void prepareGoToFunction(HashSet<String> keywords){
        for (String string : keywords) {
            enterKeyword(string);
        }
    }

    /**
     * insert keywords to trie
     */
    private void enterKeyword(String keyword){
        currState = root;
        keywordInsertionCounter = 0;

        while(keywordInsertionCounter<keyword.length() && goTo(currState, Character.toString(keyword.charAt(keywordInsertionCounter)))!=null){ //while state already exist then go there.
            currState = goTo(currState, Character.toString(keyword.charAt(keywordInsertionCounter)));
            keywordInsertionCounter++;
        }

        while(keywordInsertionCounter<keyword.length() && goTo(currState, Character.toString(keyword.charAt(keywordInsertionCounter)))==null){ //while state doesnt exist then create new node and go there
            currState.getNextStateCollection().put(Character.toString(keyword.charAt(keywordInsertionCounter)), new State(Character.toString(keyword.charAt(keywordInsertionCounter)), root));
            currState = goTo(currState, Character.toString(keyword.charAt(keywordInsertionCounter)));

            keywordInsertionCounter++;
        }

        if(keywordInsertionCounter==keyword.length()){
            currState.setFullKeyword(keyword);
        }
    }

    /**
     * Move from 1 node of a trie to it's fail node
     */
    private State failFrom(State node){
        tempOutputStr="";
        return node.getFailState();
    }

    /**
     * Create the fail fall back state of AhoCorasick trie
     */
    public void prepareFailFromFunction(){
        LinkedList<State> queue = new LinkedList<State>(); //a linked list is needed for BFS

        for (State state : root.getNextStateCollection().values()) {
            queue.add(state);
            state.setFailState(root);
        }

        State tempState;

        while(!queue.isEmpty()){
            tempState = queue.pop(); //pop node and get the childrens
            for (State state: tempState.getNextStateCollection().values()) { //implementation differ based on nextStateCollection data structure
                queue.add(state);
                currState=failFrom(tempState);
                while(goTo(currState, state.getStateContentCharacter())==null&&!currState.equals(root)){ //while fail
                    currState = failFrom(currState); //current state = failState
                }//exit while when found a match from goTo of a failState or when it reach root
                if(goTo(currState, state.getStateContentCharacter())!=null){
                    state.setFailState(goTo(currState, state.getStateContentCharacter()));
                }
            }
        }
    }

    /**
     * Match input string against constructed AhoCorasick trie
     */
    public void patternMatching(File inputFile){
        currState = root;
        lineNumberCounter=1;
        columnNumberCounter=1;
        int intBuf = 0;
        String sBuf = "";
        char cBuf;

        algoStart=System.nanoTime();
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((intBuf = bufferedReader.read()) != -1) {
                cBuf = (char)intBuf;
                sBuf = String.valueOf(cBuf);

                columnNumberCounter++;
                if(cBuf=='\n'){
                    lineNumberCounter++;
                    columnNumberCounter=1;
                }

                while (goTo(currState, sBuf)==null&&!currState.equals(root)) { //repeat fail function as long goTo function is failing
                    currState= failFrom(currState);
                }
                if(goTo(currState, sBuf)!=null){
                    currState = goTo(currState, sBuf); //set the current node to the result of go to function
                    prepareOutput(currState,lineNumberCounter, columnNumberCounter);
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        algoEnd = System.nanoTime();
        Utility.writeAhoCorasickTime(algoEnd-algoStart);
        //Utility.writeAhoCorasickTime(ahoCorasickTimeTotal);
    }

    /**
     * prepare output for the matching keywords found
     */
    private void prepareOutput(State state, int lineNumber, int endColumnNumber){
        if(state.getFullKeyword()!=null){//jika currNode = fullword
            outputList.add(new Output(state.getFullKeyword(), lineNumber, endColumnNumber-(state.getFullKeyword().length()), endColumnNumber-1));
        }

        while(!failFrom(state).equals(root)){//jika state tersebut punya fail node yang bukan root
            state = failFrom(state);
            if(state.getFullKeyword()!=null){//jika failState == fullword
                outputList.add(new Output(state.getFullKeyword(), lineNumber, endColumnNumber-(state.getFullKeyword().length()), endColumnNumber-1));
            }
        }
    }
}
