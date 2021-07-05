//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
// 
//
// Example 4: 
//
// 
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
// 
//
// Example 5: 
//
// 
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 4230 👎 0


package com.wayne.algo.leetcode.leetcode.editor.cn;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Q4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new Q4MedianOfTwoSortedArrays().new Solution();
        int[] n1 = {1, 2};
        int[] n2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(n1, n2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] total = new int[nums1.length + nums2.length];
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    total[i + j] = nums1[i++];
                } else {
                    total[i + j] = nums2[j++];
                }
            }
            if (i != nums1.length) {
                while (i < nums1.length) {
                    total[i + j] = nums1[i++];
                }
            }
            if (j != nums2.length) {
                while (j < nums2.length) {
                    total[i + j] = nums2[j++];
                }
            }

//            return total.length % 2 == 0 ?
//                    new BigDecimal((float)((total[total.length / 2 - 1] + total[total.length / 2])) / 2)
//                            .setScale(5, RoundingMode.HALF_UP).doubleValue()
//                    : total[total.length / 2];
            return total.length % 2 == 0 ?
                    (double)((total[total.length / 2 - 1] + total[total.length / 2])) / 2
                    : (double)total[total.length / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}