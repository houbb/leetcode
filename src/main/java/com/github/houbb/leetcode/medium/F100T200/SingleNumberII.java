package com.github.houbb.leetcode.medium.F100T200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SingleNumberII {

    /**
     * Runtime: 3 ms, faster than 59.27% of Java online submissions for Single Number II.
     * Memory Usage: 38.5 MB, less than 85.23% of Java online submissions for Single Number II.
     *
     * @param nums 数字
     * @return 结果
     */
    public int singleNumber(int[] nums) {
        // 參數防禦
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        if(nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i : nums) {
            Integer count = map.get(i);
            if(count == null) {
                count = 0;
            }
            map.put(i, count+1);
        }

        // 遍歷
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(1 == entry.getValue()) {
                return entry.getKey();
            }
        }

        //NOT FOUND
        throw new IllegalArgumentException();
    }

}
