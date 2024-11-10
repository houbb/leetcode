package com.github.houbb.leetcode.datastruct.array;

import java.util.HashMap;

public class T167_twoSum_V3_HashMap {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int other = target - nums[i];
            if(hashMap.containsKey(other)) {
                int j = hashMap.get(other);
                return new int[]{j+1, i+1};
            }
            // 存储
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    
}
