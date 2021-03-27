package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MajorityElementII {

    /**
     * Runtime: 8 ms, faster than 29.02% of Java online submissions for Majority Element II.
     * Memory Usage: 42.3 MB, less than 78.51% of Java online submissions for Majority Element II.
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        // 最多两个元素
        List<Integer> results = new ArrayList<>(2);

        int limit = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;

            if(count > limit && !results.contains(num)) {
                results.add(num);
            }

            map.put(num, count);
        }

        return results;
    }

}
