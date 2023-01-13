package com.github.houbb.leetcode.F000T100;

public class T087_ScrambleString {

    public static void main(String[] args) {
        T087_ScrambleString scrambleString = new T087_ScrambleString();

        scrambleString.isScramble("abcde", "caebd");
    }

    /**
     * 递归
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        // 相同的字符，数量必须相同
        int[] charMap = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            charMap[s1.charAt(i)-'a']++;
            charMap[s2.charAt(i)-'a']--;
        }
        // 比较，如果不是0，说明不匹配
        for(int i = 0; i < 26; i++) {
            if(charMap[i] != 0) {
                return false;
            }
        }

        // 分割+递归
        for(int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            if(isScramble(s1.substring(0, i), s2.substring(s2.length()-i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) {
                return true;
            }
        }

        return false;
    }

}
