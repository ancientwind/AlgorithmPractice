package com.wayne.algo.leetcode;

import com.wayne.algo.sort.DataUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口最大值。
     */
    public int[] getMaximum(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MonotonicQueue queue = new MonotonicQueue();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                result[i - k + 1] = queue.max();
                queue.pop(nums[i - k + 1]);
            }
        }

        return result;
    }

    /**
     * use monotonic queue to make operation O(k)
     */
    class MonotonicQueue {
        private Deque<Integer> deque = new ArrayDeque<>();

        /**
         * put num to deque from back, and remove any elem less thant num
         * this will make the deque 单调递减
         *
         * @param num
         */
        public void push(int num) {
            while (!deque.isEmpty() && deque.getLast() < num) {
                deque.removeLast();
            }
            deque.addLast(num);
        }

        public int max() {
            return deque.getFirst();
        }

        public void pop(int num) {
            if (deque.getFirst() == num) {
                deque.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] test1 = DataUtils.generateIntArray(7, 9);
        DataUtils.displayIntArray(test1, "input1:");
        DataUtils.displayIntArray(swm.getMaximum(test1, 3), "output1:");
    }
}
