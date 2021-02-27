package com.github.houbb.leetcode.medium;

import java.util.Arrays;

/**
 * 思路：有序的数组，不过元素存在重复的。
 *
 * 直接通过二分法查找。
 *
 * 1. 如果不存在，直接返回 [-1, -1]
 *
 * 2. 如果存在，则从 index 向后遍历，找到最后一个元素。
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int index = binarySearch(nums, target);
        if(-1 == index) {
            return result;
        }

        for(int i = index; i >= 0; i--) {

            if(nums[i] != target) {
                break;
            } else {
                // 如果相同
                result[0] = i;
            }
        }

        // 设置最后一个
        for(int i = index; i < nums.length; i++) {
            if(nums[i] != target) {
                break;
            } else {
                result[1] = i;
            }
        }

        return result;
    }


    /**
     * 二分法找到的元素可能不是刚好的。
     * @param nums
     * @param target
     * @return
     */
    private static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;

            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                // 偏大
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        // NOT FOUND
        return -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPosition solution = new FindFirstAndLastPosition();

//        int[] nums = {5,7,7,8,8,10};
//        System.out.println(Arrays.toString(solution.searchRange(nums, 8)));

        int[] nums2 = {1};
        System.out.println(Arrays.toString(solution.searchRange(nums2, 1)));
    }

}
