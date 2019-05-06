package com.wayne.algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array like [2,7,3,8,4,3]
 *  find the first next bigger one and calculate the distance, like result [1,2,1,0,0]
 *
 * @author 212331901
 * @date 2019/5/6
 */
public class DistanceInArray {

    public static int[] getDistance(int[] array) {
        int[] result = new int[array.length];
        Deque<Integer> stack = new ArrayDeque<>(array.length);
        stack.push(0);
        for (int i = 1; i < array.length; i++) {
            if (array[stack.peek()] > array[i]) {

            }
        }
        return result;
    }
}
