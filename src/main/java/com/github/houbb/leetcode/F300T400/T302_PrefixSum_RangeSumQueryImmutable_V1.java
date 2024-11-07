package com.github.houbb.leetcode.F300T400;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T302_PrefixSum_RangeSumQueryImmutable_V1 {


    private int[] sum;

    private int[] nums;
    public T302_PrefixSum_RangeSumQueryImmutable_V1(int[] nums) {
        sum = new int[nums.length];

        // 初始化
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        return sum[right] - sum[left] + nums[left];
    }
    

}
