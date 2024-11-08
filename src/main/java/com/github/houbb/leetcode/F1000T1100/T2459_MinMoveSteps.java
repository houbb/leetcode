package com.github.houbb.leetcode.F1000T1100;

public class T2459_MinMoveSteps {

    public static int sortArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = (nums[i] - 1 + n) % n;
        }
        int a = f(nums, 0);
        int b = f(arr, n - 1);
        return Math.min(a, b);
    }

    private static int f(int[] nums, int k) {
        boolean[] vis = new boolean[nums.length];
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == nums[i] || vis[i]) {
                continue;
            }
            ++cnt;
            int j = nums[i];
            while (!vis[j]) {
                vis[j] = true;
                ++cnt;
                j = nums[j];
            }
        }
        if (nums[k] != k) {
            cnt -= 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 0, 3, 1};
        System.out.println(sortArray(nums1)); // 输出: 3

        int[] nums2 = {1, 2, 3, 4, 0};
        System.out.println(sortArray(nums2)); // 输出: 0

        int[] nums3 = {1, 0, 2, 4, 3};
        System.out.println(sortArray(nums3)); // 输出: 2
    }

}
