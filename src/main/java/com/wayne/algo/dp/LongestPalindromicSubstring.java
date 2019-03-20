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
    public static String palindromicNormal(String input) {
        if (input == null || input.isEmpty() || input.length() == 1) {
            return input;
        }
        int i = 1;
        String palindrom = input.substring(0, 1);
        while (i < input.length()) {
            /**
             * not "aa" or "aba"
             *       i       i
             */
            if (input.charAt(i) != input.charAt(i - 1) &&
                    (i < input.length() - 1 && input.charAt(i + 1) != input.charAt(i - 1))) {
                i++;
            } else {
                int cursor_left = i - 2;
                int cursor_right = (input.charAt(i) != input.charAt(i - 1)) ? i + 1 : i + 2;

                while (cursor_left >= 0 && cursor_right < input.length()) {
                    if (input.charAt(cursor_left--) != input.charAt(cursor_right++)) {
                        break;
                    }
                }
                if (cursor_right - cursor_left - 1 > palindrom.length()) {
                    palindrom = input.substring(cursor_left + 1, cursor_right);
                    System.out.println("new palindrom is: " + palindrom);
                }
                i = cursor_right;

            }
        }
        System.out.println("palindorm is : " + palindrom);
        return palindrom;
    }

    public static void main(String[] args) {
        String s = "foreeksskeegfor";
        palindromicNormal(null);

        palindromicNormal(s);
        palindromicNormal("abba");
        palindromicNormal("abb");
        palindromicNormal("sdbbcbbopi");
    }
}
