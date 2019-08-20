package com.wayne.algo.search;

import com.wayne.algo.sort.DataUtils;

/**
 * Problem:
 * N ropes length of L, cut to K sub ropes, what is the longest length of the sub rope could it be?
 */
public class LongestSubRope {

    public static void main(String[] args) {
        int N = 4;
        double[] L = {8.02,7.43,4.57,5.39};
        int K = 11;
        System.out.println("sum is " + DataUtils.sum(L));
        System.out.println(getSubRope(N, L, K));
    }

    /**
     *
     * current_count = sum(Li/x)
     *
     * @param N
     * @param L
     * @param K
     * @return
     */
    public static double getSubRope(int N, double[] L, int K) {
        double min = 0.01, max = DataUtils.sum(L) / K + 0.01;
        System.out.println("max possible: " + max);
        int maxTries = 20;

        int i = 0;
        while (i <= maxTries && min < max) {
            maxTries--;
            double mid = (min + (max - min) / 2);
            int count = currentCount(L, mid);
            System.out.println("min: " + min + " mid: " + mid + " max: " + max + " | count: " + count);
            if (count >= K ) {
                min = mid;
            }
            else {
                max = mid;
            }
//            else if (count < K) {
//                max = mid;
//            }
//            else {
//                System.out.println("run times: " + times);
//                return mid;
//            }
        }

        return min;
    }

    private static int currentCount(double[] L, double mid) {
        int count = 0;
        for (double d : L) {
            count += d / mid;
        }
        return count;
    }

}
