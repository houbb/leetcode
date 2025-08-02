package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T438_findAnagrams_V1_BF {

    public static void main(String[] args) {
        System.out.println(findAnagrams("aaabb", "bb"));
    }

    /**
     * 返回 s 中涵盖 t 所有字符的最小子串。
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCountMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            Integer count = pCountMap.getOrDefault(p.charAt(i), 0);
            count++;
            pCountMap.put(c, count);
        }

        List<Integer> resultList = new ArrayList<>();

        int pLen = p.length();
        for(int i = 0; i <= s.length()-pLen; i++) {
            // 找到符合条件的数据
            Map<Character, Integer> tempCountMap = new HashMap<>(pCountMap);

            for(int j=i; j < s.length(); j++) {
                char c = s.charAt(j);
                // 不包含此字符
                Integer count = tempCountMap.get(c);
                // 不存在，或者多了
                if(count == null
                    || count < 0) {
                    break;
                }

                count--;
                if(count > 0) {
                    tempCountMap.put(c, count);
                } else {
                    tempCountMap.remove(c);
                }

                // 是否满足
                if(tempCountMap.isEmpty()) {
                    resultList.add(i);
                    break;
                }
            }

        }

        return resultList;
    }

}
