package com.wayne.algo.dp;

/**
 * @author 212331901
 * @date 2019/3/8
 */
public class Fibonacci {

    public static int recurFib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        else {
            return recurFib(n-1) + recurFib(n-2);
        }
    }

    public static int dbFib(int n) {
        int[] result = new int[n+1];

        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            result[i] = result[i-1] + result[i-2];
        }

        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.recurFib(7));
        System.out.println(Fibonacci.dbFib(7));
    }
}
