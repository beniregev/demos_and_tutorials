package com.beniregev.demos_and_tutorials.examples.arrays;

/**
 * <div>
 *     <p>
 *         <div>
 *             Given two sorted arrays nums1 and nums2 of size m and n respectively,
 *             return the median of the two sorted arrays.
 *         </div>
 *         <div>
 *             The overall run time complexity should be O(log (m+n)).
 *         </div>
 *     </p>
 *     <ul><b>Constraints:</b>
 *         <li>nums1.length == m</li>
 *         <li>nums2.length == n</li>
 *         <li>0 <= m <= 1000</li>
 *         <li>0 <= n <= 1000</li>
 *         <li>1 <= m + n <= 2000</li>
 *         <li>-10^6 <= nums1[i], nums2[i] <= 10^6</li>
 *     </ul>
 * </div>
 */
public class MedianOfTwoSortedArrays {
    public static double solution(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;

        int[] nums = new int[n];

        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while(i1 < n1 && i2 < n2) {
            if(nums1[i1] <= nums2[i2])
                nums[i] = nums1[i1++];
            else
                nums[i] = nums2[i2++];
            i++;
        }

        while(i1 < n1)
            nums[i++] = nums1[i1++];
        while(i2 < n2)
            nums[i++] = nums2[i2++];

        double median;
        n--;
        if(n % 2 != 0)
            median = (double) (nums[n/2] + nums[(n/2) + 1])/2;
        else
            median = nums[n/2];
        return median;
    }

    public static void main(String[] args) {
        int[] n1 = {1,3};
        int[] n2 = {2};
        System.out.println(solution(n1, n2));
        int[] n3 = {1,2};
        int[] n4 = {3,4};
        System.out.println(solution(n3, n4));
    }
}
