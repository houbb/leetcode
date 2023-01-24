package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class T160_IntersectionOfTwoLinkedLists {

    /**
     * 最笨的方法
     *
     * 1. 遍历完 A，放在 set 中，让 contains 为 O(1)
     * 2. 依次遍历B，每次都循环一遍A是否存在该 node
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null
            || headB == null) {
            return null;
        }

        Set<ListNode> aSet = new HashSet<>();
        while (headA != null) {
            aSet.add(headA);
            headA = headA.next;
        }

        // 遍历 B
        while (headB != null) {
            if(aSet.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }

}
