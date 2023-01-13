package com.github.houbb.leetcode.F000T100;

import java.util.HashMap;
import java.util.Map;

public class T087_ScrambleStringV2 {

    public static void main(String[] args) {
        T087_ScrambleStringV2 scrambleString = new T087_ScrambleStringV2();

        scrambleString.isScramble("abcde", "caebd");
    }

    /**
     * 递归
     *
     * 添加缓存
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        // key = s1+s2
        // value = 是否匹配
        Map<String, Boolean> cache = new HashMap<>();

        return isScramble(s1, s2, cache);
    }
    public boolean isScramble(String s1, String s2,
                              Map<String, Boolean> cache) {
        // 首先判断缓存中是否存在
        String cacheKey = s1 + s2;
        if(cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        if(s1.equals(s2)) {
            cache.put(s1+s2, true);

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
                cache.put(s1+s2, false);

                return false;
            }
        }

        // 分割+递归
        for(int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i), cache)
                    && isScramble(s1.substring(i), s2.substring(i), cache)) {
                cache.put(s1+s2, true);
                return true;
            }

            if(isScramble(s1.substring(0, i), s2.substring(s2.length()-i), cache)
                    && isScramble(s1.substring(i), s2.substring(0, s2.length()-i), cache)) {
                cache.put(s1+s2, true);

                return true;
            }
        }

        cache.put(s1+s2, false);
        return false;
    }



}
