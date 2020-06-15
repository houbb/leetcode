package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * k 个数的和
 *
 * @author binbin.hou
 * @date 2020-6-15 15:53:06
 * @since 1.0.0
 */
public class KSum {

    /**
     * 对 k 个数进行求和
     * @param nums 数组
     * @param target 目标值
     * @param k k
     * @param index 下标
     * @return 结果类表
     * @since v1
     */
    public List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        int len = nums.length;

        List<List<Integer>> resultList = new ArrayList<>();
        if (index >= len) {
            return resultList;
        }

        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                //find a pair
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target - nums[i]);
                    resultList.add(temp);
                    //skip duplication
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j - 1] == nums[j]) {
                        j--;
                    }
                    i++;
                    j--;
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    //move right bound
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1 sum
                List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if (temp != null) {
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    resultList.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return resultList;
    }

}
