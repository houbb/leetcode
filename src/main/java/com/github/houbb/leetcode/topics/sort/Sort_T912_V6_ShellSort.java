package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T912_V6_ShellSort {

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int gap = n / 2;

        while (gap > 0) {

            // 对每个组进行插排
            for (int i = gap; i < n; i++) {
                int temp = nums[i];
                int j = i;

                // 按照 gap 的步骤切割数组
                // 向左找到需要插入的位置
                while ((j - gap) >= 0 && nums[j - gap] > temp) {
                    // 移动
                    nums[j] = nums[j - gap];
                    j -= gap;
                }
                // 插入
                nums[j] = temp;
            }

            // 每次减少一半，逐步缩小步长
            gap /= 2;
        }

        return nums;
    }


    public static void main(String[] args) {
        Sort_T912_V6_ShellSort sort = new Sort_T912_V6_ShellSort();
        int[] nums = new int[]{-1,2,-8,-10};
        sort.sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
