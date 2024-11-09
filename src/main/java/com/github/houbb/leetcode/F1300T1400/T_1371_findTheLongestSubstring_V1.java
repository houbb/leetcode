package com.github.houbb.leetcode.F1300T1400;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
@Deprecated
public class T_1371_findTheLongestSubstring_V1 {


    /**
     * 构建对应的数组
     *
     * 子数组：所以使用前缀和来解决？
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        // 如果是拆分为5个数组呢？
        final int len = s.length();
        char[] chars = s.toCharArray();

        int[] aSum = initPrefixSum(chars, 'a');
        int[] eSum = initPrefixSum(chars, 'e');
        int[] iSum = initPrefixSum(chars, 'i');
        int[] oSum = initPrefixSum(chars, 'o');
        int[] uSum = initPrefixSum(chars, 'u');

        // 找到最长的为0的数组
        Map<Integer, Integer> countMapA = new HashMap<>();
        Map<Integer, Integer> countMapE = new HashMap<>();
        Map<Integer, Integer> countMapI = new HashMap<>();
        Map<Integer, Integer> countMapO = new HashMap<>();
        Map<Integer, Integer> countMapU = new HashMap<>();
        // 兼容从零开始的情况
        countMapA.put(0, -1);
        countMapE.put(0, -1);
        countMapI.put(0, -1);
        countMapO.put(0, -1);
        countMapU.put(0, -1);

        int maxLen = 0;

        for(int i = 0; i < len; i++) {
            int sumA = aSum[i];
            int sumE = eSum[i];
            int sumI = iSum[i];
            int sumO = oSum[i];
            int sumU = uSum[i];


            if(countMapA.containsKey(sumA)) {
                int startIxA = countMapA.get(sumA);
            } else {
                countMapA.put(sumA, i);
            }

            if(countMapE.containsKey(sumE)) {
                int startIxE = countMapE.get(sumE);
            } else {
                countMapE.put(sumE, i);
            }

            if(countMapI.containsKey(sumI)) {
                int startIxI = countMapI.get(sumI);
            } else {
                countMapI.put(sumI, i);
            }

            if(countMapO.containsKey(sumO)) {
                int startIxO = countMapI.get(sumO);
            } else {
                countMapI.put(sumI, i);
            }
        }

        return maxLen;
    }

    private int[] initPrefixSum(char[] chars,
                               char targetChar) {
        final int n = chars.length;
        int[] prefixSum = new int[n];
        Map<Character, Integer> charCount = new HashMap<>();
        prefixSum[0] = getCharVal(chars[0], targetChar, charCount);
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + getCharVal(chars[i], targetChar, charCount);
        }
        return prefixSum;
    }

    private int getCharVal(char c,
                           char targetChar,
                           Map<Character, Integer> charCount) {
        int count = charCount.getOrDefault(c, 0);
        count++;
        charCount.put(c, count);

        if(c != targetChar) {
            return 0;
        }

        // 让元音字母成对出现
        if(count % 2 == 0) {
            return 1;
        }
        return -1;
    }



}
