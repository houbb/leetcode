package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T912_V5_QuickSort {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // 终止
        if (left >= right) {
            return;
        }

        int partIx = partition(nums, left, right);

        // 拆分为左右两边，递归排序
        quickSort(nums, left, partIx-1);
        quickSort(nums, partIx+1, right);
    }

    private int partition(int[] nums, int left, int right) {
        // 初始选择最右边，方便理解
        int pivotVal = nums[right];

        // 标记，我们选择的拆分点的位置
        int px = left;

        // 将小于的 pivotVal 全部放在左边
        // 对比值是最后一个，用小于判断右边界
        for(int i = left; i < right; i++) {
            // 这里可以验证一下，等于不变，会怎么样？
            if(nums[i] < pivotVal) {
                swap(nums, px, i);
                px++;
            }
        }

        // 将 pivotVal 放在中间，默认取的是 right 值，最后和 right 交换即可
        swap(nums, px, right);

        // 返回分割位置
        return px;
    }


    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }


    public static void main(String[] args) {
        Sort_T912_V5_QuickSort sort = new Sort_T912_V5_QuickSort();
        int[] nums = new int[]{-1,2,-8,-10};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
