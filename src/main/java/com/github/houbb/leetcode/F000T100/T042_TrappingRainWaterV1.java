package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T042_TrappingRainWaterV1 {

    public static void main(String[] args) {
        T042_TrappingRainWaterV1 v1 = new T042_TrappingRainWaterV1();

        int trap2 = v1.trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap2);
    }

    /**
     * 计算
     *
     * 1. 计算 i 位置，左右两边的高度
     *
     * 2. 累加每一列的信息
     *
     * @param height 高度
     * @return 结果
     */
    public int trap(int[] height) {
        int n = height.length;

        // 第一个，最后一列不用看。
        int sum = 0;
        for(int i = 1; i < n-1; i++) {
            int hl = getMaxHeight(height, 0, i-1);
            int hr = getMaxHeight(height, i+1, n-1);

            int h = Math.min(hl, hr);
            if(height[i] < h) {
                sum += (h - height[i]);
            }
        }
        return sum;
    }

    private int getMaxHeight(int[] height,
                          int startIndex,
                          int endIndex) {
        int res = 0;
        for(int i = startIndex; i <= endIndex; i++) {
            res = Math.max(res, height[i]);
        }

        return res;
    }


}
