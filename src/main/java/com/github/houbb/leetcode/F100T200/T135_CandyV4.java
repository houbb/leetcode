package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T135_CandyV4 {

    /**
     * 思路：ONE-PASS
     * <p>
     * 通过等差数列公式，有点难。
     *
     * @param ratings 比例
     * @return 结果
     */
    public int candy(int[] ratings) {
        int total = 1;
        int prev = 1;
        int countDown = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (countDown > 0) {
                    // arithmetic progression
                    total += countDown * (countDown + 1) / 2;
                    if (countDown >= prev) {
                        total += countDown - prev + 1;
                    }
                    countDown = 0;
                    prev = 1;
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                total += prev;
            } else {
                countDown++;
            }
        }
        // if we were descending at the end
        if (countDown > 0) {
            total += countDown * (countDown + 1) / 2;
            if (countDown >= prev) {
                total += countDown - prev + 1;
            }
        }
        return total;
    }

}
