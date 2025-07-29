package com.github.houbb.leetcode.topics.sort;

import java.util.*;

public class Sort_T451_FreqSort_V1_HashMap {

    public String frequencySort(String s) {
        if(s.length() <= 1) {
            return s;
        }

        Map<Character, Integer> freqCountMap = new HashMap<>();

        char[] chars = s.toCharArray();
        for(char c : chars) {
            Integer count = freqCountMap.getOrDefault(c, 0);
            freqCountMap.put(c, ++count);
        }

        // 怎么按照次数排序呢？
        Map<Integer, List<Character>> countCharsMap = new HashMap<>();
        for(Map.Entry<Character, Integer> entry : freqCountMap.entrySet()) {
            List<Character> characterList = countCharsMap.getOrDefault(entry.getValue(), new ArrayList<>());
            characterList.add(entry.getKey());

            countCharsMap.put(entry.getValue(), characterList);
        }

        // 整体数排序
        List<Integer> countList = new ArrayList<>(countCharsMap.keySet());
        Collections.sort(countList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 是否写反了？
                return o2.compareTo(o1);
            }
        });


        // 处理
        StringBuffer stringBuffer = new StringBuffer();
        for(Integer count : countList) {
            List<Character> characterList = countCharsMap.get(count);

            // 总数？
            for(Character c : characterList) {
                for(int i = 0; i < count; i++) {
                    stringBuffer.append(c);
                }
            }

        }

        return stringBuffer.toString();
    }

}
