package com.github.houbb.leetcode.F200T300;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/solutions/59554/my-simple-and-clean-java-code/?orderBy=most_votes
 *
 */
public class T211_WordDictionary {

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
    
    public T211_WordDictionary() {
        root = new TrieNode();
    }

    // 添加
    public void addWord(String word) {
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

    // word . 可以匹配任意字符
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        // 终止条件
        if (k == chs.length) {
            return node.isEnd;
        }

        if (chs[k] == '.') {
            // 任意匹配
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null && match(chs, k + 1, node.next[i])) {
                    return true;
                }
            }
        } else {
            // 精准匹配
            return node.next[chs[k] - 'a'] != null && match(chs, k + 1, node.next[chs[k] - 'a']);
        }

        return false;
    }

}
