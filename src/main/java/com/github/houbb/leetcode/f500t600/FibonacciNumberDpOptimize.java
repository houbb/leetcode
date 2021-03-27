package com.github.houbb.leetcode.f500t600;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class FibonacciNumberDpOptimize {

    public static int fib(int n) {
        if(n <= 1) {
            return n;
        }

        int pre = 0;
        int current = 1;

        for(int i = 2; i <= n; i++) {
            int temp = current;
            current = pre + current;
            pre = temp;
        }

        return current;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

}
