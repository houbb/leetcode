package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T001_twoSum_V3_HashMap {


    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int other = target - nums[i];
            if(hashMap.containsKey(other)) {
                int j = hashMap.get(other);
                return new int[]{i, j};
            }
            // 存储
            hashMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

}
