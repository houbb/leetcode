package com.github.houbb.leetcode.medium;

/**
 * Similar questions:
 * 91. decode ways
 * 62. Unique Paths
 * 70. Climbing Stairs
 * 509. Fibonacci Number
 *
 * https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class DecodeWays {

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("16"));
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();

        // s[i] 为0，而且没有上一个元素。
        if(chars[0] == '0') {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len+1];
//        dp[-1] = dp[0] = 1
        // 为什么初始化为 1？？
        // 因为此时 chars[0] != '0'，所以 dp[0] = 1;
        // dp[-1] 这里也是1，纯粹是为了 dp[i-1] 时的推导。
        dp[0] = 1;
        dp[1] = 1;

        // 开始遍历
        for(int i = 1; i < len; i++) {
            //1. 如果当前元素为0
            if (chars[i] == '0') {
                //s[i - 1]等于1或2的情况
                if (chars[i - 1] == '1' || chars[i - 1] == '2') {
                    //由于s[1]指第二个下标，对应为dp[2],所以dp的下标要比s大1，故为dp[i+1]
                    dp[i+1] = dp[i-1];
                } else {
                    return 0;
                }
            } else {
                //s[i-1]s[i]两位数要小于26的情况
                if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                    dp[i+1] = dp[i]+dp[i-1];
                } else {
                    // 即当前状态值等于前一个状态
                    dp[i+1] = dp[i];
                }
            }
        }

        return dp[len];
    }


    public int numDecodings2(String string) {
        char[] s = string.toCharArray();
        if (s[0] == '0') {
            return 0;
        }

        int len = string.length();
        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < len; i++) {
            int tmp = curr;
            if (s[i] == '0') {
                if (s[i - 1] == '1' || s[i - 1] == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6')) {
                curr = curr + pre;
            }

            // 让上一个值迭代更新。
            pre = tmp;
        }
        return curr;
    }

}
