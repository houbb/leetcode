package com.github.houbb.leetcode;

/**
 * 万能动态规划环节
 *
 * <p> project: leetcode-RegularExpressionMatching </p>
 * <p> create on 2020/6/10 20:21 </p>
 *
 * @author binbin.hou
 * @since v3
 */
public class RegularExpressionMatchingDp {

    /**
     * 状态标识
     * @since v3
     */
    private enum Status {
        TRUE,
        FALSE,
        ;
    }

    private Status[][] statuses;

    /**
     * 动态规划核心思想：
     * 问题可以被分解子问题时。
     *
     *
     * @param s 字符串
     * @param p 模式
     * @return 结果
     * @since v3
     */
    public boolean isMatchDp(String s, String p) {
        // 初始化
        // 使用 Status 枚举是为了避免基本变量默认值的问题。
        // 为什么要+1？
        statuses = new Status[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }

    /**
     * 动态规划
     * @param i 文本下标
     * @param j 正则下标
     * @param s 文本
     * @param p 正则
     * @return 结果
     * @since v3
     */
    private boolean dp(int i, int j, String s, String p) {
        // 这个位的信息已经遍历过
        if(statuses[i][j] != null) {
            return statuses[i][j] == Status.TRUE;
        }

        // pattern 遍历完成，判断文本是否完成
        if(j >= p.length()) {
            return i == s.length();
        }

        // 判断 i，避免 s 越界。
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // 后续为 *
        boolean result = false;
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            result = (firstMatch && dp(i+1, j, s, p)) || dp(i, j+2, s, p);
        } else {
            result = firstMatch && dp(i+1, j+1, s, p);
        }

        // 存放中间结果
        statuses[i][j] = result ? Status.TRUE : Status.FALSE;
        return result;
    }

    /**
     * 是否匹配
     *
     * 从后往前遍历，这样可以更加优雅一点。
     * 不用关心默认值的问题。
     *
     * 【效果】
     * Runtime: 2 ms, faster than 92.84% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 38.3 MB, less than 73.31% of Java online submissions for Regular Expression Matching.
     *
     * @param s 文本
     * @param p 模式
     * @return 结果
     * @since v4
     */
    public boolean isMatch(String s, String p) {
        //dp 存放的是后面处理的结果
       boolean[][] dp = new boolean[s.length()+1][p.length()+1];
       dp[s.length()][p.length()] = true;

       for(int i = s.length(); i >= 0; i--) {
            for(int j = p.length()-1; j >= 0; j--) {
                // 核心代码保持不变
                // 这里不用判断是否为 empty 的问题
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

                // 判断星号
                if(j+1 < p.length() && p.charAt(j+1) == '*') {
                    // 出现零次
                    // 一次或者多次
                    dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
       }

       // 直接返回结果
       return dp[0][0];
    }

}
