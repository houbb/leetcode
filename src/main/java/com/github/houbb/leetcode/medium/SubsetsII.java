package com.github.houbb.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SubsetsII {

    /**
     * 数据允许重复，且结果不能重复。
     *
     * 那就需要排序 + 去重。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        backtrack(results, tempList, nums, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results,
                           List<Integer> tempList,
                           int[] nums,
                           int start) {
        results.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++) {
            // 去重
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }

            int current = nums[i];
            tempList.add(current);
            // 開始的數值向後偏移
            // 這裏的 start 要求很巧妙，i+1 直接從當前位置的後面開始
            backtrack(results, tempList, nums, i+1);

            // 回溯
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        int[] nums  = {1,2,3};
        System.out.println(subsets.subsetsWithDup(nums));
    }

}
