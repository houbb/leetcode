package com.github.houbb.leetcode.F300T400;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T307_PrefixSum_RangeSumQueryMutable_V1 {

    private int[] sum;

    private int[] nums;

    public T307_PrefixSum_RangeSumQueryMutable_V1(int[] nums) {
        sum = new int[nums.length];

        // 初始化
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        this.nums = nums;
    }

    public void update(int index, int val) {
        // 更新对应的数据？
        int oldNum = this.nums[index];
        if(oldNum == val) {
            return;
        }
        this.nums[index] = val;

        // 如果不一样
        int differ = val - oldNum;
        // 更新原始的数组
        for(int i = index; i < nums.length; i++) {
            this.sum[i] += differ;
        }
    }

    public int sumRange(int left, int right) {
        return sum[right] - sum[left] + nums[left];
    }
    

}
