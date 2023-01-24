package com.github.houbb.leetcode.F100T200;

public class T154_FindMinimumInRotatedSortedArrayII {

    /**
     * o(n) 傻瓜式算法
     *
     * PS：这个测试用例毫无区分度
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int min = nums[0];

        for(int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        return min;
    }

}
