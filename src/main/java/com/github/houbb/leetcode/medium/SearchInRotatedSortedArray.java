package com.github.houbb.leetcode.medium;

/**
 * 思路：有序的数组，可以直接根据二分查询，找到对应的 index
 *
 * 然后随机生产一个一个平移的数字，对数组进行平移。
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

    }


    /**
     * 二分查询
     * @param nums 原始数组
     * @param target 目标值
     * @return 结果
     * @since v33
     */
    private int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = high/2;

        while (low < high) {

        }
    }

}
