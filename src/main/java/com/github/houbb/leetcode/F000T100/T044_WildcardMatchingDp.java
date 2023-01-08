package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T044_WildcardMatchingDp {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        //后续 p 只要是 *，肯定也是 true
        for(int j = 0; j < p.length(); j++) {
            if(p.charAt(j) == '*') {
                // s 为空，p == * 的场景
                dp[0][j+1] = true;
            } else {
                // 终止
                break;
            }
        }

        // 处理逻辑
        // 从1开始，0 在 dp 中代表的是空初始化位置。
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                // 判断 *，两个场景满足一个皆可
                if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    // 此时就是普通的字符匹配，或者 p == ? 的 CASE
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?');
                }
            }
        }

        // 最后一个存储结果
        return dp[s.length()][p.length()];
    }

}
