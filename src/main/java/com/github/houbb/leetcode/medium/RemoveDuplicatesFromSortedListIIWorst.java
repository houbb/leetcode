package com.github.houbb.leetcode.medium;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class RemoveDuplicatesFromSortedListIIWorst {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        //1. 利用 map 統計次數
        Map<Integer, List<ListNode>> map = new LinkedHashMap<>();

        while (head != null) {
            int val = head.val;
            List<ListNode> listNodes = map.get(val);
            if(listNodes == null) {
                listNodes = new ArrayList<>();
            }
            listNodes.add(new ListNode(val));
            map.put(val, listNodes);
            head = head.next;
        }

        // 便利 map，重新構建 node
        ListNode resultNode = null;
        ListNode currentNode = null;
        for(Map.Entry<Integer, List<ListNode>> entry : map.entrySet()) {
            List<ListNode> listNodes = entry.getValue();

            // 符合條件的列表
            if(listNodes.size() == 1) {
                ListNode listNode = listNodes.get(0);
                if(resultNode == null) {
                    resultNode = listNode;
                    currentNode = resultNode;
                } else {
                    currentNode.next = listNode;
                    currentNode = listNode;
                }
            }
        }

        return resultNode;
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
