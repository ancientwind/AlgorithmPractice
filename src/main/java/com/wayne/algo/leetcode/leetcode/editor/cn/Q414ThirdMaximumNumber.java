//Given integer array nums, return the third maximum number in this array. If th
//e third maximum does not exist, return the maximum number. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,1]
//Output: 1
//Explanation: The third maximum is 1.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2]
//Output: 2
//Explanation: The third maximum does not exist, so the maximum (2) is returned 
//instead.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,2,3,1]
//Output: 1
//Explanation: Note that the third maximum here means the third maximum distinct
// number.
//Both numbers with value 2 are both considered as second maximum.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//Follow up: Can you find an O(n) solution? Related Topics 数组 
// 👍 229 👎 0


package com.wayne.algo.leetcode.leetcode.editor.cn;

public class Q414ThirdMaximumNumber {
    public static void main(String[] args) {
        int test[] = {3, 2, 1};
        int test1[] = {1, 2};
        int test2[] = {2, 2, 3, 1};
        int test3[] = {2, 2};
        int test4[] = {2, 2, 4, 27, 16, 9, 16, 27, 4, 2};
        int test5[] = {2, 1, Integer.MIN_VALUE};
        int test6[] = {2, 2, 1};
        int test7[] = {2};
        int test8[] = {2, Integer.MIN_VALUE, Integer.MIN_VALUE};
        Solution solution = new Q414ThirdMaximumNumber().new Solution();
        System.out.println(solution.thirdMax(test));  // 1
        System.out.println(solution.thirdMax(test1)); // 2
        System.out.println(solution.thirdMax(test2)); // 1
        System.out.println(solution.thirdMax(test3)); // 2
        System.out.println(solution.thirdMax(test5)); // Integer.MIN_VALUE
        System.out.println(solution.thirdMax(test6)); // 2
        System.out.println(solution.thirdMax(test7)); // 2
        System.out.println(solution.thirdMax(test8)); // 2
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            int result[] = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

            int numAddedCount = 0;
            boolean minValueCounted = false; // to deal with multiple minValue in nums
            for (int num : nums) {
                for (int j = 0; j < 3; j++) {
                    if (num == result[j]) {
                        if (num == Integer.MIN_VALUE && !minValueCounted) {
                            numAddedCount++;
                            minValueCounted = true;
                        }
                        break;
                    }
                    if (num > result[j]) {
                        for (int k = 2; k > j; k--) {
                            result[k] = result[k - 1];
                        }
                        result[j] = num;
                        numAddedCount++;
                        break;
                    }
                }
            }

            return (numAddedCount > 2) ? result[2] : result[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}