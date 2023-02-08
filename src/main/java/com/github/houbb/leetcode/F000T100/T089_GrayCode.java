package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T089_GrayCode {

    /**
     * 實現思路：
     *
     * 説白了，就是一道二進制轉換的題目。
     *
     * 簡化：0 - 全1，中間所有的整數列表即可。
     *
     * 首先全部都是 0，然後開始轉換爲十進制。
     *
     * n = 1
     *
     * 0
     * 1
     *
     * n=2
     *
     * 0 0
     * 0 1
     * 1 1
     * 1 0
     *
     * n=3
     *
     * 0 0 0
     * 0 0 1
     * 0 1 1
     * 0 1 0
     * 1 1 0
     * 1 1 1
     * 1 0 1
     * 1 0 0
     *
     * 就是在上一層的基礎上，在最前面加上 0 1
     *
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        int max = 1 << n;
        List<Integer> nums = new ArrayList<>(max);
        for(int i = 0; i < max; i++) {
            // 格雷碼的計算方式
            nums.add(i ^ i>>1);
        }
        return nums;
    }

}
