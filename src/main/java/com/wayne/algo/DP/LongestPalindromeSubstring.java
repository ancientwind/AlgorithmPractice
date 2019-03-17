package com.wayne.algo.DP;

/**
 * Get the longest palindrome substring.
 *
 * Palindrome is a word that reads the same backward as forward,
 *
 * e.g. "abcba", "abba", "abccba"
 *
 * i=0
 *   a b c b a
 *     j=2
 */

public class LongestPalindromeSubstring {

    /**
     * 分裂法：
     *  遍历每个CHAR，以此往两边判断字符是否相同，或连续相同的两字符往两边判断
     * @param input
     * @return
     */
    public String getLongestPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String result = "";
        int max = 1;
        for (int i = 0; i < input.length(); i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < input.length()) {
                if (input.charAt(left) == input.charAt(right)){
                   if (right - left + 1 > max) {
                       max = right - left + 1;
                       result = input.substring(left, right+1);
                       left--;
                       right++;
                   }
                }
            }
        }

        return result;
    }

    public String parseByDP(String input) {

    }

    public static void main(String[] args) {
        String[] inputs = {"wsdabcsgw","abccbs"};
    }
}
