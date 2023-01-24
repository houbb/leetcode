package com.github.houbb.leetcode.F100T200;

public class T162_FindPeakElement {

    /**
     * 这题 test 没意思，直接 O(n) 的效果就是 100%
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }

        // 第一个
        if(nums[0] > nums[1]) {
            return 0;
        }

        // 最后一个
        final int len = nums.length;
        if(nums[len-1] > nums[len-2]) {
            return len-1;
        }

        // 遍历
        for(int i = 1; i < len-1; i++) {
            if(nums[i] > nums[i-1]
                && nums[i] > nums[i+1]) {
                return i;
            }
        }

        // 如果没有呢？
        return 0;
    }


}
