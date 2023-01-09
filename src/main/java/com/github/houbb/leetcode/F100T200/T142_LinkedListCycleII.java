package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.ListNode;

public class T142_LinkedListCycleII {

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
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null
            && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            // 如果相同
            if(fastPointer == slowPointer) {
                return true;
            }
        }

        // 循环结果
        return false;
    }

}
