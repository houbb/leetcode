package com.github.houbb.leetcode.topics.bit;

/**
 * 一个普通人还能想到的版本
 *
 */
public class SingleNumberII_V3_BitOperatorCommon_137 {

    public int singleNumber(int[] nums) {
        int[] bits = new int[32];

        // 统计1的个数
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                // 这里如果希望获取每一位的是否为1，应该右移
                int bit = (num >> i) & 1;
                // 增加1的个数
                if(bit != 0) {
                    bits[i] = bits[i] + 1;
                }
            }
        }

        // 反推出这个数
        int result = 0;
        for(int i = 0; i < 32; i++) {
            if(bits[i] % 3 != 0) {
                // 左移反向复现原来的数字
                result |= (1 << i);
            }
        }

        return result;
    }

}
