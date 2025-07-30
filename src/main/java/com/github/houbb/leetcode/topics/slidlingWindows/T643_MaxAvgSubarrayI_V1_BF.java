package com.github.houbb.leetcode.topics.slidlingWindows;

public class T643_MaxAvgSubarrayI_V1_BF {

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(findMaxAverage(nums, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length-k+1; i++) {
            double sum = 0;
            for(int j = i; j < i+k; j++) {
                sum += nums[j];
            }

            double tempMax = sum / k;
            if(tempMax - max > 0) {
                max = tempMax;
            }
        }

        return max;
    }

}
