package com.github.houbb.leetcode.topics.slidlingWindows;

public class T643_MaxAvgSubarrayI_V3_PrefixSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        // 前缀和 好处是2个坐标直接可以减，得到差值
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }

        // 好处是，我们可以计算任何两个范围的值的和
        double max = Integer.MIN_VALUE;
        for(int i = 0; i <= nums.length - k; i++) {
            int sum = prefixSum[i+k] - prefixSum[i];
            double tempMax = sum * 1.0/ k ;
            max = Math.max(tempMax, max);
        }

        return max;
    }

}
