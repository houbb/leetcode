package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T042_TrappingRainWaterV4 {

    public static void main(String[] args) {
        T042_TrappingRainWaterV4 v1 = new T042_TrappingRainWaterV4();

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
     * 优化思路：首先把每一位的高度处理好，通过 dp 递推。
     *
     * @param height 高度
     * @return 结果
     */
    public int trap(int[] height) {
        int len = height.length;
        int left = 1;
        int right = len - 2;
        int leftMax = 0;
        int rightMax = len - 1;

        int res = 0;

        while(left <= right){
            //比较
            if(height[leftMax] < height[rightMax]){
                if(height[leftMax] > height[left]){
                    res += height[leftMax] - height[left];
                }else{
                    leftMax = left;
                }
                left++;
            }else{
                if(height[rightMax] > height[right]){
                    res += height[rightMax] - height[right];
                }else{
                    rightMax = right;
                }
                right--;
            }
        }

        return res;
    }

}
