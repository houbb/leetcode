package com.github.houbb.leetcode.topics.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class T138_copyRandomList_v2_insertCopy {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. 复制节点，插入原节点后面
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 2. 设置复制节点的 random 指针
        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        // 3. 拆分链表，恢复原链表，获得复制链表头
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            copyCurr.next = curr.next;
            copyCurr = copyCurr.next;

            curr.next = curr.next.next; // 恢复原链表
            curr = curr.next;
        }

        return dummy.next;
    }

}
