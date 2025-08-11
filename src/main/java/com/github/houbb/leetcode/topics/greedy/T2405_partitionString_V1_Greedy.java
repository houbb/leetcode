package com.github.houbb.leetcode.topics.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T2405_partitionString_V1_Greedy {

    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(set.contains(c)) {
                set.clear();
                count++;
            }

            set.add(c);
        }

        // 需要多加一次
        if(!set.isEmpty()) {
            count++;
        }

        return count;
    }

}
