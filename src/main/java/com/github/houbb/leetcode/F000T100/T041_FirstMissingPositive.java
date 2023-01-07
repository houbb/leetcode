package com.github.houbb.leetcode.F000T100;

import java.util.Arrays;

/**
 * @author d
 * @since 1.0.0
 */
public class T041_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        // 排序
        Arrays.sort(nums);

        // 看第一个元素，如果比1大，则返回1
        // 最后一个元素，如果比1小，则返回1
        if(nums[0] > 1 || nums[nums.length-1] < 1) {
            return 1;
        }

        // 遍历对比
        int nextInt = 1;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // 如果和前一个相同，则跳过
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // 可能和前一个数字相同
            if(num > 1 && num != nextInt) {
                return nextInt;
            }

            if(num > 0) {
                nextInt = num+1;
            }
        }

        return nextInt;
    }


}
