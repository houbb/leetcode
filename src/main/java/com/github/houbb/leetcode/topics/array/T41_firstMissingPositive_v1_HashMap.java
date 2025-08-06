package com.github.houbb.leetcode.topics.array;

import java.util.HashMap;
import java.util.Map;

public class T41_firstMissingPositive_v1_HashMap {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    // 这一题大概率是数字哈希来解决
    public static int firstMissingPositive(int[] nums) {
        // 不排序
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int n : nums) {
            int count = numsMap.getOrDefault(n, 0);
            numsMap.put(n, count+1);

            min = Math.min(n, min);
            max = Math.max(n, max);
        }

        // 如何判断呢？
        for(int i = 1; i <= max; i++) {
            if(!numsMap.containsKey(i)) {
                return i;
            }
        }

        // 结果
        return Math.max(1, max+1);
    }


}
