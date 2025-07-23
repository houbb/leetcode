package com.github.houbb.leetcode.topics.bit;

public class SingleNumberIII_V2_BitOperator_260 {

    public int[] singleNumber(int[] nums) {
        // 找到整体的 xor
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 找到最低位的 mask
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((xor & mask) != 0) {  // 检查当前位是否为1
                break;  // 找到最低位的1，停止循环
            }
            mask <<= 1;  // 左移1位，检查下一位
        }

        // 分成2个组

        int a = 0;
        int b = 0;
        for(int num : nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        int[] results = new int[]{a, b};
        return results;
    }

}
