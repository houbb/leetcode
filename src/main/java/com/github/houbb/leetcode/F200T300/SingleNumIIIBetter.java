package com.github.houbb.leetcode.F200T300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SingleNumIIIBetter {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }

        // 获取非0位
        int bit = 1;
        while ((bit & xor) == 0) {
            bit <<= 1;
        }

        // 重新划分数组
        int a = 0;
        int b = 0;
        for(int num : nums) {
            if((num & bit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

}
