package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.List;

public class T216_CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};

        backtrack(results, tempList, nums, k, n, 0);

        return results;
    }

    private void backtrack(List<List<Integer>> results,
                           List<Integer> tempList,
                           int[] nums,
                           int k,
                           int remain,
                           int start) {
        if(remain == 0 && tempList.size() == k) {
            results.add(new ArrayList<>(tempList));
            return;
        }

        // 開始的邊界？
        for(int i = start; i < nums.length; i++) {
            int num = nums[i];
            if(tempList.contains(num)) {
                continue;
            }
            // 去重
            if(tempList.size() > 0 && num < tempList.get(tempList.size()-1)) {
                continue;
            }

            // 剪枝。数字严格递增
            if(remain < num) {
                break;
            }

            tempList.add(num);
            remain -= num;
            backtrack(results, tempList, nums, k, remain, start+1);

            // 回溯
            tempList.remove(tempList.size()-1);
            remain += num;
        }
    }

}
