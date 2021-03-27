package com.github.houbb.leetcode.f500t600;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class FibonacciNumberMath {

    private static final double FAC_ONE = 1 / Math.sqrt(5);
    private static final double FAC_TWO = 0.5 + Math.sqrt(5) / 2;
    private static final double FAC_THREE = 0.5 - Math.sqrt(5) / 2;

    public int fib(int n) {
        if(n <= 1) {
            return n;
        }

        return (int) (FAC_ONE * (Math.pow(FAC_TWO, n) - Math.pow(FAC_THREE, n)));
    }

}
