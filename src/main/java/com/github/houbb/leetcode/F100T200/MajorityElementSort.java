package com.github.houbb.leetcode.F100T200;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MajorityElementSort {

    /**
     *
     * 排序之中间的元素肯定超过一半
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }


}
