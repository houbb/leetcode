package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class T206_reverseList_V1_List {


    public ListNode reverseList(ListNode head) {
        // 反转 1->2->3->4
        //     4->3->2->1
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // 重新构建
        if(list.isEmpty()) {
            return null;
        }

        // 构建
        ListNode newHead = list.get(list.size()-1);
        for(int i = list.size()-1; i >= 0; i--) {
            list.get(i).next = list.get(i-1);
        }
        // 尾巴设置为null
        list.get(0).next=null;

        return newHead;
    }

}
