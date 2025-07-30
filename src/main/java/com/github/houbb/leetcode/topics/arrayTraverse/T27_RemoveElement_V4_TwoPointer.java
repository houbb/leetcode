package com.github.houbb.leetcode.topics.arrayTraverse;

import java.util.Arrays;

public class T27_RemoveElement_V4_TwoPointer {

    public int removeElement(int[] nums, int val) {
        // 左边的指针，用于只保留不等于 val 的值
        int left = 0;
        // right 用于正常遍历
        int right = 0;

        for(right = 0; right < nums.length; right++) {
            // 将符合条件元素，放在 left 的位置
            if(nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        T27_RemoveElement_V4_TwoPointer swap = new T27_RemoveElement_V4_TwoPointer();

        int[]  nums = new int[]{0,1,2,2,3,0,4,2};
        int res = swap.removeElement(nums, 2);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

}
