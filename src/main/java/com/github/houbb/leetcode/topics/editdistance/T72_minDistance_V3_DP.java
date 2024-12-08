package com.github.houbb.leetcode.topics.editdistance;

public class T72_minDistance_V3_DP {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 创建dp数组，dp[i][j]表示word1[0..i-1]转换为word2[0..j-1]的最小操作数
        int[][] dp = new int[m + 1][n + 1];

        // 初始化第一列和第一行
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // 从word1[0..i-1]变为空字符串需要i次删除
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // 从空字符串变成word2[0..j-1]需要j次插入
        }

        // 填充dp表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // 如果字符相等，不需要任何操作
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    // 三种操作：删除、插入、替换
                }
            }
        }

        // 最终结果是将word1完全转为word2
        return dp[m][n];
    }


}
