package com.github.houbb.leetcode.datastruct.array;

public class T137_SingleNumberII_V3_BitOperator {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // 更新 twos 和 ones
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones; // ones 中的数字就是只出现一次的数字
    }

}
