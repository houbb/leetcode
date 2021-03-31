package com.github.houbb.leetcode.F300T400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
@Deprecated
public class TopKFrequentElementsMoerVote {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] results = TopKFrequentElementsMoerVote.topKFrequent(nums, k);

        System.out.println(Arrays.toString(results));
    }

    /**
     * 最直接的思路：
     *
     * （1）O(n) 遍历统计所有元素出现的次数
     * （2）排序找到 topk 的元素
     * （3）根据次数，返回结果
     *
     *
     * @param nums 原始数组
     * @param k 个数
     * @return 结果
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // 投票统计
        Map<Integer, Integer> voteMap = new HashMap<>(k);

        // 初始化
        int numFirst = nums[0];
        for(int i = 0; i < k; i++) {
            voteMap.put(numFirst, 1);
        }

        // 投票
        for(int num : nums) {

        }

        // 构建结果
        int[] results = new int[k];
        int resultIndex = 0;

        return results;
    }

}
