package com.github.houbb.leetcode.topics.linkedlist;

import java.util.*;

public class T148_sortList_v1_ExtraList {

    private List<ListNode> getList(ListNode listNode) {
        List<ListNode> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode);
            listNode = listNode.next;
        }
        return list;
    }

    public ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }

        List<ListNode> listNodes = getList(head);

        // 排序
        Collections.sort(listNodes, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        //3. 重新返回构建
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        for(int i = 0; i < listNodes.size(); i++) {
            ListNode newNode = listNodes.get(i);

            pre.next = newNode;
            pre = newNode;
        }

        // 最后一个值为空
        listNodes.get(listNodes.size()-1).next = null;

        return dummy.next;
    }

}
