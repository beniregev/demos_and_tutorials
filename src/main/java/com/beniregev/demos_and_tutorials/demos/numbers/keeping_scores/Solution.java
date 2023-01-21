package com.beniregev.demos_and_tutorials.demos.numbers.keeping_scores;

import java.util.ArrayList;
import java.util.List;

/**
 * You are keeping score of a game with strange scoring rules. The game consists of several rounds, where the score
 * of past rounds may affect future rounds' score.
 * <div>
 * * <ul>
 *      <li>At the beginning of the game we start with an empty record. </li>
 *      <li>
 *          You are given a list of Strings {@code ops}, where {@code ops[i]} is the
 *          {@code ith} operation you must apply to the record and is one of the following:
 *      </li>
 *      <li>An integer {@code x} - record a new score of {@code x}.</li>>
 *      <li>
 *          "+" - Record a new score that is the sum of the previous two scores. It's guaranteed there will always
 *          be two previous scores.
 *      </li>>
 *      <li>
 *          "D" - Record a new score that is double the previous score. It's guaranteed there will always be a
 *          previous score.
 *      </li>
 *      <li>
*           "C" - Invalidate the previous score, remove it from the record. It's guaranteed there will always be a
 *          previous score.
 *      </li>
 * </ul>
 * </div>
 * <div>Return the summary of all the scores on the record.</div>
 *
 */
public class Solution {
    /**
     * @param ops - List of operations.
     * @return int - Sum of scores after performing all operations.
     */
    public static int calPoints(String[] ops) {
        int result = Integer.MIN_VALUE;

        //  region Your code here
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int temp = scores.get(scores.size()-1) + scores.get(scores.size()-2);
                scores.add(temp);
            } else if (ops[i].equals("D")) {
                int temp = scores.get(scores.size()-1) * 2;
                scores.add(temp);
            } else if (ops[i].equals("C")) {
                scores.remove(scores.size()-1);
            } else {
                scores.add(Integer.parseInt(ops[i]));
            }
        }
        result = 0;
        for (Integer score : scores) {
            result += score;
        }
        //  endregion Your code here

        return result;

    }
}
