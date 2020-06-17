package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-17 21:45:26
 */
public class GenerateParenthesesBfs {

    class Node {
        private String text;

        private int left;

        private int right;

        public Node(String text, int left, int right) {
            this.text = text;
            this.left = left;
            this.right = right;
        }

        public String getText() {
            return text;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }

    /**
     * @param n 数字
     * @return 结果
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        // 从上到下
        Queue<Node> queue = new LinkedList<>();
        Node rootNode = new Node("", 0, 0);
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            Node curNode = queue.remove();

            // 最后一层
            if (curNode.left == n && curNode.right == n) {
                res.add(curNode.text);
            }

            if (curNode.left < n) {
                queue.add(new Node(curNode.text + "(", curNode.left + 1, curNode.right));
            }
            // 剪枝
            if (curNode.right < curNode.left) {
                queue.add(new Node(curNode.text + ")", curNode.left, curNode.right + 1));
            }
        }

        return res;
    }

}
