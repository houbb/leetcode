package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n+1];

        // 初始化
        dp[0] = 1;
        dp[1] = 1;

        // 遍历
        for(int i = 2; i <= n; i++) {
            int sum = 0;
            for(int j = 0; j < i; j++) {
                // 左边 * 右边
                sum += dp[j] * dp[i-1-j];
            }

            dp[i] =sum ;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees trees = new UniqueBinarySearchTrees();

        System.out.println(trees.numTrees(3));
    }

}
