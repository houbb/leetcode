package com.github.houbb.leetcode.F100T200;

public class T152_MaximumProductSubarrayV3 {

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
        int max = nums[0], min = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int maxMulti = max * nums[i];
            int minMulti = min * nums[i];
            max = Math.max(Math.max(maxMulti, minMulti), nums[i]);
            min = Math.min(Math.min(maxMulti, minMulti), nums[i]);

            // 更新最大值
            result = Math.max(result, max);
        }
        return result;
    }

}
