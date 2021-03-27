package com.github.houbb.leetcode.f500t600;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class FibonacciNumberDp {

    public int fib(int n) {
        if(n <= 1) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
