package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T912_V4_MergeSortOpt {

    public int[] sortArray(int[] nums) {
        // 节省数组创建开销
        int[] temp = new int[nums.length];

        mergeSort(nums, 0, nums.length-1, temp);

        return nums;
    }

    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 终止
        if(left >= right) {
            return;
        }

        // 拆分为子问题，递归处理
        int mid = left + (right-left)/2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid+1, right, temp);

        // 整体合并
        if(nums[mid] <= nums[mid + 1]) {
            return;
        }
        merge(nums, left, right, mid, temp);
    }

    private void merge(int[] nums, int left, int right, int mid, int[] temp) {
        int lx = left;
        int rx = mid+1;

        // 找小的，放入 temp
        int tempIx = 0;
        while (lx <= mid && rx <= right) {
            //左边更小
            if(nums[lx] <= nums[rx]) {
                temp[tempIx++] = nums[lx++];
            } else {
                temp[tempIx++] = nums[rx++];
            }
        }

        // 把二者没放完的，放入到 temp 中
        while (lx <= mid) {
            temp[tempIx++] = nums[lx++];
        }
        while (rx <= right) {
            temp[tempIx++] = nums[rx++];
        }

        // 拷贝
        System.arraycopy(temp, 0, nums, left, (right-left+1));
    }

    public static void main(String[] args) {
        Sort_T912_V4_MergeSortOpt sort = new Sort_T912_V4_MergeSortOpt();
        int[] nums = new int[]{-1,2,-8,-10};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
