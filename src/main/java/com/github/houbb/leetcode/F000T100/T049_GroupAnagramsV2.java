package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T049_GroupAnagramsV2 {

    /**
     * 解题思路：
     *
     * 直接放到一个 map 中去
     *
     * 优化思路：可以不进行排序
     *
     * https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 设置一个 map
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for(String string : strs) {
            // 避免排序的方式
            //char type 0~127 is enough for constraint 0 <= strs[i].length <= 100
            //char array to String is really fast, thanks @legendaryengineer
            //You should use other data type when length of string is longer.
            //E.g. Use byte (-128 to 127), short (-32,768 to 32,767),
            //int. -2,147,483,648 to 2,147,483,647
            char[] frequencyArr = new char[26];
            char[] chars = string.toCharArray();
            for (char aChar : chars) {
                // 这里计算的是 26 个字母出现的次数
                frequencyArr[aChar - 'a']++;
            }
            String key = new String(frequencyArr);

            List<String> stringList = map.get(key);
            if(stringList == null) {
                stringList = new ArrayList<>();
            }

            stringList.add(string);
            map.put(key, stringList);
        }

        // 避免扩容
        return new ArrayList<>(map.values());
    }

}
