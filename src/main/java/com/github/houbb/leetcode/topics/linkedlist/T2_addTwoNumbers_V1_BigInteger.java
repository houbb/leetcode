package com.github.houbb.leetcode.topics.linkedlist;

import java.math.BigInteger;

public class T2_addTwoNumbers_V1_BigInteger {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String str1 = listToString(l1);
        String str2 = listToString(l2);

        BigInteger num1 = new BigInteger(str1);
        BigInteger num2 = new BigInteger(str2);

        BigInteger resNum = num1.add(num2);
        String resStr = resNum.toString();
        return stringToList(resStr);
    }

    private String listToString(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();

        while (listNode != null) {
            stringBuilder.append(listNode.val);
            listNode = listNode.next;
        }

        // 反转得到真实的结果
        return stringBuilder.reverse().toString();
    }

    private ListNode stringToList(String string) {
        if(string == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 高位在后边
        int length = string.length();
        int i = length - 1;
        while (i >= 0) {
            int val = string.charAt(i) - '0';

            ListNode newNode = new ListNode(val);
            // 指向新节点
            cur.next = newNode;
            // 更新 cur 位置
            cur = newNode;

            i--;
        }

        // 下一个就是开头
        return dummy.next;

    }



}
