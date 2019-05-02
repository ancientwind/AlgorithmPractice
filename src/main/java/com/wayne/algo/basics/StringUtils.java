package com.wayne.algo.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 212331901
 * @date 2019/3/26
 */
public class StringUtils {

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static int[] allIndexOf(String string, char ch) {
        List<Integer> indexs = new ArrayList<>();
        AtomicInteger index = new AtomicInteger();
        string.chars().forEach(c -> {
            if (c == ch) {
                indexs.add(index.get());
            }
            index.getAndIncrement();
        });
        return indexs.stream().mapToInt( i -> i).toArray();
    }

    public static int[] allIndex(String string, char ch) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ch) {
                indexes.add(i);
            }
        }

        return indexes.stream().mapToInt( i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] x = StringUtils.allIndex("helloe", 'e');
        System.out.println(x.length);
    }
}
