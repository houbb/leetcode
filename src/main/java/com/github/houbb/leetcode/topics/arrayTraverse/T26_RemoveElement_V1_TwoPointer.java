package com.github.houbb.leetcode.topics.arrayTraverse;

public class T26_RemoveElement_V1_TwoPointer {

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }

        int left = 1;
        int right = 1;

        for(right = 1; right < nums.length; right++) {
            // 不重复
            if(nums[right] != nums[right-1]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

}
