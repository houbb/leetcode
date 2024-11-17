package com.github.houbb.leetcode.datastruct.queryopt;

public class T1906_minDifference_V4_prefixSum {


    public int[] minDifference(int[] nums, int[][] queries) {
        final int n = nums.length;

        // 初始化个数前缀和数组 1 <= nums[i] <= 100
        int[][] prefixSum = new int[n][101];
        for(int i = 0; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                prefixSum[i + 1][j] = prefixSum[i][j]; // 复制上一行的状态
            }

            prefixSum[i + 1][nums[i]]++; // 更新当前元素的计数
        }

        // 循环所有的 query
        int[] res = new int[queries.length];
        for(int qx = 0; qx < queries.length; qx++) {
            int left = queries[qx][0];
            int right = queries[qx][1];

            int minDiff = Integer.MAX_VALUE;    // 最大值
            int pre = 0;    // 上一次出现
            // 直接遍历 100 个数字在 [left, right] 出现的次数
            for(int i = 1; i <= 100; i++) {
                // 使用前缀和判断：count[r + 1][j] - count[l][j] 表示 j 在 [l, r] 区间中的出现次数
                if (prefixSum[right + 1][i] - prefixSum[left][i] > 0) {
                    // 如果 pre 已有记录，则更新最小差值。相邻的数肯定是最小的，且这里是有序地，当前数大于以前的数
                    if (pre != 0) {
                        minDiff = Math.min(minDiff, i - pre);
                    }

                    // 更新 pre 为当前值
                    pre = i;
                }
            }

            res[qx] = minDiff == Integer.MAX_VALUE ? -1 : minDiff;
        }

        return res;
    }

}
