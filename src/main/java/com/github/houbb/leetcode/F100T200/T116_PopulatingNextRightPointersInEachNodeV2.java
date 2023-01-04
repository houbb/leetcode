package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.Node;

public class T116_PopulatingNextRightPointersInEachNodeV2 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
     * Memory Usage: 39.3 MB, less than 45.38% of Java online submissions for Populating Next Right Pointers in Each Node.
     *
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

        // 左=》右（当前节点，左子树=》右子树）
        connect(current.left, current.right);

        // 右子树，指向当前节点 next 的左子树，或者指向空
        connect(current.right, current.next == null ? null : current.next.left);
    }

}
