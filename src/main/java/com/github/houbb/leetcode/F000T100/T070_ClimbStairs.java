package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T070_ClimbStairs {

    // 如果为1，只有1中
    // 如果为2，则有 11 或者 2
    // 如果为3  111 12 21
    // 如果为4  1111 112 121 211 22
    // 地推公式：dp[i] = dp[i-1] + dp[i-2];
    // 有两种方式：第一次走一步；第一次走两步。
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

    public int climbStairs2(int n) {
        int pre = 1;
        if(n <= 1) {
            return pre;
        }
        int current = 2;

        for(int i = 2; i < n; i++) {
            int temp = current;
            current += pre;
            pre = temp;
        }

        return current;
    }

    public static void main(String[] args) {
        T070_ClimbStairs climbStairs = new T070_ClimbStairs();

        System.out.println(climbStairs.climbStairs2(1));
        System.out.println(climbStairs.climbStairs2(2));
        System.out.println(climbStairs.climbStairs2(3));
        System.out.println(climbStairs.climbStairs2(4));
        System.out.println(climbStairs.climbStairs2(5));
    }

}
