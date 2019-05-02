package com.wayne.algo.dp;

import com.wayne.algo.basics.StringUtils;

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * Examples :
 * <p>
 * Input : X = "GeeksforGeeks", y = "GeeksQuiz"
 * Output : 5
 * The longest common substring is "Geeks" and is of
 * length 5.
 * <p>
 * Input : X = "abcdxyz", y = "xyzabcd"
 * Output : 4
 * The longest common substring is "abcd" and is of
 * length 4.
 * <p>
 * Input : X = "zxabcdezy", y = "yzabcdezx"
 * Output : 6
 * The longest common substring is "abcdez" and is of
 * length 6.
 *
 * @author 212331901
 * @date 2019/3/26
 */
public class LongestCommonSubstring {


    /**
     * using sliding window
     * abcdxyzm      xyzabcdn
     * i                j
     * i_X              j
     */
    private static int lcsWindow(String X, String Y) {
        if (X == null || Y == null || X.isEmpty() || Y.isEmpty()) {
            return 0;
        }

        int max = 0;

        int i = 0;
        while (i < X.length()) {
            int i_Y[] = StringUtils.allIndexOf(Y, X.charAt(i));

            if (i_Y.length != 0) {
                int inner_max = 0;
                int inner_i = i;
                for (int j : i_Y) {
                    int i_X = i;
                    while (j < Y.length() && i_X < X.length()) {
                        if (Y.charAt(j) != X.charAt(i_X)) {
                            break;
                        } else {
                            ++j;
                            ++i_X;
                        }
                    }
                    if (i_X - i > inner_max) {
                        inner_max = i_X - i;
                        inner_i = i_X;
                    }
                }

                if (inner_max > max) {
                    max = inner_max;
                }
                i = inner_i;

            } else {
                i++;
            }
        }

        return max;

    }

    /**
     * use dp
     * <p>
     * abcdxyzm      xyzabcdn
     */
    private static int lcsDP(String X, String Y) {
        if (X == null || Y == null || X.isEmpty() || Y.isEmpty()) {
            return 0;
        }

        /**
         * Note that LCSuff[i][j] contains length of longest common suffix of X[0..i-1] and Y[0..j-1].
         *    x y z a b c d n
         *
         * a  0 0 0 1 0 0 0 0
         * b  0 0 0 0 2
         * c           3
         * d             4
         * x  1
         * y    2
         * z      3
         * m
         */
        int suffix[][] = new int[X.length()+1][Y.length()+1];
        int max = 0;
//        for (int size = 1; size < X.length(); size++) {
//            for (int i = 0; i < X.length(); i++) {
//                int j = i + size - 1;
//                if (j < X.length() - 1) {
//                    suffix[i][j] = X.charAt(i) == Y.charAt(i) ? suffix[i][j-1] + 1 : 0;
//                }
//            }
//        }
        for (int i = 0; i <= X.length(); i++) {
            for (int j = 0; j <= Y.length(); j++) {
                if (i == 0 || j == 0) {
                    suffix[i][j] = 0;
                } else if (X.charAt(i-1) == Y.charAt(j-1)) {
                    suffix[i][j] = suffix[i-1][j-1] + 1;
                    if (suffix[i][j] > max) {
                        max = suffix[i][j];
                    }
                } else {
                    suffix[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String[][] tests = new String[][]{
                {"zxabcdezy", "yzabcdezx", "abcdez"},
                {"zxabcdezy", "yabzabcdezx", "abcdez"},
                {"abcdxyz", "xyzabcd", "abcd"},
                {"forGeeks", "GeeksQuiz", "Geeks"}
        };
        for (String[] test : tests) {
            System.out.println("expected: " + test[2] + " and actual: " + lcsDP(test[0], test[1]));
        }
    }
}
