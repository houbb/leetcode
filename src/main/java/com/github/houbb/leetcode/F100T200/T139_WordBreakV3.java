package com.github.houbb.leetcode.F100T200;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T139_WordBreakV3 {

    public static void main(String[] args) {
        T139_WordBreakV3 wordBreak = new T139_WordBreakV3();


        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // assume s and wordDict are non-empty
        return backtracking(0, s, new HashSet<>(wordDict));
    }

    private boolean backtracking(int depth, String s, Set<String> wordSet) {
        int n = s.length();
        // accept
        if (depth == n) {
            return true;
        }

        for (int i = depth; i < n; ++i) {
            // substring[depth, i]
            String str = s.substring(depth, i + 1);

            //O(1) 判断 str 是否存在
            if (wordSet.contains(str)) {
                if (backtracking(i + 1, s, wordSet)) {
                    return true;
                }
            }
        }

        return false;
    }

}
