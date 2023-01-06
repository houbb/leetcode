package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.ListNode;

/**
 * @author d
 * @since 1.0.0
 */
public class T142_LinkedListCycleII {

    /**
     *
     * 循环节点
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
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode slow2 = head;

        while (fast != null
            && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                // 此时，slow2 从头开始，slow 从重合点开始。
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }

                // 两个慢指针重合时，slow2 就在第一个环的节点上
                return slow2;
            }
        }

        return null;
    }

}
