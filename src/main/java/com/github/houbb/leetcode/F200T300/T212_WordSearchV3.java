package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T212_WordSearchV3 {

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
     * https://leetcode.com/problems/word-search-ii/solutions/59780/java-15ms-easiest-solution-100-00/
     *
     * Intuitively, start from every cell and try to build a word in the dictionary.
     *
     * Backtracking (dfs) is the powerful way to exhaust every possible ways.
     *
     * Apparently, we need to do pruning when current character is not in any word.
     *
     * How do we instantly know the current character is invalid? HashMap?
     * How do we instantly know what's the next valid character? LinkedList?
     * But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
     * Combing them, Trie is the natural choice. Notice that:
     *
     * TrieNode is all we need. search and startsWith are useless.
     * No need to store character at TrieNode. c.next[i] != null is enough.
     * Never use c1 + c2 + c3. Use StringBuilder.
     * No need to use O(n^2) extra space visited[m][n].
     * No need to use StringBuilder. Storing word itself at leaf node is enough.
     * No need to use HashSet to de-duplicate. Use "one time search" trie.
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;

        // 通过直接处理，而不是方法。但是这样不利于类的封装。
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        // 替换，节省空间
        board[i][j] = '#';

        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);

        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            // 类似于 isEnd
            p.word = w;
        }
        return root;
    }

    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
