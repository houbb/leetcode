package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T169_MajorityElementV4 {

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
