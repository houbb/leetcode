package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T135_CandyV3 {

    /**
     * 思路：TWO-PASS
     *
     * 从前往后：如果右边的比左边大，则为左边+1。
     *
     * 从后往前：如果左边的比右边权重大，但是糖果却少，进行修正。
     *
     * @param ratings 比例
     * @return 结果
     */
    public int candy(int[] ratings) {
        // 存放糖果数量
        int[] candies = new int[ratings.length];
        // 至少有一个
        Arrays.fill(candies, 1);

        // 从前往后遍历
        // 和左边比
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        // 从后往前遍历
        // 和右边比，但是糖果缺少
        for(int i = ratings.length-2; i >=0; i--) {
            if((ratings[i] > ratings[i+1])
                && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }

        // 累加结果
        int sum = 0;
        for(int i = 0; i < ratings.length; i++) {
            sum += candies[i];
        }

        return sum;
    }

}
