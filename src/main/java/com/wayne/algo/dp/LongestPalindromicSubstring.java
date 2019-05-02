package com.wayne.algo.dp;

/**
 * Given a string, find the longest substring which is palindrome.
 * For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 *
 * @author 212331901
 * @date 2019/3/20
 */
public class LongestPalindromicSubstring {

    /**
     * new table[i][j] means input[i,j] is palindrome
     *
     *  if i==j, true
     *  table[i][j] is palindrome based on input.charAt(i) == input.charAt(j) && table[i+1][j-1] == true
     *
     *
     *
     * @param input
     * @return
     */
    public static String palindromicDP(String input) {
        if (isEmptyString(input)) {
            return "";
        }

        String result = "";

        boolean palindrome[][] = new boolean[input.length()][input.length()];

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (i == j) {
                    palindrome[i][j] = true;
                }
                else if (i > j) {
                    palindrome[i][j] = false;
                }
                else {
                    palindrome[i][j] =  palindrome[i+1][j-1] && input.charAt(i) == input.charAt(j);
                }

                if (palindrome[i][j] && (j - i + 1 > result.length()) ) {
                    result = (j == input.length() -1) ? input.substring(i) : input.substring(i, j+1);
                }
            }
        }


        return result;
    }

    /**
     * forgeeksskeegfor
     * sb = sb append str[i] when str[i]!=sb.last
     * <p>
     * O(n^2)
     */

    public static String palindromeNormal(String input) {

        if (isEmptyString(input)) {
            return "";
        }

        String palindorm = input.substring(0, 1);
        int i = 1;
        while (i < input.length()){

            int cursor_left, cursor_right;
            // case abba
            if (input.charAt(i) == input.charAt(i - 1)) {
                 cursor_left = i - 2;
                 cursor_right = i + 1;
            }
            // case abcba
            else if (i < input.length() - 1 && input.charAt(i + 1) == input.charAt(i - 1)) {
                 cursor_left = i - 2;
                 cursor_right = i + 2;
            } else {
                ++i;
                continue;
            }

            // expand towards two side
            while (cursor_left >= 0 && cursor_right < input.length()) {
                if (input.charAt(cursor_left) == input.charAt(cursor_right)) {
                    --cursor_left;
                    ++cursor_right;
                } else {
                    break;
                }
            }

            if (cursor_right - cursor_left -1 > palindorm.length()) {
                if ( cursor_right == input.length() ){
                    palindorm = input.substring(cursor_left+1);
                } else {
                    palindorm = input.substring(cursor_left + 1, cursor_right);
                }
            }

            i = cursor_right;
        }

        return palindorm;
    }

    private static boolean isEmptyString(String input) {
        return input == null || input.isEmpty();
    }


    public static void main(String[] args) {

        String[] tests = {null, "foreeksskeegfor", "abba", "aab", "abb", "xabba"};
        for (String input : tests) {
            System.out.print(" input string is: " + input + " ");
            System.out.println("palindrom is : " +  palindromicDP(input));
        }

    }
}
