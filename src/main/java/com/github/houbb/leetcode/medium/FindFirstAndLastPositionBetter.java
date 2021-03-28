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
public class FindFirstAndLastPositionBetter {

    public int[] searchRange(int[] nums, int target) {
        // 参数校验
        if(nums == null) {
            // 或者抛出异常
            return null;
        }

        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);

        return new int[]{first, last};
    }

    /**
     * 二分法找到的元素第一次出现的位置
     * @param nums 数组
     * @param target 目标值
     * @return 结果下标
     */
    private static int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;


            if(target == nums[mid]) {
                // 调整一下返回的条件
                // 如果是第一个元素，获取上一个元素不等于当前元素
                if(mid == 0 || (nums[mid-1] != target)) {
                    return mid;
                } else {
                    // 否则的话，high 调整为 mid 的上一个位置
                    high = mid-1;
                }
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

    /**
     * 二分法找到的元素最后一次出现的位置
     * @param nums 数组
     * @param target 目标值
     * @return 结果下标
     */
    private static int binarySearchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;

            if(target == nums[mid]) {
                // 调整一下返回的条件
                // 如果是第一个元素，获取上一个元素不等于当前元素
                if(mid == nums.length-1 || (nums[mid+1] != target)) {
                    return mid;
                } else {
                    // 否则的话，low 调整为 mid 的下一个位置
                    low = mid+1;
                }
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
        FindFirstAndLastPositionBetter solution = new FindFirstAndLastPositionBetter();

//        int[] nums = {5,7,7,8,8,10};
//        System.out.println(Arrays.toString(solution.searchRange(nums, 8)));

        int[] nums2 = {1};
        System.out.println(Arrays.toString(solution.searchRange(nums2, 1)));
    }

}
