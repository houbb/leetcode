package com.github.houbb.leetcode.datastruct.array;

import java.util.HashSet;
import java.util.Set;

public class T136_SingleNumber_V3_BitOperator {

    /**
     * 异或的性质是：相同的数字异或结果为 0，0 和任何数字异或结果为该数字本身。
     * 所以异或所有元素，最后的结果就是那个只出现一次的数字。
     */
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int num : nums){
            result ^= num;
        }

        return result;
    }

}
