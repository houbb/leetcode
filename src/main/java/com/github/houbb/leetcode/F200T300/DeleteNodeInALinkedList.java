package com.github.houbb.leetcode.F200T300;

import com.github.houbb.leetcode.ListNode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class DeleteNodeInALinkedList {

    /**
     * 思路：
     *
     * 当前节点删除的方式：
     *
     * 下个节点的值，复制到当前节点。
     *
     * current.next = next.next;
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
     * Memory Usage: 38.4 MB, less than 57.18% of Java online submissions for Delete Node in a Linked List.
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
