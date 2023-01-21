package com.beniregev.demos_and_tutorials.demos.numbers.two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * <div>
     *     <p>
     *        <div>Using {@code Map} to save the need to use a nested loop and time complexity of O(N^2).</div>
     *        <div>
     *            <div>
     *                The idea is that the {@code Map} is used as kind of memory of previous numbers, and for
     *                each number[i] to check if {@code target-number[i]} exists in the map, meaning it exists
     *                in the {@code Array} and was already processed.
     *            </div>
     *            <div>If {@code target - number[i]} exists then the solution was found, and returning it.</div>
     *            <div>If {@code target - number[i]} doesn't exist then add {@code number[i]} to the {@code Map}.</div>
     *            <div>If the loop finishes and no solution was found then return an empty array of integers ({@code int[]}).</div>
     *         </div>
     *     </p>
     *     <div>Time Complexity: O(N)</div>
     *     <div>Space Complexity: O(1)</div>
     * * </div>
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numbersToIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbersToIndex.containsKey(target - numbers[i])) {

                return new int[] {numbersToIndex.get(target - numbers[i]), i};
            }
            numbersToIndex.put(numbers[i], i);
        }
        return new int[] {};
    }
}
