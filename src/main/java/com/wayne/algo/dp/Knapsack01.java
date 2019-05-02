package com.wayne.algo.dp;

/**
 * Given weights and values of n items,
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 */
public class Knapsack01 {

    /**
     * solution: dp state transfer function:
     *  opt[i][j] = max {
     *              opt[i-1][j], // item i not in the optimal subset
     *              opt[i-1][j-w(i)] + v(i) // item i in the optimal subset
     *              }
     * @return
     */

    public static int maxByRecur(int W, int[] weights, int[] values, int n){
        if (W == 0 || n == 0) {
            return 0;
        }

        if (weights[n - 1] > W) {
            return maxByRecur(W, weights, values, n-1);
        }

        return Math.max(
                maxByRecur(W, weights, values, n-1),
                maxByRecur(W - weights[n-1], weights, values, n-1) + values[n-1]
        );

    }


    public static int maxByDP(int W, int[] weights, int[] values, int n) {

        int result[][] = new int[n+1][W+1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    result[i][w] = 0;
                }
                else if (weights[i-1] <= w) {
                    result[i][w] = Math.max(result[i-1][w], result[i-1][w-weights[i]] + values[i]);
                }
                else {
                    result[i][w] = result[i-1][w];
                }
            }
        }

        return result[n][W];
    }

    public static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {
        int weights[] = new int[] { 10, 20, 25, 30 };
        int values[] = new int[] { 60, 100, 130, 120 };
        int W = 50;
        int N = values.length;

        System.out.println(Knapsack01.maxByRecur(50, weights, values, N));
        System.out.println(Knapsack01.knapSack(50, weights, values, N));
    }
}
