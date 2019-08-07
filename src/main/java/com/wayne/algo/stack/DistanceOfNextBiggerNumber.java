package com.wayne.algo.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Given an array like [2,7,3,4,8,4,3]
 * find the first next bigger one and calculate the distance, like result [1,3,1,1,0,0,0]
 *
 * @author 212331901
 * @date 2019/5/6
 */
public class DistanceOfNextBiggerNumber {

    /**
     * solution: use a stack to store index of number which has not found the next bigger number; pop it when found
     *
     * O(2n)
     * @param array
     * @return
     */
    public static int[] getDistance(int[] array) {
        int[] result = new int[array.length];
//        Stack<Integer> stack = new Stack(); // Stack extends Vector, which could break LIFO rule; use Deque instead
        Deque<Integer> stack = new ArrayDeque<>(array.length);
        stack.push(0); // push the index of next smaller element to stack
        for (int i = 1; i < array.length; i++) {
            while (!stack.isEmpty()){
                int elem = stack.peek();
                if (array[i] > array[elem]) {
                    result[elem] = i - elem;
                    stack.pop(); // means top element already finds its next bigger number, so remove it from the stack
                } else {
                    break;
                }
            }
            stack.push(i);
        }

//        while (!stack.isEmpty()) {
//            result[stack.pop()] = 0;
//        }
        for (int i : stack) {
            result[i] = 0;
        }

        return result;
    }

    /**
     * suppose array represents a histogram, get the largest continues area horizontally
     * for example: [4,2,1,3,3] in below diagram, the largest area is 6
     * __
     * |  |      ____
     * |  |__   |    |
     * |     |__|    |
     * |_____________|
     * 4  2  1  3  3
     *
     * @param array
     * @return
     */
    public static int getLargestArea(int[] array) {
        /**
         * solution: find first smaller number to each number on both left and right, then calculate the area
         */
        int[] left = new int[array.length]; // -> [-1,-2,-3,-1,-2]
        int[] right = new int[array.length]; // -> [1,1,3,2,1]
        int[] area = new int[array.length]; // area = (right - left - 1) * elem
        Deque<Integer> leftStack = new ArrayDeque<>(array.length);
        Deque<Integer> rightStack = new ArrayDeque<>(array.length);

        leftStack.push(0);
        for (int i = 0; i < array.length; i++) {
            while (!leftStack.isEmpty()) {
                int elem = leftStack.peek();
                if (array[i] < array[elem]) {
                    leftStack.pop();
                    left[elem] = i;
                }
            }
        }

        return 0;
    }

    /**
     * this method only calculate area on right direction
     * @param array
     * @return
     */
    public static int calculateLargestArea(int[] array) {
        int largest = 0;
        Deque<Integer> stack = new ArrayDeque<>(array.length);
        stack.push(0);
        for (int i = 1; i < array.length; i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (array[i] < array[top]) {
                    int area = (i - top) * array[top];
                    largest = area > largest ? area : largest;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = (array.length - top) * array[top];
            largest = area > largest ? area : largest;
        }

        return largest;
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 3, 4, 8, 2, 3, 1};
//        System.out.println(Arrays.toString(getDistance(test)));

        int[] test2 = {4,2,1,3,2};
        System.out.println(calculateLargestArea(test2));
    }
}
