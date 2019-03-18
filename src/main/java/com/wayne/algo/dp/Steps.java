package com.wayne.algo.dp;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 *
 * F(1) = 1;
 * F(2) = 2;
 * F(n) = F(n - 1) + F(n - 2);
 * @author 212331901
 * @date 2019/3/8
 */
public class Steps {

    public int total(int n) {

        int[] methods = new int[n+1];

        if (n <= 2) {
            return n;
        }

        methods[1] = 1; // only 1 step
        methods[2] = 2; // 1 step at a time, or 2 steps

        for (int i = 3; i <= n; i++) {
            methods[i] = methods[i-1] + methods[i-2];
        }

        return methods[n];
    }
}
