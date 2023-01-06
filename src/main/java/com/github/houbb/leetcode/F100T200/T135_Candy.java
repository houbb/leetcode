package com.github.houbb.leetcode.F100T200;

public class T135_Candy {

    /**
     * 思路：
     *
     * 从左往右，或者反过来应该是一样的。
     *
     * 1. 从左边第一个开始，第一个应该是多少呢？
     *
     * 最左边的好处是，左边没有孩子。所以只需要看左边第二个。右边有几个情况
     *
     * 1.1 第二个大于等于左边，则 0 位的孩子 1 个糖果即可。
     *
     * 1.2 第二个小于左边，则 0 位的孩子必须大于 1 位的。
     *
     * 但是 1 位的如何判断呢？
     *
     * 这是一个递归？后续用 dp 优化。
     *
     *
     * @param ratings 比例
     * @return 结果
     */
    public int candy(int[] ratings) {
        int sum = 0;

        for(int i = 0; i < ratings.length; i++) {
            sum += getMinCandy(i, ratings);
        }

        return sum;
    }

    /**
     * 获取当前位置，最少给几个糖果
     * @param i 下标
     * @param rating 权重
     * @return 结果
     */
    private int getMinCandy(int i, int[] rating) {
        int minLeft = 0;
        int minRight = 0;

        // 和左边对比，如果比左边大，则取左边
        if(i > 0 && (rating[i] > rating[i-1])) {
            minLeft = getMinCandy(i-1, rating);
        }

        // 和右边对比，如果比右边大，则取右边
        if(i < rating.length-1 && (rating[i] > rating[i+1])) {
            minRight = getMinCandy(i+1, rating);
        }

        // 左右对比之后，选择最大的。然后 + 1
        return Math.max(minLeft, minRight) + 1;
    }

}
