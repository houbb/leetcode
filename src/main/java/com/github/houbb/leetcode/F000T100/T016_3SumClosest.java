package com.github.houbb.leetcode.F000T100;

import java.util.Arrays;

/**
 * 条件：最接近答案的三个值。
 *
 * 1. 至少有一个解
 * 2. 限定
 *
 * <pre>
 *   3 <= nums.length <= 10^3
 *  -10^3 <= nums[i] <= 10^3
 *  -10^4 <= target <= 10^4
 * </pre>
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class T016_3SumClosest {

    /**
     * 思路：
     *
     * 能否继续借助排序+双指针？
     *
     * 1. 如果相等，则直接返回
     * 2. 否则需要保存最接近的一个值。
     *
     * 3. 如果差异越来越大，则直接停止。
     *
     * 使用 abs
     *
     * @param nums 数字
     * @param target 目标值
     * @return 结果
     * @since v1
     */
    public int threeSumClosest(int[] nums, int target) {
        // 最小
        if(nums.length == 3) {
            return nums[0]+nums[1]+nums[2];
        }

        //1. 排序
        Arrays.sort(nums);

        //2. 双指针
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int l = i+1;
            int r = nums.length-1;

            // 去重 i,l,r
            while (l < r) {
                // 此处可以直接返回
                int sum = nums[i] + nums[l] + nums[r];
                int loopDiff = sum-target;

                if(sum == target) {
                    return target;
                } else if(loopDiff < 0) {
                    // 偏小
                    l++;

                    if(Math.abs(loopDiff) < Math.abs(diff)) {
                        diff = loopDiff;
                    }
                } else {
                    // 偏大
                    r--;

                    if(Math.abs(loopDiff)  < Math.abs(diff)) {
                        diff = loopDiff;
                    }
                }
            }
        }

        return target+diff;
    }
//
//    private int abs(int num) {
//        return num < 0 ? -num : num;
//    }
}
