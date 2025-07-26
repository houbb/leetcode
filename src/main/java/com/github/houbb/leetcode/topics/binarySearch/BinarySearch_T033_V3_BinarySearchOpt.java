package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T033_V3_BinarySearchOpt {

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
            int mid = left + (right - left);

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
        int left = 0, right = nums.length - 1;

        // 没有旋转
        if (nums[left] <= nums[right]) {
            return -1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 找到断点 不符合严格升序
            // nums = [4,5,6,7,0,1,2]
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // 左边是有序的，说明断点在右边
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


}
