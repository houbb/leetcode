package com.github.houbb.leetcode.F100T200;

import java.math.BigDecimal;

public class T172_FactorialTrailingZeroes {

    public static void main(String[] args) {
        T172_FactorialTrailingZeroes factorialTrailingZeroes = new T172_FactorialTrailingZeroes();

        System.out.println(factorialTrailingZeroes.trailingZeroes(7));
    }

    /**
     * 末尾零的个数
     *
     * 1. 计算 n!
     * 2. 倒序计算
     *
     * 326 / 500
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        //o(n) 遍历
        String result = calcResult(n);

        int count = 0;
        for(int i = result.length()-1; i >= 0; i--) {
            if(result.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    /**
     * 首先计算 n!
     * @param n
     * @return
     */
    private String calcResult(int n) {
        BigDecimal result = BigDecimal.ONE;

        while (n > 1) {
            result = result.multiply(BigDecimal.valueOf(n));
            n--;
        }

        return result.toString();
    }


}
