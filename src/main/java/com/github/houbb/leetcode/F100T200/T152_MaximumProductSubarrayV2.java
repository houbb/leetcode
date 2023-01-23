package com.github.houbb.leetcode.F100T200;

public class T152_MaximumProductSubarrayV2 {

    /**
     * 最粗暴的算法：
     *
     * 1. 直接暴力计算。
     *
     * 递归呢？
     *
     * 直接移动 i, j 两个下标志，然后计算结果。
     *
     * https://leetcode.com/problems/maximum-product-subarray/solutions/1609493/c-simple-solution-w-explanation-optimization-from-brute-force-to-dp/
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int maxResult = nums[0];

        for(int i = 0; i < nums.length; i++) {
            int temp = 1;
            for(int j = i; j < nums.length; j++) {
                // 计算这个循环中的所有子数组，而不是从头计算
                temp *= nums[j];

                maxResult = Math.max(temp, maxResult);
            }
        }

        return maxResult;
    }

}
