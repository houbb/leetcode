package com.github.houbb.leetcode.topics.sort;

import java.util.*;

public class Sort_T451_FreqSort_V3_BucketSort {

    public static String frequencySort(String s) {
        if (s.length() <= 1) {
            return s;
        }

        // 数字是字母和数字，可以用技术来直接统计
        int[] counts = new int[128];
        char[] chars = s.toCharArray();
        for(char c : chars) {
            counts[c]++;
        }

        // 然后我们用桶排序的思想，来避免排序
        // 如果想节省空间，可以再一次遍历，找到最大的 freq
        // 可以对比一下二者的区别
        // 为什么+1？  freq 代表的是次数，比下标会多1.如果全部相同的话。
        List<Character>[] charsList = new List[s.length()+1];
        for(int i = 0; i < counts.length; i++) {
            char c = (char) i;
            int freq = counts[i];

            //  直接根据次数频率，设置到对应的数组上
            List<Character> characters = charsList[freq];
            if(characters == null) {
                characters = new ArrayList<>();
            }

            characters.add(c);

            //直接根据次数设置，避免排序
            charsList[freq]= characters;
        }


        // 从后往前，直接拼接
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = charsList.length-1; i >=0 ; i--) {
            List<Character> characters = charsList[i];
            if(characters != null) {
                // 拼接
                for(Character c : characters) {
                    for(int j = 0; j < i; j++) {
                        stringBuffer.append(c);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String resp = frequencySort("tree");
        System.out.println(resp);
    }

}
