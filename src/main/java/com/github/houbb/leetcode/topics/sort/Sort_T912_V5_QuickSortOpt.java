package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T912_V5_QuickSortOpt {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        // 三路快排
        int pivot = nums[right]; // 仍然选右边作为 pivot

        int lt = left;     // nums[left...lt-1] < pivot
        int gt = right;    // nums[gt+1...right] > pivot
        int i = left;      // 当前处理元素

        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++; // nums[i] == pivot，跳过
            }
        }

        quickSort(nums, left, lt - 1);
        quickSort(nums, gt + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    public static void main(String[] args) {
        Sort_T912_V5_QuickSortOpt sort = new Sort_T912_V5_QuickSortOpt();
        int[] nums = new int[]{-1, 2, -8, -10};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
