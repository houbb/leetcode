package com.github.houbb.leetcode.topics.array;

public class T41_firstMissingPositive_v2_Swap {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    // 这一题大概率是数字哈希来解决
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 把数字放在合适的位置上
        for(int i = 0; i < n; i++) {
            // 不断的交换，直到满足为止
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 再次判断一次
        for(int i = 0; i < n; i++) {
            // 不在合适的位置上
            if(nums[i] != i+1) {
                return i+1;
            }
        }

        return n+1;
    }


}
