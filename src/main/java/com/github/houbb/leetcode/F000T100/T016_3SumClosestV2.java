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
public class T016_3SumClosestV2 {

    /**
     * 思路：
     *
     * 能否继续借助排序+双指针？
     *
     * 1. 最大值如果依然小于原有差异，跳过
     * 2. 最小值如果依然大于原有差异，跳过。
     *
     * 【效果】
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for 3Sum Closest.
     * Memory Usage: 38.9 MB, less than 85.21% of Java online submissions for 3Sum Closest.
     *
     * @param nums 数字
     * @param target 目标值
     * @return 结果
     * @since v1
     */
    public int threeSumClosest(int[] nums, int target) {
        // 最小
        int result = nums[0] + nums[1] + nums[2];

        //1. 排序
        Arrays.sort(nums);

        //2. 双指针
        for(int i = 0; i < nums.length-2; i++) {
            int l = i+1;
            int r = nums.length-1;

            if (nums[i] + nums[i+1] + nums[i+2] - target >= Math.abs(target - result)) {
                break;  //Too big, can't get better result!
            }
            if (i < nums.length-3 && nums[i+1] + nums[nums.length-2] + nums[nums.length-1] < target) {
                continue; //Too small, skip
            }

            while (l < r) {
                // 此处可以直接返回
                int sum = nums[i] + nums[l] + nums[r];

                // 如果差异较小
                if(Math.abs(sum-target) < Math.abs(result-target)) {
                    result = sum;
                } else if(sum < target) {
                    // 偏小
                    l++;
                } else if(sum > target) {
                    r--;
                } else {
                    return sum;
                }
            }
        }

        return result;
    }

}
