package com.wayne.algo.dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to botto
 * m right which minimizes the sum of all numbers along its path.
 * Note
 * You can only move either down or right at any point in time.
 *
 * @author 212331901
 * @date 2019/3/25
 */
public class MinimumPathSum {

    /**
     * sum[i][j] = Min(sum[i-1][j], sum[i][j-1]) + v[i][j]
     *
     * @param grid
     * @return
     */
    public static int miniPS(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length , n = grid[0].length ;
        int sum[][] = new int[m][n];

        sum[0][0] = grid[0][0];

        // top row
        for (int i = 1; i <= n - 1; i++) {
            sum[0][i] = grid[0][i] + sum[0][i-1];
        }

        // left column
        for (int i = 1; i <= m - 1; i++) {
            sum[i][0] = grid[i][0] + sum[i-1][0];
        }

        // others
        for (int i = 1; i <= m - 1 ; i++) {
            for (int j = 1; j <= n - 1 ; j++) {
                sum[i][j] = grid[i][j] + Math.min(sum[i-1][j], sum[i][j-1]);
            }
        }

        return sum[m-1][n-1];
    }

    public static int dfs(int[][] grid, int m, int n) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        if (m == grid.length - 1 && n == grid[0].length - 1) {
            return grid[m][n];
        }

        if (m < grid.length - 1 && n < grid[0].length - 1) {
            int r1 = grid[m][n] + dfs(grid, m+1,n);
            int r2 = grid[m][n] + dfs(grid, m , n + 1);
            return Math.min(r1, r2);
        }

        // walked to right column
        if (m < grid.length - 1) {
            return grid[m][n] + dfs(grid, m + 1, n);
        }

        // walked to down row
        if (n < grid[0].length - 1) {
            return grid[m][n] + dfs(grid, m, n+1);
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 5, 2, 1},
                {8, 1, 7, 1},
                {6, 3, 4, 1},
                {5, 3, 6, 6}
        };
        int topDown = 2 + 5 + 1 + 3 + 3 + 6 + 6;
        int bottomUp = 6 + 1 + 1 + 1 + 2 + 5 + 2;

        System.out.println("topDown is : " + topDown + " and bottomUp is: " + bottomUp);
        System.out.println("dfs is : " + dfs(grid, 0, 0));
        System.out.println("miniPS is : " + miniPS(grid));
    }
}
