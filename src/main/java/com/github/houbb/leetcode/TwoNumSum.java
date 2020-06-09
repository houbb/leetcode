package com.github.houbb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class TwoNumSum {

    /**
     * 给定一个数组，一个结果。可以确切的返回对应的2个数
     * 要求：每一个元素只能被使用一次。
     *
     * 1. 最简单的思路
     *
     * 穷举：从第一个元素开始，后续的每一个元素进行遍历。（O(n^2)）
     * 这肯定是一种比较低效的算法
     *
     * 内存：节约内存，暂时使用一个数组。
     *
     *
     * 结果：
     *
     * Runtime: 167 ms, faster than 5.01% of Java online submissions for Two Sum.
     * Memory Usage: 41.3 MB, less than 10.92% of Java online submissions for Two Sum.
     *
     * @param nums 数组
     * @param target 目标值
     * @return 结果
     * @since 1.0.0
     * @date 2020-6-9 10:50:31
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                // 每个元素只使用一次
                if(i == j) {
                    continue;
                }

                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // 实际每个都有答案，不应该都到这里。
        return null;
    }

    /**
     * 优化思路：
     * 查找元素，从 O(n) 的遍历，改进为使用 Map
     *
     * 参考：https://leetcode.com/problems/two-sum/discuss/3/Accepted-Java-O(n)-Solution
     *
     * 效果：
     * 初始化 size=一半
     * Runtime: 3 ms, faster than 51.26% of Java online submissions for Two Sum.
     * Memory Usage: 39.9 MB, less than 32.64% of Java online submissions for Two Sum.
     *
     * 初始化 size=length
     * Runtime: 1 ms, faster than 99.93% of Java online submissions for Two Sum.
     * Memory Usage: 39.5 MB, less than 69.35% of Java online submissions for Two Sum.
     *
     * @param nums 数组
     * @param target 目标值
     * @return 结果
     * @since 1.0.0
     * @date 2020-6-9 11:11:38
     */
    public int[] twoSumWithHashMap(int[] nums, int target) {
        int[] result = new int[2];

        // 初始化大小
        // 如果考虑到大小和内存的平衡，考虑到扩容。
        final int length  = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for(int i = 0; i < length; i++) {
            int num = nums[i];
            int targetKey = target - num;
            if (map.containsKey(targetKey)) {
                result[1] = i;
                result[0] = map.get(targetKey);
                return result;
            }

            map.put(num, i);
        }

        return result;
    }

}
