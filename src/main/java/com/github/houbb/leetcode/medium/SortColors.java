package com.github.houbb.leetcode.medium;

import java.util.Arrays;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SortColors {

    public void sortColors(int[] nums) {
        trickSort(nums);
    }

    // 直接统计对应的数量，然后覆盖
    private void trickSort(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;

        // 统计个数
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 0) {
                num0++;
            } else if(num == 1) {
                num1++;
            } else {
                num2++;
            }
        }

        // 执行覆盖 0
        for(int i = 0; i < num0; i++) {
            nums[i] = 0;
        }
        // 最大值判断
        if(num0  >= nums.length) {
            return;
        }
        for(int i = num0; i < num0+num1; i++) {
            nums[i] = 1;
        }
        // 最大值判断
        if(num0 + num1 >= nums.length) {
            return;
        }
        for(int i = num0+num1; i < num0+num1+num2; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
