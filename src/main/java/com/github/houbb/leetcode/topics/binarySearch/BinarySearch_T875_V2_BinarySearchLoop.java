package com.github.houbb.leetcode.topics.binarySearch;

import java.util.Arrays;

public class BinarySearch_T875_V2_BinarySearchLoop {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length-1];

        while (left <= right) {
            // 避免越界
            int mid = left + (right-left) / 2 ;

            // 计算总的耗时
            // 总的耗时
            long totalCost = 0;
            for(int pile : piles) {
                long num = pile / mid;
                // 不整除
                if(pile % mid != 0) {
                    num++;
                }
                totalCost += num;
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
