package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.Node;

public class T117_PopulatingNextRightPointersInEachNodeIIV3 {

    // 当前层的前一个节点
    private Node pre = null;
    // 下一层的开始节点
    private Node nextStart = null;

    public Node connect(Node root) {
        Node start = root;
        while (start != null) {
            pre = null;
            nextStart = null;

            Node current = start;
            while (current != null) {
                // 处理下一层的 next 关系
                handle(current.left);
                handle(current.right);

                // 移动当前层的位置
                current = current.next;
            }

            // 下一层的开始节点
            start = nextStart;
        }
        return root;
    }

    private void handle(Node current) {
        if(current == null) {
            return;
        }

        // 设置子节点层 pre.next = current
        if (pre != null) {
            pre.next = current;
        }
        // 更新 pre
        pre = current;

        // 设置下一层的开始节点（第一个非空的元素）
        if (nextStart == null) {
            nextStart = current;
        }
    }

}
