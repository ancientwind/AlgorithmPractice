package com.wayne.algo.strAndArray;

import java.util.*;

public class LongestNotRepeatSubString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkke";
//		System.out.println(LongestNotRepeatSubString.getLongest(test1));
//		System.out.println(LongestNotRepeatSubString.getLongestAscii128(test2));
//		System.out.println(LongestNotRepeatSubString.getLongestAscii128(test3));
        test(new String[]{test1, test2, test3});
    }

    public static void test(String[] strings) {
        for (String string : strings) {
            System.out.println("max sub length: " + getLongestOptimized(string));
        }
    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * For example, the longest substring without repeating letters for “abcabcbb” is “abc”, which the length is 3.
     * For “bbbbb” the longest substring is “b”, with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3.
     * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    /**
     * BASIC 1:
     *
     * use two index to mark the sliding window
     * @param string
     * @return
     */
    public static int slidingWindowIndex(String string) {
        if (string.isEmpty() || string == null) {
            return 0;
        }

        int max = 1;

        int subStart=0, subEnd = 0;
        for (int i = 1; i < string.length(); i++) {
            for (int j = subStart; j <= subEnd; j++) {
                if (string.charAt(i) == string.charAt(j)) {
                   subStart = j + 1;
                   subEnd = i;
                   break;
                }
                else if (j == subEnd){
                    subEnd++;
                    break;
                }
            }
            max = Math.max(max, subEnd - subStart + 1);
        }

        return max;
    }

    /**
     * Sliding Window
     *  O(n^2)
     */
    public static int getLongestNotRepeat(String str) {
        int length = 0;

        int start = 0;
        int cursor = 0;
        Set<Character> subSet = new HashSet<Character>();
        while (cursor < str.length()) {
            char ch = str.charAt(cursor++);
            Character cha = new Character(ch);
            if (!subSet.contains(cha)) {
                subSet.add(cha);
            } else {
                length = (subSet.size() > length) ? subSet.size() : length;
                start = str.indexOf(ch) + 1;
                for (int i = 0; i < start - 1; i++) {
                    subSet.remove(new Character(str.charAt(i)));
                }
            }
        }

        return length;
    }

    /**
     * Basic 2
     *
     * Sliding Window
     * O(n^2)
     *
     * @param str
     * @return
     */
    public static int getLongest(String str) {
        int length = 0;

        int start = 0; // the start index of non-repeated sub string
        int cursor = 0;
        HashSet<Character> subSet = new HashSet<Character>();
        while (start < str.length() && cursor < str.length()) {
            if (!subSet.contains(str.charAt(cursor))) {
                subSet.add(str.charAt(cursor++));
                length = Math.max(length, cursor - start);
            } else {
                subSet.remove(str.charAt(start++)); // remove characters beginning from start index, until the repeated char is removed
            }
        }

        return length;
    }

    /**
     *
     * Basic 3
     *
     * sliding window
     * O(n)
     * The reason is that if s[j] have a duplicate in the range [i, j) with index j',
     * we don't need to increase i little by little.
     * We can skip all the elements in the range [i, j'] and let i to be j' + 1 directly.
     *
     * @param str
     * @return
     */
    public static int getLongestOptimized(String str) {
        int n = str.length(), length = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j], which is the range of non-repeated sub string
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(str.charAt(j))) {
                i = Math.max(map.get(str.charAt(j)) + 1, i);
            }
            length = Math.max(length, j - i + 1);
            map.put(str.charAt(j), j);
        }

        return length;
    }

    /**
     * same as above. just use int array to replay map.
     *
     * @param str
     * @return
     */
    public static int getLongestAscii128(String str) {
        int n = str.length(), length = 0;
        int[] index = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(index[str.charAt(j)] + 1, i);
            length = Math.max(length, j - i + 1);
            index[str.charAt(j)] = j;
        }

        return length;
    }
}
