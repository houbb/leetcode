package com.github.houbb.leetcode.topics.graph;

import java.util.HashSet;
import java.util.Set;

public class LC208_V2_PrefixSet {

    class Trie {

        // 幽默解法
        private Set<String> wordSet = new HashSet<>();
        private Set<String> prefixSet = new HashSet<>();

        public Trie() {

        }

        public void insert(String word) {
            wordSet.add(word);

            // 插入所有的前缀
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                stringBuilder.append(word.charAt(i));
                prefixSet.add(stringBuilder.toString());
            }

        }

        public boolean search(String word) {
            return wordSet.contains(word);
        }

        public boolean startsWith(String prefix) {
            return prefixSet.contains(prefix);
        }
    }
    
}
