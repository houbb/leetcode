package com.github.houbb.leetcode.topics.hashing;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T49_groupAnagrams_V1_HashMap {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 处理
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            // 构建 Key
            char[] chars = str.toCharArray();
            Map<Character, Integer> charCountMap = new HashMap<>();
            for(char c : chars) {
                Integer count = charCountMap.getOrDefault(c, 0);
                count++;
                charCountMap.put(c, count);
            }

            // 直接序列化可能不一致
//            String key = charCountMap.toString();
            String key = buildKey(charCountMap);

            List<String> stringList = map.getOrDefault(key, new ArrayList<>());
            stringList.add(str);

            map.put(key, stringList);
        }

        // 构建结果
        List<List<String>> resultList = new ArrayList<>(map.size());
        resultList.addAll(map.values());

        return resultList;
    }

    private String buildKey(Map<Character, Integer> charCountMap) {
        StringBuilder stringBuilder =  new StringBuilder();

        for(int i = 0; i < 26; i++) {
            char c = (char) (i+'a');
            Integer count = charCountMap.get(c);
            if(count != null) {
                stringBuilder.append(c).append(count).append(";");
            }
        }
        return stringBuilder.toString();
    }

}
