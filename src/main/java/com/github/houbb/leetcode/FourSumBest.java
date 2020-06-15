package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 四个数的和-最佳策略
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-15 13:36:42
 */
public class FourSumBest {

    /**
     * 简单思路：
     *
     * 1. 快速失败
     * 2. min/max 统计，如果超过，快速返回
     *
     * 【效果】
     *
     * Runtime: 5 ms, faster than 92.21% of Java online submissions for 4Sum.
     * Memory Usage: 39.9 MB, less than 56.17% of Java online submissions for 4Sum.
     *
     * @param nums 数组
     * @param target 目标
     * @return 结果
     * @since v2
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //1.1 快速返回
        if(nums.length < 4) {
            return Collections.emptyList();
        }

        // 大小可以优化
        List<List<Integer>> resultList = new ArrayList<>(nums.length);

        //2. 排序
        Arrays.sort(nums);

        //1.2 范围判断
        final int length = nums.length;
        int min = nums[0] + nums[1] + nums[2] + nums[3];
        int max = nums[length-1] + nums[length-2] + nums[length-3] + nums[length-4];
        if(min > target || max < target) {
            return resultList;
        }


        //3. 类似双指针，固定左边2个元素。
        for(int i = 0; i < length -3; i++) {
            // 跳过 i 的重复元素
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i+1; j < length-2; j++) {
                // 确保跳过 j 的重复元素
                if(j > i+1 && nums[j] == nums[j-1])  {
                    continue;
                }

                // 双指针法则
                int l = j+1;
                int r = length-1;

                // 快速跳过
                int minInner = nums[i] + nums[j] + nums[j+1] + nums[j+2];
                int maxInner = nums[i] + nums[j] + nums[r-1] + nums[r];
                if(minInner > target || maxInner < target) {
                    continue;
                }

                while (l < r) {
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];

                    // 遍历完所有符合的信息
                    if(sum < target) {
                        l++;
                    } else if(sum > target) {
                        r--;
                    } else {
                        List<Integer> result = Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                        resultList.add(result);

                        // 跳过重复的元素
                        while (l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        while(l < r && nums[r] == nums[r-1]) {
                            r--;
                        }

                        l++;
                        r--;
                    }
                }
            }
        }

        return resultList;
    }

}
