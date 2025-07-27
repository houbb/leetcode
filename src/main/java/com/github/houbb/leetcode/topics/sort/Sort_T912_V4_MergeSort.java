package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T912_V4_MergeSort {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);

        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        // 终止
        if(left >= right) {
            return;
        }

        // 拆分为子问题，递归处理
        int mid = left + (right-left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        // 整体合并
        merge(nums, left, right, mid);
    }

    private void merge(int[] nums, int left, int right, int mid) {
        int temp[] = new int[right-left+1];

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
//        for(int i = 0; i < temp.length; i++) {
//            nums[i+left] = temp[i];
//        }

        System.arraycopy(temp, 0, nums, left, temp.length);
    }



    public static void main(String[] args) {
        Sort_T912_V4_MergeSort sort = new Sort_T912_V4_MergeSort();
        int[] nums = new int[]{-1,2,-8,-10};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
