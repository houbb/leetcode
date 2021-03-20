package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.component.Node;

public class PopulatingNextRightPointersInEachNodeII {

    /**
     *
     * ## 思路 1
     *
     * 这一题和上一题的差异点就在于不是完美二叉树。
     *
     * 我们可以保持整体逻辑不变，考虑下下面的情况：
     *
     * （1）当前节点左子树不存在
     *
     * 不变，因为 left 节点不存在，不用处理。
     *
     * （2）当前节点右子树不存在
     *
     * 左子树.next 就不是 current.right 了。
     *
     * 而是  current.next.left/current.next.right 第一个非空的值，如果都是空，那就是 NULL。
     *
     * （3）不存在子节点
     *
     * 不变，不用处理。
     *
     * 综上，我们可以把流程调整如下：
     *
     * - 左子树.next
     *
     * 获取 current.right，如果不存在，则执行下面的逻辑
     *
     * current.next 不为空的话，循环找到下一个不为空的子节点。
     *
     * - 右子树.next
     *
     * current.next 不为空的话，循环找到下一个不为空的子节点。
     * @param root
     * @return
     */
    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    private void connect(Node current, Node next) {
        if (current == null) {
            return;
        }

        current.next = next;
        Node nextChild = getNextChildNode(current);
        Node left = current.left;
        Node right = current.right;

        // 左子树
        if(current.left == null && current.right == null) {
            // do nothing
            System.out.println("左右子树都是空" + current.val);
        } else if(current.right != null) {
            connect(current.left, current.right);
            // 右子树
            connect(current.right, nextChild);
        } else {
            connect(current.left, nextChild);
        }
    }

    /**
     * 获取下一个不为空的子节点
     * @param current 当前节点
     * @return 结果
     */
    private Node getNextChildNode(Node current) {
        Node next = current.next;
        System.out.println("current.val = " + current.val + " next = " + next.val);
        while (next != null) {
            if(next.left != null) {
                return next.left;
            }
            if(next.right != null) {
                return next.right;
            }

            next = next.next;
        }

        return null;
    }

}
