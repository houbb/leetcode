package com.github.houbb.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class PermutationsII {

    /**
     * 解题思路：回溯算法
     *
     * 【优化思路】
     * 避免数组扩容
     *
     * @param nums 数字
     * @return 结果
     * @since v46
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        // 这个个数实际上可以预测：就是 nums ! 阶乘。
        // 实测优化效果不明显
        final int len = nums.length;
        List<List<Integer>> results = new ArrayList<>();

        boolean[] used = new boolean[len];
        // 避免扩容
        List<Integer> tempList = new ArrayList<>(len);
        backtrack(results, tempList, nums, used);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> tempList, int[] nums,
                           boolean[] used) {
        // 什么时候停止
        final int len = nums.length;
        if(tempList.size() == len) {
            results.add(new ArrayList<>(tempList));
        } else {
            // 回溯
            for (int i = 0; i < len; i++) {
                // 已经被使用的，不能重复使用。
                // 如果没有重复的元素，这样就要够了
                if(used[i]) {
                    continue;
                }

                // 如果有重复的元素，就会导致重复。（需要数组进行排序）
                // 1_a 1_b 2   第一次 1_a 1_b 2
                // 如果出现 1_b 1_a 2 实际上就重复了。（需要跳过的 case）
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                    continue;
                }

                int current = nums[i];
                tempList.add(current);
                used[i] = true;

                // 下一个元素
                backtrack(results, tempList, nums, used);

                // 回溯
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        PermutationsII permutations = new PermutationsII();

        int[] nums = new int[]{1,2,3};
        System.out.println(permutations.permuteUnique(nums));

        int[] nums2 = new int[]{1,1,2};
        System.out.println(permutations.permuteUnique(nums2));
    }

}
