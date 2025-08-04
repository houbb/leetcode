package com.github.houbb.leetcode.topics.hashing;

import java.util.*;

public class T49_groupAnagrams_V2_HashMapOpt {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 处理
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            // 构建 Key
            char[] chars = str.toCharArray();
            int[] charCountMap = new int[26];
            for(char c : chars) {
                int ix = c - 'a';
                charCountMap[ix]++;
            }

            // 此时顺序是固定的，所以应该相等。
            // 也可以用比较数组，但是需要序列化
            // 改为自己拼接
            StringBuilder keyBuilder = new StringBuilder();
            for(int i : charCountMap) {
                keyBuilder.append(i).append(",");
            }
            String key = keyBuilder.toString();


            List<String> stringList = map.getOrDefault(key, new ArrayList<>());
            stringList.add(str);

            map.put(key, stringList);
        }

        // 构建结果
        List<List<String>> resultList = new ArrayList<>(map.size());
        resultList.addAll(map.values());

        return resultList;
    }

}
