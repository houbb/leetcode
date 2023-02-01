package com.github.houbb.leetcode.F200T300;

import com.github.houbb.leetcode.ListNode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T206_ReverseLinkedListV2 {

    /**
     * 列表反转的思路
     *
     * 1->2->3
     * 1<-2<-3
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 38.5 MB, less than 93.17% of Java online submissions for Reverse Linked List.
     *
     * @param head 头结点
     * @return 结果
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode next = head.next;
            // 当前节点指向上一个节点
            head.next = newHead;
            // 上一个节点更新为当前节点
            newHead = head;
            // 当前节点继续向后
            head = next;
        }

        return newHead;
    }

}
