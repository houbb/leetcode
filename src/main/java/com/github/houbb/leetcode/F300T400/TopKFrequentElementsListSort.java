package com.github.houbb.leetcode.F300T400;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class TopKFrequentElementsListSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] results1 = TopKFrequentElementsListSort.topKFrequent(nums, 1);
        int[] results2 = TopKFrequentElementsListSort.topKFrequent(nums, 2);
        int[] results3 = TopKFrequentElementsListSort.topKFrequent(nums, 3);

        System.out.println(Arrays.toString(results1));
        System.out.println(Arrays.toString(results2));
        System.out.println(Arrays.toString(results3));
    }

    /**
     * 最直接的思路：
     *
     * （1）O(n) 遍历统计所有元素出现的次数
     * （2）排序找到 topk 的元素
     * （3）根据次数，返回结果
     *
     * Runtime: 10 ms, faster than 64.94% of Java online submissions for Top K Frequent Elements.
     * Memory Usage: 41.6 MB, less than 62.33% of Java online submissions for Top K Frequent Elements.
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
        List<Integer> countList = new ArrayList<>(countMap.values());
        countList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 倒排，次数多的放在前面
                return o2 - o1;
            }
        });
        // 1 2 3  TOP3 就是对应最后一个
        int countLimit = countList.get(k - 1);
        // 5 4 3 2 1

        int[] results = new int[k];
        int resultIndex = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int numCount = entry.getValue();

            if(numCount >= countLimit) {
                results[resultIndex++]  = num;
            }
        }

        return results;
    }

}
