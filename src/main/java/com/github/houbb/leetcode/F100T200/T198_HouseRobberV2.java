package com.github.houbb.leetcode.F100T200;

public class T198_HouseRobberV2 {

    public int rob(int[] nums) {
        Integer[] mem = new Integer[nums.length];

        return recursive(nums, nums.length-1, mem);
    }

    private int recursive(int[] nums, int i, Integer[] mem) {
        // 获取 cache
        if(mem[i] != null) {
            return mem[i];
        }


        int result = 0;
        if(i < 0) {
            return result;
        }

        int robCur = recursive(nums, i-2, mem) + nums[i];
        int notRobCur = recursive(nums, i-1, mem);

        result  = Math.max(robCur, notRobCur);

        // cache
        mem[i] = result;
        return result;
    }

}
