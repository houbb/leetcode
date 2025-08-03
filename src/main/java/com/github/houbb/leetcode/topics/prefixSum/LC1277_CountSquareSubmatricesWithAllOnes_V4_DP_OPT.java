package com.github.houbb.leetcode.topics.prefixSum;

public class LC1277_CountSquareSubmatricesWithAllOnes_V4_DP_OPT {


    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 只处理为1的场景
                if(matrix[i][j] == 1) {
                    // 初始化为0的情况，边界值
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]
                        ) + 1;
                    }
                }
            }
        }

        // 这里对缓存行更加友好
        int total = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                total += dp[i][j];
            }
        }

        return total;
    }

}
