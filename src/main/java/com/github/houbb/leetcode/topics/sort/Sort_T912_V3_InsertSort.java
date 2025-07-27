package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T912_V3_InsertSort {

    public int[] sortArray(int[] nums) {
        // 0 位置本身有序
        for(int i = 1; i < nums.length; i++) {
            int curNum = nums[i];

            // 在左边找到合适的位置
            int j = i-1;

            // 需要等于，因为可能是最小值
            while (j >= 0 && nums[j] > curNum) {
                nums[j+1] = nums[j];    // 向后移动一位

                j--;
            }

            // 插入新的数  j 是最小值下标，最小的时候 j=-1
            nums[j+1] = curNum;
        }

        return nums;
    }


    public static void main(String[] args) {
        Sort_T912_V3_InsertSort sort = new Sort_T912_V3_InsertSort();
        int[] nums = new int[]{-1,2,-8,-10};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
