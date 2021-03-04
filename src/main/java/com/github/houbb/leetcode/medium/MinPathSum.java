package com.github.houbb.leetcode.medium;

/**
 * 最小路径
 * @author binbin.hou
 * @since 1.0.0
 */
public class MinPathSum {



    /**
     * 【优化思路】
     *
     * 但是这个性能确实一般？
     *
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 初始化
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m ;i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < n;i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // 循环处理
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // 通过状态转移方程
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }


    /**
     * 【优化思路】
     *
     * 但是这个性能确实一般？
     *
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i ==0 && j == 0) {
                   continue;
                }

                // 累加距离
                if(i == 0) {
                    // 第一行，只能从左边过来。
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                } else if(j == 0) {
                    // 第一列，只能从上面过来
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else {
                    // 通过状态转移方程
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }

        return grid[m-1][n-1];
    }


}
