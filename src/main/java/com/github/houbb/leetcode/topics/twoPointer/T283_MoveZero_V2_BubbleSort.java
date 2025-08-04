package com.github.houbb.leetcode.topics.twoPointer;

public class T283_MoveZero_V2_BubbleSort {

    public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length-i-1; j++) {
                // 交换
                if(nums[j] == 0 && nums[j+1] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

}
