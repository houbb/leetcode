package com.github.houbb.leetcode.topics.linkedlist;

public class T21_mergeTwoLists_V3_Recursive {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode res = new ListNode(0);
        // 对比更小的值
        if(list1.val < list2.val) {
            res = list1;
            // 再次找最小的
            res.next = mergeTwoLists(list1.next, list2);
        } else {
            res = list2;
            // 再次找最小的
            res.next = mergeTwoLists(list2.next, list1);
        }

        return res;
    }

}
