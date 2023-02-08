package com.github.houbb.leetcode.F000T100;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T049_GroupAnagrams {

    /**
     * 解题思路：
     *
     * 直接放到一个 map 中去
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 设置一个 map
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for(String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> stringList = map.get(key);
            if(stringList == null) {
                stringList = new ArrayList<>();
            }

            stringList.add(string);
            map.put(key, stringList);
        }

        // 避免扩容
        List<List<String>> lists = new ArrayList<>(strs.length);
        lists.addAll(map.values());
        return lists;
    }

}
