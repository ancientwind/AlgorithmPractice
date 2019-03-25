package com.wayne.algo.dp;

/**
 * As another example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
 * “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 */
public class LonestPalindromicSubsequence {

    /**
     * // Every single character is a palindrome of length 1
     * L(i, i) = 1 for all indexes i in given sequence
     * <p>
     * // IF first and last characters are not same
     * If (X[i] != X[j])  L(i, j) =  max{L(i + 1, j),L(i, j - 1)}
     * <p>
     * // If there are only 2 characters and both are same
     * Else if (j == i + 1) L(i, j) = 2
     * <p>
     * // If there are more than two characters, and first and last
     * // characters are same
     * Else L(i, j) =  L(i + 1, j - 1) + 2
     */

    public static int lps(String input) {

        if (input == null || input.isEmpty()) return 0;

        int L[][] = new int[input.length()][input.length()];

        for (int i = 0; i < input.length(); i++) {
            L[i][i] = 1;
        }

        for (int subSize = 2; subSize <= input.length(); subSize++) {

            for (int i = 0; i < input.length() - subSize + 1; i++) {
                int j = i + subSize - 1;
                if (input.charAt(i) == input.charAt(j)) {
                    if (i == j - 1) L[i][j] = 2;
                    else L[i][j] = L[i + 1][j - 1] + 2;
                } else
                    L[i][j] = Math.max(L[i + 1][j], L[i][j - 1]);
            }
        }

        return L[0][input.length() - 1];
    }

    public static void main(String[] args) {
        String[] inputs = new String[]{null, "abccba", "xabcbasd", "BBABCBCAB"};
        for (String input : inputs) {
            System.out.print(" input string is: " + input + " ");
            System.out.println("max is : " + lps(input));
        }
    }
}
