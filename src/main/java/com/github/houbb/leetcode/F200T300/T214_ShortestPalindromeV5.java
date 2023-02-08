package com.github.houbb.leetcode.F200T300;

public class T214_ShortestPalindromeV5 {


    public static void main(String[] args) {
        T214_ShortestPalindromeV5 v2 = new T214_ShortestPalindromeV5();

        System.out.println(v2.shortestPalindrome("aacecaaa").equals("aaacecaaa"));

        System.out.println(v2.shortestPalindrome("abcd").equals("dcbabcd"));
    }

    /**
     * 马拉车算法
     *
     * https://leetcode.cn/problems/shortest-palindrome/solution/can-kao-zuo-shen-manacherde-dai-ma-jie-f-y2ba/
     * @param source
     * @return
     */
    public String shortestPalindrome(String source) {
        if (source.length() == 0) {
            return source;
        }
        StringBuilder sb = new StringBuilder(source).reverse();
        String s = sb.toString();

        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int R = -1;
        int C = -1;
        for (int i = 0; i < str.length; i++) {
            int i1 = C - (i - C);
            // i' 的回文区域在L...R边界上的话, pArr[i1] 和 R-i 是相等的
            pArr[i] = (i < R) ? Math.min(pArr[i1], R - i) : 1;

            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            // 某个字符使 R 达到了边界
            if (R == str.length) {
                break;
            }
        }
        // 从当前的中心点的 L 往前遍历，都加入到后面去
        // L 为 -1 则说明 source 原本就是个回文
        int L = C - (R - C);
        // 因为是加工过的字符串，要除二
        L = L == -1 ? L : L / 2;
        int len = source.length() - 1;
        for (int i = L; i >= 0; i--) {
            sb.append(source.charAt(len - i));
        }
        // res 不用再 reverse 回去了，因为已经处理成回文了
        return sb.toString();
    }

    private char[] manacherString(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i % 2 == 0) ? '#' : chars[i / 2];
        }
        return res;
    }

}
