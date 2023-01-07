package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T035_SearchInsertPositionV2 {

    /**
     * O(logn)
     *
     * 因为是有序的，所以直接就是一道 binary search 的问题。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;

        while (max >= min) {
            int mid = (max + min) / 2;

            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                // 偏大
                max = mid-1;
            } else {
                min = mid + 1;
            }
        }

        // 最后没找到怎么办？
        if(target < nums[0]) {
            return 0;
        }
        if(target > nums[nums.length-1]) {
            return nums.length;
        }

        return min;
    }

}
