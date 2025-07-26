package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T875_V3_BinarySearchRecursive {

    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for(int pile : piles) {
            right = Math.max(pile, right);
        }
        int left = 1;

        return minEatingSpeedRecursive(piles, h, left, right);
    }

    public int minEatingSpeedRecursive(int[] piles, int h, int left, int right) {
        // 终止条件？
        if(left > right) {
            return left;
        }

        // 避免越界
        int mid = left + (right-left) / 2;

        // 计算总的耗时
        long totalCost = 0;
        for(int pile : piles) {
            long num = (pile + mid - 1) / mid;
            totalCost += num;

            if (totalCost > h) break; // 剪枝
        }

        // 要求的 h 内的最小值，所以不应该是 ==h
        if(totalCost <= h) {
            // 在左侧
            return minEatingSpeedRecursive(piles, h, left, mid-1);
        } else {
            // 慢了 去速度的右侧
            return minEatingSpeedRecursive(piles, h, mid+1, right);
        }
    }

}
