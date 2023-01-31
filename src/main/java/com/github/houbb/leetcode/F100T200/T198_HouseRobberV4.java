package com.github.houbb.leetcode.F100T200;

public class T198_HouseRobberV4 {

    public int rob(int[] nums) {
        int pre1 = 0;
        int pre2 = 0;

        for(int val : nums) {
            int temp = pre1;
            pre1 = Math.max(pre1, pre2+val);
            pre2 = temp;
        }

        return pre1;
    }

}
