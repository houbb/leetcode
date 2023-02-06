package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T212_WordSearchV2 {

    /**
     * 这一题，使用原来的解法，问题并不大。079
     *
     * 不过 62/64 会超时。
     *
     * 优化思路：
     *
     * 1. 可以结合 trie 优化性能。
     *
     * 2. trie-tree 的实现参见 T208
     *
     * @param board
     * @param words
     * @return
     */
    private Set<String> res = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {
        // 构建 trie
        TrieTree trieTree = new TrieTree();
        for(String word : words) {
            trieTree.insert(word);
        }

        //dfs 处理
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, visited, trieTree, i, j, "");
            }
        }

        return new ArrayList<>(res);
    }


    // 实际上核心思想还是回溯
    // index 从零开始
    private void dfs(char[][] board,
                     boolean[][] visited,
                     TrieTree trieTree,
                     int i,
                     int j,
                     String str) {
        // 终止条件
        if(i >= board.length
                || i < 0
                || j >= board[i].length
                || j < 0
                || visited[i][j]){
            return;
        }

        str += board[i][j];
        // 剪枝，没有匹配的前缀
        if(!trieTree.startsWith(str)) {
            return;
        }

        // 满足条件的结果
        if(trieTree.search(str)) {
            res.add(str);
        }

        visited[i][j] = true;
        // 上下左右
        dfs(board, visited, trieTree, i - 1, j, str);
        dfs(board, visited, trieTree, i + 1, j, str);
        dfs(board, visited, trieTree, i, j - 1, str);
        dfs(board, visited, trieTree, i, j + 1, str);

        // 回溯
        visited[i][j] = false;
    }


    /**
     * 前缀树实现 T208
     *
     */
    private class TrieTree {
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

        public TrieTree() {
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

}
