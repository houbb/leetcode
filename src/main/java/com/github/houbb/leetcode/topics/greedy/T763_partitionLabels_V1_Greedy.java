package com.github.houbb.leetcode.topics.greedy;

import java.util.ArrayList;
import java.util.List;

public class T763_partitionLabels_V1_Greedy {

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            last[c-'a'] = i;
        }

        // 处理
        int start = 0;
        int end = 0;
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            end = Math.max(end, last[c-'a']);

            // 满足结束条件
            if(i == end) {
                resultList.add(end - start+1);
                start = i+1;
            }
        }

        return resultList;
    }

}
