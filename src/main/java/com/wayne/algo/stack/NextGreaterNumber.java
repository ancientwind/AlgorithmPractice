package com.wayne.algo.stack;

import com.wayne.algo.sort.DataUtils;

import java.util.Stack;

public class NextGreaterNumber {

    /**
     * Given an array like [2,7,3,4,8,4,3]
     * find the first next bigger number [7,8,4,8,-1,-1,-1]
     *
     * Solution: imagine each number as people with height of the number,
     *              find out the first higher people each one can see behind
     *
     *  use a stack to store the higher people
     *
     *  Time complexity: O(n)
     *
     *  如果是虚幻数组，可以扩展数组至两倍，即2*input.length -1, 取模即可获取某个数input[i%length]
     *
     * @param input
     * @return
     */
    public static int[] getNextGreaterNumber(final int[] input){
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {   // start from last
            while (!stack.empty() && stack.peek() <= input[i]) { // remove all not higher people
                stack.pop(); // remove the lower one
            }
            result[i] = stack.empty() ? -1 : stack.peek();
            stack.push(input[i]); // add for next round comparision
        }
        return result;
    }

    /**
     * input = [73, 74, 75, 71, 69, 72, 76, 73]，这个数组存放的是近几天的天气气温（华氏度）。
     * 你返回一个数组，计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0 。
     * output = [1, 1, 4, 2, 1, 1, 0, 0]
     * @param input
     * @return
     */
    public static int[] nextWarmerDay(final int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {   // start from last
            while (!stack.empty() && input[stack.peek()] <= input[i]) { // remove all not higher people
                stack.pop(); // remove the lower one
            }
            result[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i); // add for next round comparision
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {2,7,3,4,8,4,3};
        DataUtils.displayIntArray(test1, "input");
        DataUtils.displayIntArray(NextGreaterNumber.getNextGreaterNumber(test1), "output");

        int[] test2 = {73, 74, 75, 71, 69, 72, 76, 73};
        DataUtils.displayIntArray(test2, "input2");
        DataUtils.displayIntArray(NextGreaterNumber.nextWarmerDay(test2), "output2");
    }
}
