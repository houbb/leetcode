package com.github.houbb.leetcode.F100T200;

import java.math.BigDecimal;

public class T172_FactorialTrailingZeroesV2 {

    public static void main(String[] args) {
        T172_FactorialTrailingZeroesV2 factorialTrailingZeroes = new T172_FactorialTrailingZeroesV2();

        System.out.println(factorialTrailingZeroes.trailingZeroes(7));
    }

    /**
     * 末尾零的个数
     *
     * 1. 计算 n!
     * 2. 倒序计算
     *
     * 2 * 5 = 0;
     * 偶数是一定存在的，所以只需要看有多少个 5 就行。
     *
     * 比如 500
     *
     * 500 / 5 = 100
     * 100 / 5 = 20
     * 20 / 5 = 4
     *
     * 共计：124 个 0
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }

}
