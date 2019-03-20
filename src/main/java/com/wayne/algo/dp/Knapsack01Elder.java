package com.wayne.algo.dp;

/**
 * a knapsack has a total capacity V
 * n items, each has a capacity v and a weight w
 * <p>
 * problem: select n items to fill in the V, making most weight
 * <p>
 * solution: this is a np-complete problem
 * state transfer function:
 * let i means select 0 ~ i-th items, j means current capacity
 * k[i][j] = max { k[i-1][j-weight(i)] + weight(i), k[i-1][j] }
 * max { "select item i ", "not select item i"}
 *
 * @author 212331901
 * @date 2019/3/15
 */
public class Knapsack01Elder {

    private static int Capacity = 6;

    private static int[] volumes = {1,2,3,4};
    private static int[] weights = {2,3,4,5};

    private static int maxValue() {
        /**
         * knapsack[i][v] means select total i items and total volumes no greater than v
         * when i comes to n and v comes to Capacity, that's the final answer
         */
        int knapsack[][] = new int[volumes.length + 1][Capacity + 1];

        // from bottom up
        for (int i = 0; i <= volumes.length; i++) {
            for (int v = 0; v <= Capacity; v++) {

                if (i == 0 || v == 0) {
                    knapsack[i][v] = 0;
                }
                else if ( volumes[i-1] > v) {
                    knapsack[i][v] = knapsack[i - 1][v];
                } else {
                    int select_i = knapsack[i-1][v- volumes[i-1]] + weights[i-1];
                    int not_select_i = knapsack[i-1][v];
                    knapsack[i][v] = Math.max(select_i, not_select_i);
                }
            }
        }

        System.out.println("Max weight is " + knapsack[volumes.length][Capacity]);
        return knapsack[volumes.length][Capacity];
    }

    public static void main(String[] args) {
        System.out.println(maxValue());
    }
}
