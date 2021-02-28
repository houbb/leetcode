package com.github.houbb.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class CombinationSumIIBest {

    /**
     * 思路：
     * （1）回溯
     * （2）剪枝算法优化
     *
     * @param candidates 候选集
     * @param target     目标值
     * @return 结果
     * @author https://github.com/houbb/
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 这个排序时必须的，用于去重
        Arrays.sort(candidates);

        List<List<Integer>> results = new ArrayList<>();
        // 核心算法
        backtrack(results, new ArrayList<>(), candidates, target, 0);

        return results;
    }

    /**
     * 回溯算法
     *
     * @param results    结果
     * @param tempList   临时列表
     * @param candidates 候选数组
     * @param remain     剩余值
     * @param begin      开始索引
     * @since v40
     */
    private void backtrack(List<List<Integer>> results, List<Integer> tempList,
                           int[] candidates, int remain, int begin) {
        if (remain == 0) {
            results.add(new ArrayList<>(tempList));
        } else {
            // 核心处理
            for (int i = begin; i < candidates.length; i++) {
                // 如何跳过重复的信息
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                int current = candidates[i];
                // 结束当前循环
                if (current > remain) {
                    break;
                }
                tempList.add(current);
                backtrack(results, tempList, candidates, remain - current, i + 1);

                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
