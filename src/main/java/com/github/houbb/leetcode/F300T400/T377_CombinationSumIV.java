package com.github.houbb.leetcode.F300T400;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T377_CombinationSumIV {

    int count = 0;

    public int combinationSum4(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return count;
    }

    /**
     * 回溯算法
     * @param candidates 候选数组
     * @param remain 剩余值
     */
    private void backtrack(int[] candidates,
                           int remain,
                           int begin) {
        // 剪枝
        if(remain < 0) {
            return;
        } else if(remain == 0) {
            count++;
        } else {
            // 核心处理。数据允许重复，不同的排列视为不同的解
            for(int i = 0; i < candidates.length; i++) {
                int current = candidates[i];
                backtrack(candidates, remain-current, begin + 1);
            }
        }
    }

}
