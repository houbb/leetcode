package com.github.houbb.leetcode.F600T700;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class TopKFrequentWordsSort {

    public static void main(String[] args) {
        String[] words = new String[]{"a", "aa", "aaa"};
        System.out.println(topKFrequent(words, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // 次数统计
        Map<String, Integer> countMap = new HashMap<>(words.length);
        for(String string : words) {
            countMap.put(string, countMap.getOrDefault(string, 0) + 1);
        }

        // 次数排序
        List<String> sortList = new ArrayList<>(countMap.keySet());
        sortList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //1. 比较次数
                int count1 = countMap.get(o1);
                int count2 = countMap.get(o2);

                // 次数不等
                if (count1 != count2) {
                    return count2 - count1;
                } else {
                    // 自然排序
                    return o1.compareTo(o2);
                }
            }
        });

        // 截取结果
        return sortList.subList(0, k);
    }

}
