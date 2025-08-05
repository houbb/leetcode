package com.github.houbb.leetcode.topics.substring;

import java.util.HashMap;
import java.util.Map;

public class T560_subarraySum_V3_PrefixSum {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

}
