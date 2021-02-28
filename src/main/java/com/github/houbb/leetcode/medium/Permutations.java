package com.github.houbb.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class Permutations {

    /**
     * 解题思路：回溯算法
     *
     * 【优化思路】
     * 避免数组扩容
     *
     * 使用 boolean 数组，而不是 contains
     *
     * @param nums 数字
     * @return 结果
     * @since v46
     */
    public List<List<Integer>> permute(int[] nums) {
        // 这个个数实际上可以预测：就是 nums ! 阶乘。
        // 实测优化效果不明显
        final int len = nums.length;
        List<List<Integer>> results = new ArrayList<>();

        // 避免扩容
        List<Integer> tempList = new ArrayList<>(len);
        backtrack(results, tempList, nums);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> tempList, int[] nums) {
        // 什么时候停止
        final int len = nums.length;
        if(tempList.size() == len) {
            results.add(new ArrayList<>(tempList));
        } else {
            // 回溯
            for (int current : nums) {
                // 元素不能重复
                if (tempList.contains(current)) {
                    continue;
                }

                tempList.add(current);

                // 下一个元素
                backtrack(results, tempList, nums);

                // 回溯
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * 计算阶乘
     *
     * 目的：避免结果扩容
     *
     * 题目中只有 1-6，可以使用查表法
     * @param num 数字
     * @return 结果
     */
    private static int getFactorial(int num) {
        int result = 1;

        for(int i = 2; i <= num; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(3));

        Permutations permutations = new Permutations();

        int[] nums = new int[]{1,2,3};
        System.out.println(permutations.permute(nums));
    }

}
