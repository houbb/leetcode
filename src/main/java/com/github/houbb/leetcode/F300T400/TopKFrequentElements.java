package com.github.houbb.leetcode.F300T400;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] results = TopKFrequentElements.topKFrequent(nums, k);

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
     * Memory Usage: 42.2 MB, less than 18.01% of Java online submissions for Top K Frequent Elements.
     *
     * @param nums 原始数组
     * @param k 个数
     * @return 结果
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // 参数校验
        if(nums == null || k <= 0) {
            return null;
        }

        // 次数统计
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for(int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
        }

        // 计算 topK 的次数
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(countMap.values());
        int minCount = 0;
        int times = priorityQueue.size() - k;
        for(int i = 0; i < times; i++) {
            minCount = priorityQueue.poll();
        }

        // 构建结果
        int[] results = new int[k];
        int resultIndex = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int numCount = entry.getValue();

            if(numCount > minCount) {
                results[resultIndex++]  = num;
            }
        }

        return results;
    }

}
