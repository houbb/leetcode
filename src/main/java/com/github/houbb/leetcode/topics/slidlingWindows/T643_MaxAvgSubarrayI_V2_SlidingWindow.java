package com.github.houbb.leetcode.topics.slidlingWindows;

public class T643_MaxAvgSubarrayI_V2_SlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        double maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            // 进入窗口
            sum += nums[i];

            // 窗口是否已满足条件。等于 k-1 的时候，下次迭代，刚好 k 个元素
            if(i < k - 1) {
                continue;
            }

            // 逻辑处理
            maxSum = Math.max(sum, maxSum);


            // 出窗口
            sum -= nums[i-k+1];
        }

        return sum / k;
    }

}
