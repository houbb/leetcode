package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.component.Node;
import com.github.houbb.leetcode.component.Node;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        List<List<Node>> results = new ArrayList<>();

        levelOrder(results, root, 0);

        return root;
    }

    private void levelOrder(List<List<Node>> results, Node node, int level) {
        if(node == null) {
            return;
        }

        // 当前节点
        // AVOID BOUND EX
        if(results.size() <= level) {
            results.add(new ArrayList<>());
        }
        List<Node> list = results.get(level);

        // 如果列表不为空，把上一个 node 的 next 指向当前 Node
        if(list.size() > 0) {
            Node pre = list.get(list.size()-1);
            pre.next = node;
        }

        // 当前层最后一个元素
        int maxNum = (int) Math.pow(2, level);
        if(list.size() == maxNum-1) {
            node.next = null;
        }

        // 节点
        list.add(node);
        results.set(level, list);

        // 左
        levelOrder(results, node.left, level+1);

        // 右
        levelOrder(results, node.right, level+1);
    }

}
