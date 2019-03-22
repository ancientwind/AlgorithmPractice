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
     * table[i+1][j-1] == 1 && input.charAt(i) == input.charAt(j)
     * <p>
     * result is table[0][length-1]
     *
     * @param input
     * @return
     */
    public static String palindromicDP(String input) {
        if (input.isEmpty() || input == null || input.length() == 1) {
            return input;
        }

        int palindrome[][] = new int[input.length()][input.length()];
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (i == j) {
                    palindrome[i][j] = 1;
                }
                if (true) {

                }
            }
        }

        String result = "";

        return result;
    }

    /**
     * forgeeksskeegfor
     * sb = sb append str[i] when str[i]!=sb.last
     * <p>
     * O(n^2)
     */

    public static String palindromeNormal(String input) {

        if (input == null || input.isEmpty()) {
            return "";
        }

        System.out.print(" input string is: " + input + " ");

        String palindorm = input.substring(0, 1);
        int i = 1;
        while (i < input.length()){

            int cursor_left = 0, cursor_right = input.length();
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

        System.out.println("palindorm is : " + palindorm);

        return palindorm;
    }

    public static void main(String[] args) {
        String s = "foreeksskeegfor";
        palindromeNormal(null);

        palindromeNormal(s);
        palindromeNormal("abba");
        palindromeNormal("abb");
        palindromeNormal("sdbbcbbopi");
    }
}
