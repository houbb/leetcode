package com.github.houbb.leetcode.datastruct.array;

public class T287_findDuplicate_V5_Floyd {

    public int findDuplicate(int[] nums) {
        // 二者从开始一起走
        int slow = nums[0];
        int fast = nums[0];

        // 第一次相遇
        do {
            // 一步
            slow = nums[slow];

            // 走两步
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);


        // 第二步：从起点和相遇点出发，再次相遇就是“环的入口”==重复的数
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


}
