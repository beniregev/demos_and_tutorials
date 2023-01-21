package com.beniregev.demos_and_tutorials.demos.numbers.two_sum;

import java.util.Arrays;

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
        System.out.println("Result = " + Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Result = " + Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println("Result = " + Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
        System.out.println("Result = " + Arrays.toString(solution.twoSum(new int[]{3, 2, 15, 7, 11, 15}, 9)));

        int[] my = new int[20];
        for (int i = 0; i < 20; i++) {
            System.out.println(my[i]);
        }
    }
}
