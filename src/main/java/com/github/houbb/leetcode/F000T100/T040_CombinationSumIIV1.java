package com.github.houbb.leetcode.F000T100;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T040_CombinationSumIIV1 {

    public static void main(String[] args) {
//        T040_CombinationSumIIV1 v1 = new T040_CombinationSumIIV1();

//        System.out.println(v1.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));;

        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.asList(1,2,5));

        System.out.println(contains(results, Arrays.asList(2,1,5)));
    }

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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 存放使用后的数字
        boolean[] used = new boolean[candidates.length];

        List<List<Integer>> results = new ArrayList<>();
        // 核心算法
        backtrack(used,new ArrayList<>(), results, candidates, target, 0);

        // 统一移除
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> result : results) {
            if(!contains(ans, result)) {
                ans.add(result);
            }
        }
        return ans;
    }

    /**
     * 回溯算法
     * @param used 使用的数字集合
     * @param results 结果
     * @param candidates 候选数组
     * @param remain 剩余值
     * @param begin 开始索引
     */
    private void backtrack(boolean[] used,
                           List<Integer> tempList,
                           List<List<Integer>> results,
                           int[] candidates, int remain, int begin) {
        if(remain < 0) {
            return;
        } else if(remain == 0) {
            results.add(new ArrayList<>(tempList));
        } else {
            // 核心处理
            for(int i = begin; i < candidates.length; i++) {
                int current = candidates[i];
                // 避免元素被重复使用
                if(used[i]) {
                    continue;
                }

                tempList.add(current);
                used[i] = true;

                backtrack(used, tempList, results, candidates, remain-current, i+1);

                used[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private static boolean contains(List<List<Integer>> results,
                             List<Integer> targetList) {
        // 避免修改原始数据
        List<Integer> tempList = new ArrayList<>(targetList);
        for (List<Integer> list : results) {
            // 长度相同
            if(isSameCollection(list, tempList)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSameCollection(List<Integer> list,
                                     List<Integer> tempList) {
        if(list.size() != tempList.size()) {
            return false;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            int countFirst = countMap.getOrDefault(list.get(i), 0) + 1;
            countMap.put(list.get(i), countFirst);

            int countTemp = countMap.getOrDefault(tempList.get(i), 0) -1;
            countMap.put(tempList.get(i), countTemp);
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }


}
