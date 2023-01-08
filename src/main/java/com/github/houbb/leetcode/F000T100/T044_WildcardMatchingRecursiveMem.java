package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T044_WildcardMatchingRecursiveMem {

        boolean isMatch(String s, String p) {
            if (p.length() == 0) {
                return (s.length() == 0);
            }
            boolean[][] mem = new boolean[s.length() + 1][p.length() + 1];
            return recursive(s.toCharArray(), p.toCharArray(), 0, 0, mem);
        }

        boolean recursive(char[] s, char[] p, int i, int j, boolean[][] mem) {
            if (j == p.length)
                return (i == s.length);

            // 为 false，没有处理过。
            if (!mem[i][j]) {
                if (i == s.length)
                    mem[i][j] = (p[j] == '*' && recursive(s, p, i, j + 1, mem));
                else if (i < s.length && (p[j] == s[i] || p[j] == '?')) {
                    mem[i][j] = recursive(s, p, i + 1, j + 1, mem);
                } else if (p[j] == '*') {
                    mem[i][j] = (recursive(s, p, i, j + 1, mem) || recursive(s, p, i + 1, j, mem));
                } else
                    mem[i][j] = false;
            }
            return mem[i][j];
        }

}
