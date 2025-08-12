package com.github.houbb.leetcode.topics.graph;

import java.util.HashSet;
import java.util.Set;

public class LC208_V1_SET {

    class Trie {

        // 幽默解法
        private Set<String> wordSet = new HashSet<>();

        public Trie() {

        }

        public void insert(String word) {
            wordSet.add(word);
        }

        public boolean search(String word) {
            return wordSet.contains(word);
        }

        public boolean startsWith(String prefix) {
            for(String word: wordSet) {
                if(word.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }
    }

}
