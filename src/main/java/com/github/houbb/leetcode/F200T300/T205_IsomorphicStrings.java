package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T205_IsomorphicStrings {

    public static void main(String[] args) {
        T205_IsomorphicStrings isomorphicStrings = new T205_IsomorphicStrings();

        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
    }

    /**
     * 思路：
     *
     * 使用 List 存放每一个位置的元素?
     *
     * 那么对应关系呢？
     *
     * list[list_index] list_index 存放了所有的下标。
     *
     * Map(char, index) 存放对应的映射关系。
     *
     *
     *
     * * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        List<List<Integer>> sList = new ArrayList<>();
        List<List<Integer>> tList = new ArrayList<>();

        this.loop(sList, sMap, s);
        this.loop(tList, tMap, t);

        // 长度
        if(sList.size() != tList.size()) {
            return false;
        }

        // 对比
        for(int i = 0; i < sList.size(); i++) {
            List<Integer> sIndex = sList.get(i);
            List<Integer> tIndex = tList.get(i);

            // 不同，则返回 false
            if(!isSameList(sIndex, tIndex)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSameList(List<Integer> sIndex,
                               List<Integer> tIndex) {
        if(sIndex.size() != tIndex.size()) {
            return false;
        }

        for(int i = 0; i < sIndex.size(); i++) {
            if(!sIndex.get(i).equals(tIndex.get(i))) {
                return false;
            }
        }

        return true;
    }



    private void loop(List<List<Integer>> list,
                      Map<Character, Integer> map,
                      String text) {
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, map.size());
            }

            // 放入到索引中
            int index = map.get(c);
            // 避免越界
            if(index >= list.size()) {
                list.add(new ArrayList<>());
            }

            List<Integer> indexList = list.get(index);
            if(indexList == null) {
                indexList = new ArrayList<>();
            }

            indexList.add(i);
            list.set(index, indexList);
        }
    }

}
