package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.ListNode;

public class T141_LinkedListCycle_ERROR {

    /**
     * 是否有循环
     *
     *
     * 1. POS 是什么？
     *
     * 2. 是什么叫重复呢？
     *
     * 这种算法是错误的，不可以通过值来判断，因为可能值重复。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        int preValue = -2;

        while (head != null) {
            int value = head.val;

            if(value <= preValue) {
                return true;
            }

            preValue = value;
            head = head.next;
        }

        // 循环结果
        return false;
    }

}
