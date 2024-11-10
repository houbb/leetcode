package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;

public class T259_threeSumSmaller_V2_SortTwoPointer {


    /**
     * @param nums
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        // 处理双指针
        final int n = nums.length;
        int count = 0;

        for(int i = 0; i < n-2; i++) {
            int left = i+1;
            int right = n-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum < target) {
                    // 此时，在左右中的任何一个元素都满足条件
                    // 但是这里不会重复吗？
                    count += right-left;

                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }


}
