package com.github.houbb.leetcode.F1000T1100;

public class T2459_MinMoveSteps_V2 {

    public static int minMovesToSort(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int moves = 0;
        if(isSorted(nums)) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] || nums[i] == i) {
                continue; // 如果元素已经在正确位置，或者已经访问过，则跳过
            }
            // 开始计算环的大小
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = nums[j]; // 跳到当前元素应该在的位置
                cycleSize++;
            }
            // 每个环的操作数是环的大小 - 1
            if (cycleSize > 0) {
                moves += cycleSize - 1;
            }
        }
        return moves;
    }

    // 判断数组是否已经排序
    private static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 0, 3, 1};
        System.out.println(minMovesToSort(nums1)); // 输出: 3

        int[] nums2 = {1, 2, 3, 4, 0};
        System.out.println(minMovesToSort(nums2)); // 输出: 0

        int[] nums3 = {1, 0, 2, 4, 3};
        System.out.println(minMovesToSort(nums3)); // 输出: 2
    }

}
