package com.github.houbb.leetcode.F100T200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MajorityElement {

    /**
     * Runtime: 9 ms, faster than 31.63% of Java online submissions for Majority Element.
     * Memory Usage: 44.1 MB, less than 38.35% of Java online submissions for Majority Element.
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int maxCount = 1;

        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        //O(N)
        for(int n : nums) {
            int count = countMap.getOrDefault(n,0)+1;
            if(count >= maxCount) {
                result = n;
                maxCount = count;
            }

            // 统计次数
            countMap.put(n, count);
        }

        // 找到超过一半的元素
        return result;
    }


}
