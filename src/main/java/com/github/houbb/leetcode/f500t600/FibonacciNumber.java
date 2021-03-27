package com.github.houbb.leetcode.f500t600;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class FibonacciNumber {

    public int fib(int n) {
        if(n <= 1) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

}
