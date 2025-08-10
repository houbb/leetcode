package com.github.houbb.leetcode.topics.linkedlist;

import java.util.*;

public class T23_mergeKLists_V1_Extra {

    // 额外空间
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode listNode : lists) {
            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
        }

        Collections.sort(list);

        // 返回结果
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        for(int num : list) {
            ListNode newNode = new ListNode(num);

            cur.next = newNode;
            cur = newNode;
        }
        return dummy.next;
    }



}
