package com.github.houbb.leetcode.topics.hashing;

import java.util.HashMap;
import java.util.Map;

public class T01_twoSum_V1_HashMap {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // 遍历
        // 并且你不能使用两次相同的元素。
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int differ = target-num;
            Integer differIx = map.get(differ);
            if(differIx != null && differIx != i) {
                return new int[]{i,differIx};
            }
        }

        // 不会到这里
        return new int[]{-1,-1};
    }

}
