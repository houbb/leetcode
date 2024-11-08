package com.github.houbb.leetcode.F300T400;

import java.util.HashMap;

public class T325_LongestSubarraySumK_V1 {

    public static int longestSubarrayWithSumK(int[] nums, int k) {
        int n = nums.length;
        // 预处理前缀和
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        // 用哈希表记录前缀和第一次出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        // 特殊情况，前缀和为0时从开头开始
        map.put(0, -1);
        int maxLength = 0;
        // 遍历前缀和数组
        for (int i = 0; i < n; i++) {
            // 如果prefixSum[i] - k在map中，表示存在子数组和为k
            if (map.containsKey(prefixSum[i] - k)) {
                // 计算当前子数组的长度
                int length = i - map.get(prefixSum[i] - k);
                maxLength = Math.max(maxLength, length);
            }

            // 如果当前前缀和没有出现过，则记录它的位置
            if (!map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(longestSubarrayWithSumK(nums, k));  // 输出: 4

        int[] nums2 = {-2,-1,2,1};
        System.out.println(longestSubarrayWithSumK(nums2, 1));  // 输出: 2
    }

}
