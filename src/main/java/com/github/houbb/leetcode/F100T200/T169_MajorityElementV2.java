package com.github.houbb.leetcode.F100T200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T169_MajorityElementV2 {

    /**
     * Runtime: 9 ms, faster than 31.63% of Java online submissions for Majority Element.
     * Memory Usage: 44.1 MB, less than 38.35% of Java online submissions for Majority Element.
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int limit = nums.length >> 1;
        Map<Integer, Integer> countMap = new HashMap<>(limit);
        for(int n : nums) {
            int count = countMap.getOrDefault(n,0)+1;
            if(count > limit) {
                return n;
            }

            countMap.put(n, count);
        }

        // 异常
        return -1;
    }


}
