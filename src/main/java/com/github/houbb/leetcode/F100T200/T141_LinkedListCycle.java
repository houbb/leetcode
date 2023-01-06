package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.ListNode;

/**
 * @author d
 * @since 1.0.0
 */
public class T141_LinkedListCycle {

    /**
     * 是否有循环
     *
     *
     * 1. 快慢指针
     *
     * 慢：一次走一步
     * 快：一次走2步
     *
     * 如果二者又重复了，说明存在环。
     *
     * @param head 头
     * @return 是否
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null
            && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }

        return false;
    }

}
