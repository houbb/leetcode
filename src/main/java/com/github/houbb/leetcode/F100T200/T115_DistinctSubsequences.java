package com.github.houbb.leetcode.F100T200;

public class T115_DistinctSubsequences {

    /**
     * 思路：
     *
     * 1. 最简单的，t.len > s.len, 0
     * 2. t.len = s.len 对比二者是否相同
     * 3. t.len > s.len，怎么处理比较简单？
     *
     * 3.1 首先找到第一个相同的字符。
     * 3.2 然后寻找第二个相同的字符
     * 。。。
     * 3.n 到 s 的结尾则终止，长度一致，则符合。
     *
     *
     * 【问题的拆分】
     *
     * 1. 发现第一个相同的字符
     * 2. 剩下的就是一个子串，然后再前面的部分中，问题同1.
     *
     * 所以，这个问题可以用递归处理。
     *
     * 【性能改良】
     *
     * 这里存在的问题：就是 DP？要可以复用以前的结果，不然数量一多，直接爆炸。
     *
     * 采用 BIT 运算加速？
     *
     * 一共只有 26 个字母，还是 52 个字母?
     *
     * 【赖皮算法】
     * 1. s+t 作为 key, 结果作为 value
     *
     * 不过这个没有实际意义。
     *
     * @param s 原始
     * @param t 目标
     * @return 结果
     */
    public int numDistinct(String s, String t){
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = t.length(); j >= 1; j--) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[t.length()];
    }

}
