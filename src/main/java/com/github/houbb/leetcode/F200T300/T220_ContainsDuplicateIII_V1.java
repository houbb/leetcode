package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * # 题目
 *
 *
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 *
 * 找出满足下述条件的下标对 (i, j)：
 *
 * i != j,
 *
 * abs(i - j) <= indexDiff
 *
 * abs(nums[i] - nums[j]) <= valueDiff
 *
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * ## 示例 1：
 *
 * 输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * 输出：true
 * 解释：可以找出 (i, j) = (0, 3) 。
 * 满足下述 3 个条件：
 * i != j --> 0 != 3
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 *
 * ## 示例 2：
 *
 * 输入：nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
 * 输出：false
 * 解释：尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 1 <= indexDiff <= nums.length
 * 0 <= valueDiff <= 10^9
 */
public class T220_ContainsDuplicateIII_V1 {


    /**
     * 思路1：暴力算法。
     *
     * i != j,
     * abs(i - j) <= indexDiff
     * abs(nums[i] - nums[j]) <= valueDiff
     *
     *
     * @param nums 数组
     * @return 结果
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // 遍历所有可能的 i,j
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i + indexDiff; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }

        return false;
    }



    /**
     * 正常获取最小值，需要先排序。
     * 但是这里其实是天然的排序的。
     * 只需要计算2个之间的距离就行
     *
     *
     * 这里多次计算，可以使用 dp 优化？
     * @param otherNums 数字
     * @return 结果
     */
    private int getMinDistance(List<Integer> otherNums) {
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < otherNums.size()-1; i++) {
            int distance = otherNums.get(i+1) - otherNums.get(i);
            if(distance < result) {
                result = distance;
            }
        }
        return result;
    }

}
