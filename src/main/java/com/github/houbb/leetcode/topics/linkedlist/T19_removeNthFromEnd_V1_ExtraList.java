package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class T19_removeNthFromEnd_V1_ExtraList {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        if(list.size() <= 1) {
            return null;
        }
        // 删除第一个
        if(n == list.size()) {
            return list.get(1);
        }

        int ix = list.size()-n;
        ListNode pre = list.get(ix-1);

        if(ix == list.size()-1) {
            // 删除的是尾巴
            pre.next = null;
        } else {
            // common case
            pre.next = list.get(ix+1);
        }


        return pre;
    }



}
