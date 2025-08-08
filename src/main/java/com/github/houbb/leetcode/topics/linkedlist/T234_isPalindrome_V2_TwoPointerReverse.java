package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class T234_isPalindrome_V2_TwoPointerReverse {


    public boolean isPalindrome(ListNode head) {
        // 保存原始的头结点
        ListNode oldHead = head;

        // 1.双指针找中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 快走2步
            fast = fast.next.next;
            slow = slow.next;
        }

        // 此时 slow 在中间
        // 2. 借助 LC206 反转
        ListNode reverseNode = recursiveReverse(null, slow);

        // 3. 双指针循环，如果不一致直接中断
        while (oldHead != null && reverseNode != null) {
            int leftVal = oldHead.val;
            int rightVal = reverseNode.val;

            if(leftVal != rightVal) {
                return false;
            }
            oldHead = oldHead.next;
            reverseNode = reverseNode.next;
        }

        return true;
    }

    private ListNode recursiveReverse(ListNode pre, ListNode cur) {
        if(cur == null) {
            return pre;
        }

        ListNode temp = cur.next;
        cur.next = pre;

        // 递归
        return recursiveReverse(cur, temp);
    }


}
