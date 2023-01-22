package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T147_InsertionSortList {


    public ListNode insertionSortList(ListNode head) {
        //1. 遍历
        List<ListNode> allList = new ArrayList<>();
        while (head != null) {
            allList.add(head);
            head = head.next;
        }

        //2. 排序
        Collections.sort(allList, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });


        //3. 构建结果
        ListNode newHead = allList.get(0);
        // 临时节点
        ListNode temp = newHead;
        for(int i = 1; i < allList.size(); i++) {
            ListNode cur = allList.get(i);
            cur.next = null;

            temp.next = cur;
            temp = temp.next;
        }

        return newHead;
    }

}
