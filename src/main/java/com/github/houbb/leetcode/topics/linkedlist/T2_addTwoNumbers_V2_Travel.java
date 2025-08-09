package com.github.houbb.leetcode.topics.linkedlist;

import java.math.BigInteger;

public class T2_addTwoNumbers_V2_Travel {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;


        // 进位标志
        int carry = 0;

        // 进位存在，依然需要构建
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int sum = num1 + num2 + carry;

            // 进位-->10进制
            carry = sum / 10 ;
            // 剩余当前的数
            int num = sum % 10;
            ListNode newNode = new ListNode(num);
            cur.next = newNode;
            cur = newNode;

            // 两个链表指针后移  保持二者的位数一致
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }


}
