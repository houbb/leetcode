package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T139_WordBreakV4 {

    public static void main(String[] args) {
        T139_WordBreakV4 wordBreak = new T139_WordBreakV4();


        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // memo[i] --> S[i...] is breakable or not
        Boolean[] mem = new Boolean[s.length()];

        // assume s and wordDict are non-empty
        return backtracking(mem, 0, s, new HashSet<>(wordDict));
    }

    private boolean backtracking(Boolean[] mem,
                                 int depth, String s, Set<String> wordSet) {
        int n = s.length();
        // accept
        if (depth == n) {
            return true;
        }

        // 内存化复用
        if(mem[depth] != null) {
            return mem[depth];
        }

        for (int i = depth; i < n; ++i) {
            // substring[depth, i]
            String str = s.substring(depth, i + 1);

            //O(1) 判断 str 是否存在
            if (wordSet.contains(str)) {
                if (backtracking(mem, i + 1, s, wordSet)) {
                    // 可以，存储
                    mem[depth] = true;

                    return true;
                }
            }
        }

        // 不可，存储
        mem[depth] = false;
        return false;
    }

}
