package com.github.houbb.leetcode.topics.hashing;

import java.util.HashMap;
import java.util.Map;

public class T01_twoSum_V2_HashMap_Opt {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int differ = target - num;

            // 理论上这里一定会结束
            if(map.containsKey(differ)) {
                return new int[]{i,map.get(differ)};
            }

            map.put(num, i);
        }
        // 不会到这里
        return new int[]{-1,-1};
    }

}
