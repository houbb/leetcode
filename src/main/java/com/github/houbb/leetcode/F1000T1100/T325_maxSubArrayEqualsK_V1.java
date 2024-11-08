package com.github.houbb.leetcode.F1000T1100;

public class T325_maxSubArrayEqualsK_V1 {

    public static void main(String[] args) {
        T325_maxSubArrayEqualsK_V1 v1 = new T325_maxSubArrayEqualsK_V1();
        int[] nums1 = new int[]{1, -1, 5, -2, 3};
        assert 4 == v1.findMaxLength(nums1, 3);

        int[] nums2 = new int[]{-2, -1, 2, 1};
        assert 2 == v1.findMaxLength(nums2, 1);
    }

    public int findMaxLength(int[] nums, int k) {
        final int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        // 从大=>小遍历？
        for(int step = n-1; step >=1; step--) {
            int len = step+1;

            for(int i = 0; i < n - step; i++) {
                int next = i + step;
                int sum = prefix[next] - prefix[i] + nums[i];
                if(sum == k) {
                    return len;
                }
            }
        }
        return 0;
    }

}
