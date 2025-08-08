package com.github.houbb.leetcode.topics.linkedlist;

public class T160_getIntersectionNode_V2_LengthDiffer {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 注意：java 方法是值传递
        int lenA = getLen(headA);
        int lenB = getLen(headB);

        // 长的先走
        int diff = Math.abs(lenA-lenB);
        if(lenA > lenB) {
            headA = jumpDiffer(headA, diff);
        } else if(lenA < lenB) {
            headB = jumpDiffer(headB, diff);
        }

        // 一起走 找到共同的节点
        while (headA != null && headB != null) {
            if(headA == headB) {
                return headB;
            }

            headA = headA.next;
            headB = headB.next;
        }
        // NOT FOUND
        return null;
    }

    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    // java 是值传递，需要返回
    private ListNode jumpDiffer(ListNode node, int differ) {
        while (differ > 0) {
            node = node.next;
            differ--;
        }
        return node;
    }

}
