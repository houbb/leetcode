package com.github.houbb.leetcode.F100T200;

public class T198_HouseRobber {

    public int rob(int[] nums) {
        return recursive(nums, nums.length-1);
    }

    private int recursive(int[] nums, int i) {
        if(i < 0) {
            return 0;
        }

        int robCur = recursive(nums, i-2) + nums[i];
        int notRobCur = recursive(nums, i-1);
        return Math.max(robCur, notRobCur);
    }

}
