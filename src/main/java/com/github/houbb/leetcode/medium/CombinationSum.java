package com.github.houbb.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class CombinationSum {

    /**
     * 思路：
     *
     * （1）回溯
     * （2）剪枝算法优化
     *
     * @author https://github.com/houbb/
     * @param candidates 候选集
     * @param target 目标值
     * @return 结果
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //1. 排序，是为了剪枝算法。实际不是必要的
//        Arrays.sort(candidates);

        List<List<Integer>> results = new ArrayList<>();
        // 核心算法
        backtrack(results, new ArrayList<>(), candidates, target, 0);

        return results;
    }

    /**
     * 回溯算法
     * @param results 结果
     * @param tempList 临时列表
     * @param candidates 候选数组
     * @param remain 剩余值
     * @param begin 开始索引
     * @since v38
     */
    private void backtrack(List<List<Integer>> results, List<Integer> tempList,
                           int[] candidates, int remain, int begin) {
        //1. 如果小于0，直接剪枝
        if(remain < 0) {
            return;
        } else if(remain == 0) {
            // 需要的结果（使用一个新的列表，而不是直接存放原始列表，否则数据会被更新）
            results.add(new ArrayList<>(tempList));
        } else {
            // 在所有的剩余集合中，选择信息
            for(int i = begin; i < candidates.length; i++) {
                // 放入目标元素
                tempList.add(candidates[i]);

                // 继续拆分剩余的集合组合
                // 从 第 i 个元素开始，因为允许重复使用
                backtrack(results, tempList, candidates, remain - candidates[i], i);

                // 回溯
                tempList.remove(tempList.size()-1);
            }
        }
    }

}
