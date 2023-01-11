package com.github.houbb.leetcode.F000T100;

import java.util.HashMap;
import java.util.Map;

public class T076_MinimumWindowSubstringV3 {

    public static void main(String[] args) {
        T076_MinimumWindowSubstringV3 minimumWindowSubstring = new T076_MinimumWindowSubstringV3();

        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minimumWindowSubstring.minWindow("a", "a"));
        System.out.println(minimumWindowSubstring.minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        // *Important* use intValue to compare values stored in the map
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char each : t.toCharArray()) {
            tMap.put(each, tMap.getOrDefault(each, 0) + 1);
        }

        int tSize = tMap.size();
        int sSize = 0;
        int left = 0;
        int minLeft = -1;
        int minRight = -1;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            int count = sMap.getOrDefault(cur, 0) + 1;
            sMap.put(cur, count);
            if (tMap.containsKey(cur) && tMap.get(cur).intValue() == sMap.get(cur).intValue()) {
                sSize++;
            }
            while (left <= right && sSize == tSize) {
                if (right - left + 1 < result) {
                    minLeft = left;
                    minRight = right;
                    result = right - left + 1;
                }
                char leftCur = s.charAt(left);
                int leftCount = sMap.get(leftCur) - 1;
                sMap.put(leftCur, leftCount);

                if (tMap.containsKey(leftCur)
                        && sMap.get(leftCur) < tMap.get(leftCur)) {
                    sSize--;
                }
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);
    }

}
