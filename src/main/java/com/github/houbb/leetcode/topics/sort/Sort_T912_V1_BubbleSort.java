package com.github.houbb.leetcode.topics.sort;

public class Sort_T912_V1_BubbleSort {

    public int[] sortArray(int[] nums) {
        // 外层控制循环 为什么是 N-1?
        for(int i = 0; i < nums.length; i++) {

            // 内层控制大的向后交换 前面处理过的，则不需要再次处理
            for(int j = 0; j < nums.length-1-i; j++) {
                // 如果比后面的大，则交换
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return nums;
    }

}
