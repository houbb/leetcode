package com.github.houbb.leetcode.f500t600;

import java.util.HashMap;
import java.util.Map;

public class T523_checkSubarraySum_V2_SameMod {


    /**
     * 思路：
     * 1. 构建前缀和数组
     * 2. 穷举，找到符合结果的数据。
     *
     * 同余定理优化
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        final int n = nums.length;

        // 前缀和
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        // 用哈希表存储前缀和 mod k 的值
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // 处理从索引0开始的子数组

        // 遍历前缀和数组
        for (int i = 0; i < n; i++) {
            // 计算当前前缀和的模值
            int modValue = prefix[i] % k;

            // 处理 k != 0 时的情况
            if (k != 0) {
                modValue = modValue < 0 ? modValue + k : modValue;  // 处理负数取余
            }

            // 如果之前有相同的 mod 值，说明有符合条件的子数组
            if (modMap.containsKey(modValue)) {
                if (i - modMap.get(modValue) > 1) {  // 子数组长度至少为 2
                    return true;
                }
            } else {
                // 只记录第一次出现的前缀和 mod k 值
                modMap.put(modValue, i);
            }
        }

        return false;
    }

}
