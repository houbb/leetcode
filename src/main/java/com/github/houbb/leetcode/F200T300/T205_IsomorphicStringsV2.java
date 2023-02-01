package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T205_IsomorphicStringsV2 {

    public static void main(String[] args) {
        T205_IsomorphicStringsV2 isomorphicStrings = new T205_IsomorphicStringsV2();

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
     * The idea is that we need to map a char to another one,
     * for example, "egg" and "add", we need to constract the mapping 'e' -> 'a' and 'g' -> 'd'.
     *
     * Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same.
     *
     * So we use two arrays here m1 and m2, initialized space is 256 (Since the whole ASCII size is 256, 128 also works here).
     * Traverse the character of both s and t on the same position, if their mapping values in m1 and m2 are different,
     * means they are not mapping correctly, returen false; else we construct the mapping,
     * since m1 and m2 are both initialized as 0, we want to use a new value when i == 0, so i + 1 works here.
     *
     * * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s.length(); ++i) {
            int sc = s.charAt(i);
            int tc = t.charAt(i);

            // 比较当前下标的总数
            if (m1[sc] != m2[tc]) {
                return false;
            }

            m1[sc] = i + 1;
            m2[tc] = i + 1;
        }
        return true;
    }

}
