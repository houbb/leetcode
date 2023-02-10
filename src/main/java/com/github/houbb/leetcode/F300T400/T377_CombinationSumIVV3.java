package com.github.houbb.leetcode.F300T400;

import java.util.Arrays;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T377_CombinationSumIVV3 {

    /**
     * backtrack + cache
     * @param candidates
     * @param target
     * @return
     */
    public int combinationSum4(int[] candidates, int target) {
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);

        return backtrack(candidates, target, cache);
    }

    private int backtrack(int[] candidates, int target, int[] cache) {
        // 缓存
        if(cache[target] != -1) {
            return cache[target];
        }

        //3. Our goal: when currentSum = target
        if (0 == target) {
            return 1;
        }

        int res = 0;
        //1. Our choices: We can choose a number from the list any number of times and all the numbers
        for (int i = 0; i < candidates.length; i++) {
            //Our constraints : We can't go beyond target, we can take more element than available in array
            int num = candidates[i];
            if (target - num >= 0) {
                target -= num;

                res += backtrack(candidates, target, cache);

                //backtrack
                target += num;
            }
        }

        // 存放缓存
        cache[target] = res;
        return res;
    }

}
