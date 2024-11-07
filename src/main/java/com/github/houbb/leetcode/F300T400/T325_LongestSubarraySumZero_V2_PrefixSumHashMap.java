package com.github.houbb.leetcode.F300T400;

import java.util.HashMap;

public class T325_LongestSubarraySumZero_V2_PrefixSumHashMap {

    public static int longestSubarrayWithSumZero(int[] nums) {
        int n = nums.length;

        // 计算前缀和数组
        int[] prefixSums = new int[n + 1];  // prefixSums[i]表示nums[0...i-1]的和

        // 填充前缀和数组
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        // 用哈希表记录前缀和第一次出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // 特殊情况，前缀和为0时从开头开始

        int maxLength = 0;

        // 遍历前缀和数组
        for (int i = 0; i <= n; i++) {
            // 如果前缀和出现过，说明子数组和为0
            if (map.containsKey(prefixSums[i])) {
                // 计算当前子数组的长度
                int length = i - map.get(prefixSums[i]);
                // 更新最大长度
                maxLength = Math.max(maxLength, length);
            } else {
                // 如果前缀和没有出现过，记录它的位置
                map.put(prefixSums[i], i);
            }
        }

        return maxLength;
    }

}
