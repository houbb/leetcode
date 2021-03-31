package com.github.houbb.leetcode.F600T700;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = new String[]{"a", "aa", "aaa"};
        System.out.println(topKFrequent(words, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        // 防御
        // 列表为空？内容为空？k 大于 words 长度？

        // 次数统计
        Map<String, Integer> countMap = new HashMap<>();
        for(String string : words) {
            countMap.put(string, countMap.getOrDefault(string, 0) + 1);
        }

        // 次数排序
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>((o1, o2) -> o2-o1);
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            List<String> list = treeMap.getOrDefault(count, new ArrayList<>());
            list.add(entry.getKey());
            treeMap.put(count, list);
        }

        // 返回结果
        List<String> results = new ArrayList<>(k);
        for(List<String> values : treeMap.values()) {
            // 排序
            Collections.sort(values);

            // 添加元素
            for(String value : values) {
                results.add(value);

                if(results.size() >= k) {
                    return results;
                }
            }
        }

        return results;
    }

}
