package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T086_PartitionList {

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }

        // 根据 x 拆分为2
        List<Integer> lts = new ArrayList<>();
        List<Integer> gtes = new ArrayList<>();

        while (head != null) {
            int val  = head.val;
            if(val < x) {
                lts.add(val);
            } else {
                gtes.add(val);
            }

            head = head.next;
        }

        // 重新构建 head
        lts.addAll(gtes);
        return buildHead(lts);
    }

    /**
     * 构建头结点
     * @return 结果
     * @since 0.0.1
     */
    public ListNode buildHead(List<Integer> integers) {
        ListNode head = new ListNode(integers.get(0));

        ListNode temp = head;
        for(int i = 1; i < integers.size(); i++) {
            temp.next = new ListNode(integers.get(i));
            temp = temp.next;
        }

        return head;
    }
    
    public class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
