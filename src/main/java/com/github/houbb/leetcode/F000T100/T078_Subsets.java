package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(results, tempList, nums, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results,
                           List<Integer> tempList,
                           int[] nums,
                           int start) {
        results.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++) {
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
        T078_Subsets subsets = new T078_Subsets();
        int[] nums  = {1,2,3};
        System.out.println(subsets.subsets(nums));
    }

}
