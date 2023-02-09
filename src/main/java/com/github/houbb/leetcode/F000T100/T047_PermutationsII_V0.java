package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T047_PermutationsII_V0 {

    /**
     * 解题思路：回溯算法
     *
     * 1. 复用 T46 算法
     * 2. 统一过滤
     *
     * @param nums 数字
     * @return 结果
     * @since v46
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 这个个数实际上可以预测：就是 nums ! 阶乘。
        // 实测优化效果不明显
        final int len = nums.length;
        boolean[] used = new boolean[len];
        List<List<Integer>> results = new ArrayList<>();

        // 避免扩容
        List<Integer> tempList = new ArrayList<>(len);
        backtrack(results, tempList, nums, used);

        // 过滤重复的值
        return filter(results);
    }

    private void backtrack(List<List<Integer>> results, List<Integer> tempList, int[] nums,
                           boolean[] used) {
        // 什么时候停止
        final int len = nums.length;
        if(tempList.size() == len) {
            results.add(new ArrayList<>(tempList));
        } else {
            // 回溯
            for (int i = 0; i < nums.length; i++) {
                // 元素不能重复使用
                if (used[i]) {
                    continue;
                }

                tempList.add(nums[i]);
                used[i] = true;

                // 下一个元素
                backtrack(results, tempList, nums, used);

                // 回溯
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    private List<List<Integer>> filter(List<List<Integer>> all) {
        List<List<Integer>> results = new ArrayList<>();

        for(List<Integer> list : all) {
            if(!results.contains(list)) {
                results.add(list);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        T047_PermutationsII_V0 permutations = new T047_PermutationsII_V0();

        int[] nums = new int[]{1,2,3};
        System.out.println(permutations.permuteUnique(nums));
    }

}
