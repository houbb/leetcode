package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T137_SingleNumberII_V2_Sort {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);  // 对数组进行排序
        for (int i = 0; i < nums.length; i += 3) {
            // 如果当前数字与下一个和下下个不同，说明该数字出现次数为 1
            if (i + 1 >= nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1; // 不会执行到，防止编译器报错
    }

}
