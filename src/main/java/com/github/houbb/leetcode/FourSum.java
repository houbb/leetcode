package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四个数的和
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-15 11:51:48
 */
public class FourSum {

    /**
     * 简单思路：
     *
     * 1. 排序
     * 2. 三指针？
     *
     * 1 2 3 4
     *
     * 双指针之上在加一层循环。
     *
     * 【效果】
     * 执行用时 :
     * 19 ms
     * , 在所有 Java 提交中击败了
     * 49.10%
     * 的用户
     * 内存消耗 :
     * 40.3 MB
     * , 在所有 Java 提交中击败了
     * 10.53%
     * 的用户
     *
     * @param nums 数组
     * @param target 目标
     * @return 结果
     * @since v1
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 大小可以优化
        List<List<Integer>> resultList = new ArrayList<>(nums.length);

        //1. 排序
        Arrays.sort(nums);

        //2. 类似双指针，固定左边2个元素。
        for(int i = 0; i < nums.length -3; i++) {
            // 跳过 i 的重复元素
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i+1; j < nums.length-2; j++) {
                // 确保跳过 j 的重复元素
                if(j > i+1 && nums[j] == nums[j-1])  {
                    continue;
                }

                // 双指针法则
                int l = j+1;
                int r = nums.length-1;

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
                            System.out.println("r--");
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
