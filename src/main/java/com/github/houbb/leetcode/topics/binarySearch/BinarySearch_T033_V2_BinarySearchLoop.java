package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T033_V2_BinarySearchLoop {

    public int search(int[] nums, int target) {
        int randomIndex = getRandomIndex(nums);
        // 无变化，或者整体变化
        if(randomIndex == -1) {
            return binarySearch(nums, target, 0, nums.length-1);
        }

        // 左边
        int leftIx = binarySearch(nums, target, 0, randomIndex);
        if(leftIx >= 0) {
            return leftIx;
        }

        // 右边
        int rightIx = binarySearch(nums, target, randomIndex+1, nums.length-1);
        if(rightIx >= 0) {
            return rightIx;
        }

        return -1;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midVal = nums[mid];
            if(midVal == target) {
                return mid;
            }

            // 大于，去左边
            if(midVal > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }

        }

        return -1;
    }

    private int getRandomIndex(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return i;
            }
        }
        // 没有变化
        return -1;
    }



}
