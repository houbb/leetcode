package com.github.houbb.leetcode.topics.editdistance;

public class T72_minDistance_V4_DP_memOpt {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 用两个一维数组代替二维数组
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        // 初始化第一行
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        // 填充动态规划表
        for (int i = 1; i <= m; i++) {
            curr[0] = i;  // 第i行的第0列，表示将word1[0..i-1]转换为空字符串，需要i次删除
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];  // 字符相等，无需操作
                } else {
                    curr[j] = Math.min(Math.min(prev[j], curr[j - 1]), prev[j - 1]) + 1;  // 三种操作的最小值
                }
            }
            // 更新prev和curr
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];  // 返回最后的结果
    }


}
