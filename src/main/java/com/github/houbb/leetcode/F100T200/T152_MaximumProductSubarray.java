package com.github.houbb.leetcode.F100T200;

public class T152_MaximumProductSubarray {

    /**
     * 最粗暴的算法：
     *
     * 1. 直接暴力计算。
     *
     * 递归呢？
     *
     * 1. 自己
     * 2. 自己+左边最大？
     * 3. 自己+右边最大？
     *
     *
     * 直接移动 i, j 两个下标志，然后计算结果。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int maxResult = nums[0];

        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int result = calc(nums, i, j);
                maxResult = Math.max(result, maxResult);
            }
        }

        return maxResult;
    }

    /**
     * 186 / 189 TEL
     *
     * @param nums
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int calc(int[] nums, int startIndex, int endIndex) {
        int result = 1;

        for(int i = startIndex; i <= endIndex; i++) {
            result *= nums[i];
        }

        return result;
    }

}
