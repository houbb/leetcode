package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T34_V2_Recursive {

    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length-1);
        if(index == -1) {
            return new int[]{-1, -1};
        }

        // 左右遍历，找到结果
        int left = index;
        int right = index;

        while (left > 0) {
            if(nums[left-1] == target) {
                left--;
            } else {
                break;
            }
        }
        while (right < nums.length-1) {
            if(nums[right+1] == target) {
                right++;
            } else {
                break;
            }
        }

        return new int[]{left, right};
    }


    public int binarySearch(int[] nums, int target, int left, int right) {
        if(left > right) {
            return -1;
        }

        int mid = left + (right-left) / 2;
        int midVal = nums[mid];
        if(midVal == target) {
            return mid;
        }

        // 小，去右边
        if(midVal < target) {
            return binarySearch(nums, target, mid+1, right);
        }
        return binarySearch(nums, target, left, mid-1);
    }

}
