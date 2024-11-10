package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T016_threeSumClosest_V1_SortTwoPointer {


    /**
     * @param nums
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        // 处理双指针
        final int n = nums.length;
        int result = Integer.MAX_VALUE;
        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < n-2; i++) {
            int left = i+1;
            int right = n-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 判断是否为最小距离
                if(sum == target) {
                    return target;
                }
                // 更新最小距离
                int abs = Math.abs(sum - target);
                if(abs < minDis) {
                    minDis = abs;
                    // 最小的 sum
                    result = sum;
                }


                if(sum > target) {
                    right--;
                }
                if(sum < target) {
                    left++;
                }
            }
        }
        return result;
    }


}
