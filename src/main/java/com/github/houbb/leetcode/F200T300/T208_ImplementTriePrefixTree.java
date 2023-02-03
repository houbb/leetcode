package com.github.houbb.leetcode.F200T300;

public class T208_ImplementTriePrefixTree {

    private class TrieNode {
        private boolean isEnd;

        private TrieNode[] next;

        public TrieNode() {
            this.isEnd = false;
            next = new TrieNode[26];
        }
    }

    // 根节点
    private TrieNode root;

    public T208_ImplementTriePrefixTree() {
        // 初始化
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            int ci = word.charAt(i) - 'a';

            if(cur.next[ci] == null) {
                cur.next[ci] = new TrieNode();
            }

            cur = cur.next[ci];
        }

        // 单词结束
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            int ci = word.charAt(i) - 'a';

            if(cur.next[ci] == null) {
                return false;
            }

            cur = cur.next[ci];
        }

        // 单词结束
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            int ci = prefix.charAt(i) - 'a';

            if(cur.next[ci] == null) {
                return false;
            }

            cur = cur.next[ci];
        }

        // 单词结束
        return true;
    }

}
