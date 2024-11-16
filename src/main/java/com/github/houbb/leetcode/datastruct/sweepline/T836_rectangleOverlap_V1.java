package com.github.houbb.leetcode.datastruct.sweepline;

public class T836_rectangleOverlap_V1 {

    public static void main(String[] args) {
        T836_rectangleOverlap_V1 v1 = new T836_rectangleOverlap_V1();
        System.out.println(v1.isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20}));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 判断 x 轴和 y 轴投影是否有交集
        boolean xOverlap = rec1[2] > rec2[0] && rec1[0] < rec2[2];
        boolean yOverlap = rec1[3] > rec2[1] && rec1[1] < rec2[3];

        // 两个投影都有交集才算重叠
        return xOverlap && yOverlap;
    }

}
