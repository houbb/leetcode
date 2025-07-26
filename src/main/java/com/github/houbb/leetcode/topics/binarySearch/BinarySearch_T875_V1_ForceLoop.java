package com.github.houbb.leetcode.topics.binarySearch;

import java.math.BigInteger;
import java.util.Arrays;

public class BinarySearch_T875_V1_ForceLoop {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int minVal = 1;
        int maxVal = piles[piles.length-1];
        for(int speed = minVal; speed <= maxVal; speed++) {
            // 总的耗时
            long totalCost = 0;
            for(int pile : piles) {
                long num = pile / speed;
                // 不整除
                if(pile % speed != 0) {
                    num++;
                }
                totalCost += num;
            }
            if(totalCost <= h) {
                return speed;
            }
        }
        return -1;
    }

}
