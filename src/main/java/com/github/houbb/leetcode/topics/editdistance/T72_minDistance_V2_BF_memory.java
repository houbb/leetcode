package com.github.houbb.leetcode.topics.editdistance;

public class T72_minDistance_V2_BF_memory {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        Integer[][] memo = new Integer[m + 1][n + 1];
        return helper(word1, word2, m, n, memo);
    }

    private int helper(String word1, String word2, int i, int j, Integer[][] memo) {
        // 递归终止条件
        if (i == 0) return j;  // 将空字符串转换成 word2[0..j-1]
        if (j == 0) return i;  // 将 word1[0..i-1] 转换成空字符串

        // 如果已经计算过该子问题，直接返回结果
        if (memo[i][j] != null) return memo[i][j];

        // 计算当前子问题的解
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = helper(word1, word2, i - 1, j - 1, memo);  // 字符相等，不需要任何操作
        } else {
            // 否则，考虑三种操作
            int insert = helper(word1, word2, i, j - 1, memo);  // 插入
            int delete = helper(word1, word2, i - 1, j, memo);  // 删除
            int replace = helper(word1, word2, i - 1, j - 1, memo);  // 替换
            memo[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
        }

        return memo[i][j];
    }


}
