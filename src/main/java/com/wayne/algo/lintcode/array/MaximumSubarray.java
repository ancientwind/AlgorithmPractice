package com.wayne.algo.lintcode.array;

public class MaximumSubarray {

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     * 
     * Example
     * Given the array [−2,2,−3,4,−1,2,1,−5,3], 
     * the contiguous subarray [4,−1,2,1] has the largest sum = 6
     * 
     * 1. Greedy, time O(n*n), space O(1)
     */

    public int maxSubArray(int[] nums) {
    	
    	if(nums.length < 0 || nums == null)
    		return 0;
    	
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = sum > result? sum : result;
            }
        }
        
        return result;
    }
    
    /**
     * 
     * @param nums
     * @return
     * 
     * sum : sum of sub array; maxSum: current max sum.
     * if sum < 0, drop it because it will not make maxSum bigger
     * 
     * Greedy: time O(n), space O(1)
     */
    public int maxSubArray2(int[] nums){
    	
    	if(nums.length < 0 || nums == null)
    		return 0;
    	
    	int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int num:nums){
        	sum = Math.max(sum, 0); // drop if sum of subarray < 0
        	sum += num;
        	maxSum = Math.max(maxSum, sum);
        }
        
    	return maxSum;
    }
    
    /**
     * 
     * dynamic
     * 
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums){
    	return 0;
    }
}
