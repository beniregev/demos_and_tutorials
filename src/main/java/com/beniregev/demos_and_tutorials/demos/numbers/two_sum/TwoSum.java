package com.beniregev.demos_and_tutorials.demos.numbers.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    /**
     * <div>
     *     <p>
     *         Find two-sum in the naive approach, using 2 nested
     *         for loops and check if the sum of any 2 elements in
     *         the array is equal to the target given.
     *     </p>
     *     </p>
     *         <b>Time complexity:</b> O(n^2)
     *     </p>
     * </div>
     * @param numbers An unsorted array of numbers in which to find the two-sum
     * @param target An {@link Integer}, the target of the two-sum
     * @return An array with the 2 numbers making the two-sum.
     */
    public int[] findTwoSumBruteForce(int[] numbers, int target) {
        for (int i=0; i<numbers.length-1; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null; // no solution
    }

    /**
     * <div>
     *     <h2>Use a {@link Map} approach, most efficient method</h2>
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
     *     <p><b>Time Complexity:</b> O(N)</p>
     *     <p><b>Space Complexity:</b> O(1)</p>
     * </div>
     * @param numbers An unsorted array of numbers in which to find the two-sum
     * @param target An {@link Integer}, the target of the two-sum
     * @return An array with the 2 numbers making the two-sum.
     */
    public int[] findTwoSumWithMapMostEfficient(int[] numbers, int target) {
        Map<Integer, Integer> numbersToIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbersToIndex.containsKey(target - numbers[i])) {
                return new int[] {numbersToIndex.get(target - numbers[i]), i};
            }
            numbersToIndex.put(numbers[i], i);
        }
        return new int[] {};
    }

    /**
     * <div>
     *     <h2>Use Sorting along with the two-pointer approach</h2>
     *     <p>
     *         Another approach which works when you need to return
     *         the numbers instead of their indexes. Here is how it
     *         works:
     *      </p>
     *      <p>
     *          <ol>
     *              <li>Sort the array.</li>
     *              <li>
     *                  Initialize two variables, one pointing to
     *                  the beginning of the array (left) and another
     *                  pointing to the end of the array (right).
     *              </li>
     *              <li>Loop until left < right, and for each iteration.</li>
     *              <p>
     *                  <ul>
     *                      <li>{@code if arr[left] + arr[right] == target}, then return the indices.</li>
     *                      <li>{@code if arr[left] + arr[right] < target}, increment the left index.</li>
     *                      <li>else, decrement the right index.</li>
     *                  </ul>
     *              </p>
     *          </ol>
     *      </p>
     *      <p>
     *          This approach is called the two-pointer approach. It is
     *          a very common pattern for solving array related problems.
     *      </p>
     *      <p>
     *          <b>Time complexity:</b> O(n*log(n))
     *      </p>
     * </div>
     * @param numbers An unsorted array of numbers in which to find the two-sum
     * @param target An {@link Integer}, the target of the two-sum
     * @return An array with the 2 numbers making the two-sum.
     */
    public int[] findTwoSumSorting(int[] numbers, int target) {
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[] {numbers[left], numbers[right]};
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
}

/**
 * <div>
 *     <div>
 *         Given an array of integers nums and an integer target, return indices of the two numbers
 *         such that they add up to target.
 *     </div>
 *     <div>
 *         You may assume that each input would have exactly one solution, and you may not use the
 *         same element twice, but the same number can be in the array more than once.
 *     </div>
 *     <div>
 *         You can return the answer in any order.
 *     </div>
 *     <ul>
 *         <li>Array in not sorted.</li>
 *         <li>2 <= nums.length <= 10^4</li>
 *         <li>-10^9 <= nums[i] <= 10^9</li>
 *         <li>-10^9 <= target <= 10^9</li>
 *         <li>The same number can appear in the array several times.</li>
 *         <li><b>Only one valid answer exists.</b></li>
 *     </ul>
 * </div>
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Result = " + Arrays.toString(solution.findTwoSumWithMapMostEfficient(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Result = " + Arrays.toString(solution.findTwoSumWithMapMostEfficient(new int[]{3, 2, 4}, 6)));
        System.out.println("Result = " + Arrays.toString(solution.findTwoSumWithMapMostEfficient(new int[]{3, 3}, 6)));
        System.out.println("Result = " + Arrays.toString(solution.findTwoSumWithMapMostEfficient(new int[]{3, 2, 15, 7, 11, 15}, 9)));

        /*
          Get the array size, numbers and target number as an input from the user using Scanner.
          For example, to input the array [2, 7, 11, 15] and target 9 you will type (including space):
          4 2 7 11 15 9
          OR
          4 2 7 11 15
          9
          Where: 4 is the array size; [2, 7, 11, 15] are the array elements; 9 is the target.
         */
        Scanner keyboard = new Scanner(System.in);
        int arraySize = keyboard.nextInt();

        int[] nums = new int[arraySize];
        for(int i = 0; i < arraySize; i++) {
            nums[i] = keyboard.nextInt();
        }
        int target = keyboard.nextInt();
        keyboard.close();
        System.out.println("Result = " + Arrays.toString(solution.findTwoSumBruteForce(nums, target)));
        System.out.println("Result = " + Arrays.toString(solution.findTwoSumWithMapMostEfficient(nums, target)));
        System.out.println("Result = " + Arrays.toString(solution.findTwoSumSorting(nums, target)));
    }

}
