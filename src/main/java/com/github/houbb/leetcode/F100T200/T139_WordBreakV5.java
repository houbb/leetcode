package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T139_WordBreakV5 {

    public static void main(String[] args) {
        T139_WordBreakV5 wordBreak = new T139_WordBreakV5();


        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    /**
     * 思路：
     * 比如字符串 abcdef
     *
     * 1. 定义 dp[] 数组，标识 i 的位置是否支持拆分
     * 2. dp[0] = true。dp[0] 的元素 a，可以理解为 "" + a
     * 3. 从 i=1, i < n 遍历，然后对后面的字符串进行拆分
     *    拆分的时候复用 dp
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 初始化 dp[]
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        Set<String> wordSet = new HashSet<>(wordDict);
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                // s1 = substring(0, j) = dp[j]
                // s2 = substring(j, i) = s[j, i - 1]

                // 对前面的的每一个 subString 进行比较
                String subString = s.substring(j, i);
                if(dp[j] && wordSet.contains(subString)) {
                    // 这个位置断开，是可行的。
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
