package com.github.houbb.leetcode.topics.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC208_V4_trie {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for(char c : chars) {
                // 不存在？
                if(node.children[c-'a'] == null) {
                    node.children[c-'a'] =  new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = find(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }

        private TrieNode find(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for(char c : chars) {
                // 不存在？
                if(node.children[c-'a'] == null) {
                    return null;
                }
                node = node.children[c-'a'];
            }

            return node;
        }

    }
    
}
