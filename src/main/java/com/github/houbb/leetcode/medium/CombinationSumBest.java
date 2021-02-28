package com.github.houbb.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class CombinationSumBest {

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
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), 0, results);
        return results;
    }

    private void backtrack(int[] candidates, int remain, List<Integer> tempList,
                          int begin, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 这里实际上优化了 2 步：
            // 1. candidates 排序并不是必须的
            // 2. 单次回溯，根据大小判断，避免一次减法+大小比较
            int current = candidates[i];
            if (remain >= current) {
                tempList.add(current);
                // 元素可以重复使用，所以取 i
                backtrack(candidates, remain - current, tempList, i, results);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[] candidates = {2,3,4,7};
        int[] candidates = {3, 7, 2, 4};
        int target = 4;

        CombinationSumBest best = new CombinationSumBest();
        System.out.println(best.combinationSum(candidates, target));
    }

}
