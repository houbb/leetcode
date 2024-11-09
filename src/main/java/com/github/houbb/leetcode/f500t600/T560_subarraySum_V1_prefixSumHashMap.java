package com.github.houbb.leetcode.f500t600;

import java.util.HashMap;
import java.util.Map;

public class T560_subarraySum_V1_prefixSumHashMap {


    public static void main(String[] args) {
        T560_subarraySum_V1_prefixSumHashMap hashMap = new T560_subarraySum_V1_prefixSumHashMap();

        int[] nums = new int[]{0};
        int k = 0;
        System.out.println(hashMap.subarraySum(nums, k));
    }


    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        // 前缀和数组
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        // 哈希表记录前缀和第一次出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        // 从零开始的计算  下标为0的元素，前缀和为0，数量为1
        map.put(0, 1);
        int count = 0;

        // 遍历前缀和数组
        for (int i = 0; i < n; i++) {
            // 查找前缀和减去 k 的位置，则说明满足等于 k
            int sum = prefixSum[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
