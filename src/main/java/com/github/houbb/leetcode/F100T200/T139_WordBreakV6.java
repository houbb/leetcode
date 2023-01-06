package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T139_WordBreakV6 {

    public static void main(String[] args) {
        T139_WordBreakV6 wordBreak = new T139_WordBreakV6();


        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    /**
     * 思路：
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 记录一个位置，是否被问过
        boolean[] mem = new boolean[s.length() + 1];

        return helper(mem, 0, s, wordDict);
    }

    /**
     *
     * @param mem 内存优化
     * @param length 字符串长度
     * @param target 目标字符串长度
     * @param wordList 字典
     * @return 结果
     */
    private boolean helper(boolean[] mem,
                           int length,
                           String target,
                           List<String> wordList) {
        // 终止条件
        if(length == target.length()) {
            return true;
        }

        // 已经访问过，说明不可行，直接 false
        if(mem[length]) {
            return false;
        }

        // 更新当前位置
        mem[length] = true;

        for(String word : wordList) {
            // 感觉和 substring 差不多，只不过是变成了 startWith
            if(target.startsWith(word, length)
                && helper(mem, length + word.length(), target, wordList)) {
                return true;
            }
        }

        return false;
    }

}
