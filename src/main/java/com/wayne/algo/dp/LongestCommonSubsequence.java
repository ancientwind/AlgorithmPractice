package com.wayne.algo.dp;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 *
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequence {

    /**
     *  A Naive recursive implementation of LCS problem in java*/
    public static int lcsRecr(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (X[m - 1] == Y[n - 1]) {
            return 1 + lcsRecr(X, Y, m -1, n-1);
        } else {
            return Math.max(lcsRecr(X, Y, m-1, n), lcsRecr(X, Y, m, n-1));
        }
    }

    /**
     *     G X T X A Y B
     *   0 0 0 0 0 0 0 0
     * A 0         1 1 1
     * G 0 1 1
     * G 0 1
     * T 0 1 1 2
     * A 0
     * B 0
     *
     * @param X
     * @param Y
     * @return
     */
    public static int lcsDP(char[] X, char[] Y){
        int sub[][] = new int[X.length+1][Y.length+1];
        for (int i = 0; i <= X.length; i++) {
            for (int j = 0; j <= Y.length; j++) {
                if (i == 0 || j == 0) {
                    sub[i][j] = 0;
                }
                else if (X[i-1] == Y[j-1]) {
                    sub[i][j] = sub[i-1][j-1] + 1;
                }
                else {
                    sub[i][j] = Math.max(sub[i-1][j], sub[i][j-1]);
                }
            }
        }

        return sub[X.length][Y.length];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB", s2 = "GXTXAYB";
        System.out.println(LongestCommonSubsequence.lcsRecr(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(LongestCommonSubsequence.lcsDP(s1.toCharArray(), s2.toCharArray()));
    }
}
