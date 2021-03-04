package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 这种其实是不符合条件的，不过我们设定初始值 dp[0][0] = 1
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        // 返回所有可能的结果
        return dp[m-1][n-1];
    }

}
