package com.github.houbb.leetcode.f500t600;

import java.util.HashMap;
import java.util.Map;

public class T525_findMaxLength_V2_prefixSumHashMap {


    public int longestWPI(int[] hours) {
        int n = hours.length;

        // 前缀和数组
        int[] prefixSum = new int[n];
        prefixSum[0] = hours[0] > 8 ? 1 : -1;
        // 计算前缀和数组，prefixSum[i] 表示前 i 个小时的“工作强度”的前缀和
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + (hours[i] > 8 ? 1 : -1);
        }

        // 哈希表记录前缀和第一次出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        // 遍历前缀和数组
        for (int i = 0; i <= n; i++) {
            // 如果前缀和大于 0，说明从数组的起始位置到当前位置的子数组和大于 0
            if (prefixSum[i] > 0) {
                res = Math.max(res, i);
            } else {
                // 查找前缀和减去 1 的位置
                if (map.containsKey(prefixSum[i] - 1)) {
                    res = Math.max(res, i - map.get(prefixSum[i] - 1));
                }
            }

            // 如果前缀和第一次出现，记录其位置
            if (!map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], i);
            }
        }

        return res;
    }

}
