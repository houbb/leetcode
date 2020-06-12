package com.github.houbb.leetcode;

import java.util.*;

/**
 * 优化思路：
 *
 * 1. 数组分为>=0，小于0两部分
 * 2. 数组排序
 * 3. 双指针法则
 * 指针肯定落在两边，而不会是一边。（否则不可能和为0 ）
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-12 09:10:38
 */
public class ThirdNumSortedAndTwoPointer {

    /**
     * 三个数字
     *
     * 从左向右遍历：
     *
     * 1. nums[i] > 0 直接返回
     * 2. nums[L] + nums[R] + nums[i] == 0 防重复添加
     *
     * 初始化：
     *  L = i+1;
     *  R = i+2;
     *
     *   if(> 0) {
     *      // 太大
     *      L++;
     *   } else {
     *      R--;
     *   }
     *
     * 【效果】
     * 99.87
     *
     * 60.29
     * @param nums 入参
     * @return 结果
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //1. 排序
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>(nums.length);

        //2. 双指针
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(num > 0) {
                return results;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i+1;
            int r = nums.length-1;

            while (l < r) {
                int sum = num + nums[l] + nums[r];
                if(sum < 0) {
                    l++;
                } else if(sum > 0) {
                    r--;
                } else {
                    List<Integer> integers = new ArrayList<>(3);
                    integers.add(num);
                    integers.add(nums[l]);
                    integers.add(nums[r]);
                    results.add(integers);

                    // 跳过重复的元素
                    while(l < r && nums[l+1] == nums[l]) {
                        l++;
                    }
                    while (l < r && nums[r-1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }

        return results;
    }

}
