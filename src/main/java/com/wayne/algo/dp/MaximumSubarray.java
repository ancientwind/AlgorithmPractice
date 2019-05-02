package com.wayne.algo.dp;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 */
public class MaximumSubarray {

    /**
     *  sum[i] = max(sum[i-1] + a[i], a[i])
     */
    public static int maxSub(int[] array) {
        int m = array.length;
        if (m == 0) return  0;

        int max = 0;
        int[] sum = new int[array.length];
        sum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            sum[i] = Math.max(sum[i-1] + array[i] , array[i]);
            max = Math.max(sum[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSub(array));
    }
}
