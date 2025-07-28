package com.github.houbb.leetcode.topics.sort;

import java.util.HashMap;
import java.util.Map;

public class Sort_T2085_V1_HashMap {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> count1Map = new HashMap<>();
        //1. 添加
        for(String word : words1) {
            count1Map.put(word, count1Map.getOrDefault(word, 0)+1);
        }

        Map<String, Integer> count2Map = new HashMap<>();
        for(String word : words2) {
            count2Map.put(word, count2Map.getOrDefault(word, 0)+1);
        }

        // 计算总数
        int count = 0;
        for(Map.Entry<String, Integer> entry : count1Map.entrySet()) {
            String key = entry.getKey();
            Integer count1 = entry.getValue();
            if(count1 == 1 && count1.equals(count2Map.get(key))) {
                count++;
            }
        }
        return count;
    }

}
