package com.github.houbb.leetcode.topics.hashing;

import java.util.*;

public class T49_groupAnagrams_V4_HashMapAndSort {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 处理
        List<List<String>> resultList = new ArrayList<>();
        Map<String, Integer> keyIndexMap = new HashMap<>();

        for(String str : strs) {
            // 构建 Key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // 是否存在
            if(keyIndexMap.containsKey(key)) {
                Integer index = keyIndexMap.get(key);
                resultList.get(index).add(str);
            } else {
                // 不存在
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                resultList.add(stringList);
                keyIndexMap.put(key, resultList.size()-1);
            }
        }

        return resultList;
    }

}
