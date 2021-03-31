package com.github.houbb.leetcode.F300T400;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class TopKFrequentElementsTreeMap {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] results = TopKFrequentElementsTreeMap.topKFrequent(nums, k);

        System.out.println(Arrays.toString(results));
    }

    /**
     * 最直接的思路：
     *
     * （1）O(n) 遍历统计所有元素出现的次数
     * （2）排序找到 topk 的元素
     * （3）根据次数，返回结果
     *
     * Runtime: 9 ms, faster than 84.95% of Java online submissions for Top K Frequent Elements.
     * Memory Usage: 41.5 MB, less than 62.33% of Java online submissions for Top K Frequent Elements.
     *
     * @param nums 原始数组
     * @param k 个数
     * @return 结果
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // 次数统计
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for(int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
        }

        TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 次數的在前面
                return o2 - o1;
            }
        });

        // 设置次数（因为结果唯一，实际上次数并不唯一，可能相同。比如 [1,2]，返回2）
        // 如果次数相同，会导致覆盖。
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            // 次数 - 元素
            int times = entry.getValue();
            List<Integer> list = sortedMap.getOrDefault(times, new ArrayList<>());
            list.add(entry.getKey());
            sortedMap.put(entry.getValue(), list);
        }

        // 返回前 k 个
        int[] results = new int[k];
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
            for(Integer integer : entry.getValue()) {
                if(index >= k) {
                    break;
                }
                results[index++] = integer;
            }
        }

        return results;
    }

}
