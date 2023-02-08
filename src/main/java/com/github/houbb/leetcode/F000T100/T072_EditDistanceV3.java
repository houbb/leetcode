package com.github.houbb.leetcode.F000T100;

public class T072_EditDistanceV3 {

    /**
     * 引入 mem[][] 提升性能
     *
     * @param word1 原始单词
     * @param word2 目标单词
     */
    public int minDistance(String word1, String word2) {
        // 初始化 dp
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for(int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        // 遍历
        for(int i = 0; i < word1.length(); i++) {
            for(int j = 0; j < word2.length(); j++) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = min(dp[i+1][j], dp[i][j+1], dp[i][j]) + 1;
                }
            }
        }

        // 结果
        return dp[word1.length()][word2.length()];
    }

    /**
     * 返回最小的数字
     * @param nums 数字
     * @return 结果
     */
    private static int min(int ... nums) {
        int min = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

}
