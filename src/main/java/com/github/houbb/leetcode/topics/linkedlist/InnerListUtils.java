package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class InnerListUtils {

    public static ListNode buildListNode(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for(int num : nums) {
            ListNode newNode = new ListNode(num);

            // 更新
            cur.next = newNode;
            cur = newNode;
        }
        return dummy.next;
    }

    // 输出
    public static List<Integer> getList(ListNode listNode) {
        List<Integer> list = new ArrayList<>();

        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}
