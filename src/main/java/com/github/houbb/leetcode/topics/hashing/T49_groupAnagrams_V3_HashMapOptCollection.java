package com.github.houbb.leetcode.topics.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T49_groupAnagrams_V3_HashMapOptCollection {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 处理
        List<List<String>> resultList = new ArrayList<>();
        Map<String, Integer> keyIndexMap = new HashMap<>();

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
