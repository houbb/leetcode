package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T912_V3_InsertSortBinarySearch {

    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curNum = nums[i];

            // 在 [0, i-1] 区间内查找 curNum 的插入位置
            int insertPos = binarySearch(nums, 0, i - 1, curNum);

            // 将 insertPos ~ i-1 区间整体向右移动一位
            System.arraycopy(nums, insertPos, nums, insertPos + 1, i - insertPos);

            // 插入当前数
            nums[insertPos] = curNum;
        }
        return nums;
    }

    /**
     * 在 nums[left...right] 中找到第一个 >= target 的位置
     * 如果所有值都小于 target，则返回 right + 1（即插入到最后）
     */
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 找到一个 >= 的，继续向左逼近
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        Sort_T912_V3_InsertSortBinarySearch sort = new Sort_T912_V3_InsertSortBinarySearch();
        int[] nums = new int[]{-1,2,-8,-10};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
