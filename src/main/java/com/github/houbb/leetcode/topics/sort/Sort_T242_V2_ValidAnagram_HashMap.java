package com.github.houbb.leetcode.topics.sort;

import java.util.HashMap;
import java.util.Map;

public class Sort_T242_V2_ValidAnagram_HashMap {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> count1 = getCharsCount(s);
        Map<Character, Integer> count2 = getCharsCount(t);

        // 对比
        for(Map.Entry<Character, Integer> entry : count1.entrySet()) {
            Integer val2 = count2.get(entry.getKey());
            if(!entry.getValue().equals(val2)) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> getCharsCount(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for(char c : chars) {
            int count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }

        return map;
    }

}
