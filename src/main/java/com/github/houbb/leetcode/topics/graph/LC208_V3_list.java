package com.github.houbb.leetcode.topics.graph;

import java.util.*;

public class LC208_V3_list {

    class Trie {


        private List<String> words = new ArrayList<>();

        public void insert(String word) {
            int idx = Collections.binarySearch(words, word);
            if (idx < 0) idx = -idx - 1;
            words.add(idx, word);
        }

        public boolean search(String word) {
            int idx = Collections.binarySearch(words, word);
            return idx >= 0;
        }

        public boolean startsWith(String prefix) {
            String next = prefix.substring(0, prefix.length() - 1)
                    + (char)(prefix.charAt(prefix.length() - 1) + 1);

            int startIdx = Collections.binarySearch(words, prefix);
            if (startIdx < 0) startIdx = -startIdx - 1;

            int endIdx = Collections.binarySearch(words, next);
            if (endIdx < 0) endIdx = -endIdx - 1;

            return startIdx < endIdx;
        }

    }
    
}
