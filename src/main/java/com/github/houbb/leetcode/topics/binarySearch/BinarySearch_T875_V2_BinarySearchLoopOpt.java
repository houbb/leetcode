package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T875_V2_BinarySearchLoopOpt {

    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for(int pile : piles) {
            right = Math.max(pile, right);
        }
        int left = 1;

        while (left <= right) {
            // 避免越界
            int mid = left + (right-left) / 2 ;

            // 计算总的耗时
            // 总的耗时
            long totalCost = 0;
            for(int pile : piles) {
                long num = (pile + mid - 1) / mid;
                totalCost += num;

                if (totalCost > h) break; // 剪枝
            }

            // 要求的 h 内的最小值，所以不应该是 ==h
            if(totalCost <= h) {
                right = mid-1;
            } else {
                // 慢了
                left = mid+1;
            }
        }

        // 最后的值？
        return left;
    }

}
