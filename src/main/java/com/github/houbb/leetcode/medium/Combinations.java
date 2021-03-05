package com.github.houbb.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class Combinations {

    /**
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        // 这是一道回溯的算法。
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>(k);

        backtrack(results, tempList, n, k, 1);

        return results;
    }


    private void backtrack(List<List<Integer>> results, List<Integer> tempList,
                           int n, int k, int start) {
        // 剪枝算法：效果是非常显著的。
        // 如果后面的元素个数已经不够 k 个了，直接返回。
        if (tempList.size() + n - start + 1 < k) {
            return;
        }

        // 终止条件
        if(tempList.size() == k) {
            results.add(new ArrayList<>(tempList));
        }

        // 从第一个元素开始
        // 这个操作是从前向后的，所以前面的元素不会被重复处理。
        for(int i = start; i <= n; i++) {
            tempList.add(i);

            // 从下一个元素开始，不可重复
            backtrack(results, tempList, n, k, i+1);

            // 回溯
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));;
    }

}
