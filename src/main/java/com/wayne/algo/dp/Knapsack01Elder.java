package com.wayne.algo.dp;

import java.util.stream.IntStream;

/**
 * a knapsack has a total capacity V
 * n items, each has a capacity v and a weight w
 *
 * problem: select n items to fill in the V, making most weight
 *
 * solution: this is a np-complete problem
 * state transfer function:
 * let i means select 0 ~ i-th items, j means current capacity
 * k[i][j] = max { k[i-1][j-weight(i)] + weight(i), k[i-1][j] }
 *           max { "select item i ", "not select item i"}
 * @author 212331901
 * @date 2019/3/15
 */
public class Knapsack01Elder {

    private static int Capacity = 10;

    private static int items[][] = {{1,2}, {2, 3}, {3, 2}, {2, 4}, {3, 5}, {2,1}};

    private static int[][] pack() {
        int knapsack[][] = new int[items.length][Capacity+1];

        knapsack[0][0] = 0;
        for (int v = Capacity; v > 0 ; v--) {
            for (int i = 1; i < items.length; i++) {
                knapsack[i][v] = Math.max(knapsack[i-1][Capacity - items[i][1]] + items[i][1],
                        knapsack[i-1][v]);
            }
        }

        System.out.println("Max weight is " + knapsack[items.length - 1][Capacity]);
        return knapsack;
    }

    public static void main(String[] args) {
        System.out.println(pack());
    }
}
