package com.github.houbb.leetcode.topics.arrayTraverse;

public class T283_MoveZero_V1_TwoPointer {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        for(right = 0; right < nums.length; right++) {
            if(nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }

        // 后面全部放置0？
        for(int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
