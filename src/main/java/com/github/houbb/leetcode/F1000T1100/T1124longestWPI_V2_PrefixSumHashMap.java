package com.github.houbb.leetcode.F1000T1100;

import java.util.HashMap;

public class T1124longestWPI_V2_PrefixSumHashMap {

    public int longestWPI(int[] hours) {
        int n = hours.length;

        // 前缀和数组
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + hours[i];
        }

        // 哈希表，记录每个前缀和第一次出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // 初始化为前缀和0出现的位置是-1

        int maxLength = 0;

        // 遍历前缀和数组
        for (int i = 0; i <= n; i++) {
            // 如果当前前缀和大于0，说明从起始位置到当前位置的子数组和大于0
            if (prefixSum[i] > 0) {
                maxLength = Math.max(maxLength, i);
            }

            // 查找是否有前缀和在某个位置之前等于当前前缀和减去某个值（例如0），能得到子数组和大于0
            for (int j = 0; j < i; j++) {
                if (prefixSum[i] - prefixSum[j] > 0) {
                    maxLength = Math.max(maxLength, i - j);
                }
            }
        }

        return maxLength;
    }


}
