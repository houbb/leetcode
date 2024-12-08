package com.github.houbb.leetcode.topics.editdistance;

public class T161_isOneEditDistance {

    public static void main(String[] args) {
        // 示例 1
        System.out.println(isOneEditDistance("ab", "acb"));  // 输出: true

        // 示例 2
        System.out.println(isOneEditDistance("cab", "ad"));  // 输出: false

        // 其他测试用例
        System.out.println(isOneEditDistance("a", ""));      // 输出: true
        System.out.println(isOneEditDistance("abc", "ab"));  // 输出: true
        System.out.println(isOneEditDistance("abcd", "abxd"));  // 输出: true
        System.out.println(isOneEditDistance("abcd", "abcde")); // 输出: true
    }

    /**
     * 拆分为3个场景：
     *
     * 1. 如果二者长度差大于1，直接不可能
     * 2. 如果二者长度相同，那么只能有一个差异，则可以通过 replace 来实现。
     * 3. 如果长度差为1，那么可以通过 delete/insert 来实现。
     *
     * 可以简化为，通过长的-1来实现。
     *
     * 具体方法是，比较 s 和 t，找到第一个不同的字符后，跳过其中一个字符，继续比较剩下的部分。如果剩下的部分相等，则返回 true，否则返回 false。
     * @param s 原始
     * @param t 目标
     * @return 结果
     */
    public static boolean isOneEditDistance(String s, String t) {
        // 模板
        int sLen = s.length();
        int tLen = t.length();

        if(Math.abs(sLen - tLen) > 1) {
            return false;
        }

        // 如果长度相同
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if(sLen == tLen) {
            int diffCount = 0;
            for(int i = 0; i < sLen; i++) {
                if(sChars[i] != tChars[i]) {
                    diffCount++;
                }
            }

            return diffCount == 1;
        }

        // 如果长度差为 1，检查是否能通过插入或删除一个字符使两个字符串相等
        if (s.length() > t.length()) {
            // 确保 s 是较短的字符串
            String temp = s;
            s = t;
            t = temp;
        }
        // 尝试在 s 中插入一个字符变成 t
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // 跳过 t 中当前字符，继续比较
                return s.substring(i).equals(t.substring(i + 1));
            }
        }
        // 如果 s 完全是 t 的前缀，说明只差一个字符
        return s.length() + 1 == t.length();
    }

}
