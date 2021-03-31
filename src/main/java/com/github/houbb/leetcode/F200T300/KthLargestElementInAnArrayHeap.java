package com.github.houbb.leetcode.F200T300;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class KthLargestElementInAnArrayHeap {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));

        int[] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums2, 4));
    }

    /**
     * Runtime: 1 ms, faster than 98.08% of Java online submissions for Kth Largest Element in an Array.
     * Memory Usage: 39.2 MB, less than 60.04% of Java online submissions for Kth Largest Element in an Array.
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最大堆，lambda 表达式应写成：(a, b) -> b - a
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> b - a);
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

}
