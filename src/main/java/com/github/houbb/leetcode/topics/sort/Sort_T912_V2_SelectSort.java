package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T912_V2_SelectSort {

    public int[] sortArray(int[] nums) {
        // 外层控制循环
        for(int i = 0; i < nums.length; i++) {

            int minIx = i;
            int minVal = nums[i];
            // 找到 i 后边的最小值
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] < minVal) {
                    minIx = j;
                    minVal = nums[j];
                }
            }

            // 交换
            swap(nums, i, minIx);
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Sort_T912_V2_SelectSort sort = new Sort_T912_V2_SelectSort();
        int[] nums = new int[]{-1,2,-8,-10};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
