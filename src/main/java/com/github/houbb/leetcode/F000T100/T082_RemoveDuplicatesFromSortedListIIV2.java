package com.github.houbb.leetcode.F000T100;


import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T082_RemoveDuplicatesFromSortedListIIV2 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        List<Integer> ints = getInts(head);
        return buildHead(ints);
    }

    private List<Integer> getInts(ListNode head) {
        List<Integer> results = new ArrayList<>();
        // 只保存没有重复的元素
        int pre = head.val;
        ListNode currentNode = head.next;


        // 第一个元素的判断
        if(pre != currentNode.val) {
            results.add(pre);
        }

        while (currentNode != null) {
            int current = currentNode.val;
            // 当前元素和上一个元素不同
            if(pre != current) {
                // 当前元素和下一个元素不同

                //2.1 最后一个元素
                ListNode next = currentNode.next;
                if(next == null) {
                    results.add(current);
                } else if(current != next.val){
                    // 也不等于下一个
                    results.add(current);
                }
            }

            // 向后循环
            pre = current;
            currentNode = currentNode.next;
        }

        return results;
    }

    /**
     * 构建头结点
     * @return 结果
     * @since 0.0.1
     */
    public ListNode buildHead(List<Integer> list) {
        if(list.size() == 0) {
            return null;
        }

        ListNode head = new ListNode(list.get(0));
        ListNode temp = head;
        for(int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
