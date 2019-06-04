package com.wayne.algo.strAndArray;

/**
 * move part of string to right
 * e.g. "abcdef" -> "defabc"
 */
public class MovePartOfString {

    /**
     * how to: separate input into tow parts, reverse each part, finally reverse the whole parts.
     * @param input
     * @param m - left m chars of input
     */
    public static void movePart(char[] input, int m) {
        reverse(input, 0, m -1);
        reverse(input, m, input.length - 1);
        reverse(input, 0, input.length - 1);
    }

    public static void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char temp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] input = "abcdefg".toCharArray();
        movePart(input, 3);
        System.out.println(input);
    }
}
