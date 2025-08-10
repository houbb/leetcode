package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class T25_reverseKGroup_V0_ExtraList {

    public static void main(String[] args) {
        T25_reverseKGroup_V0_ExtraList extraList = new T25_reverseKGroup_V0_ExtraList();
        ListNode head = InnerListUtils.buildListNode(new int[]{1,2,3,4,5});
        head = extraList.reverseKGroup(head, 3);
        System.out.println(InnerListUtils.getList(head));
    }

    private List<ListNode> getListNodes(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list;
    }

    public static  void reverse(List<ListNode> list, int i, int j) {
        if (i < 0 || j >= list.size() || i >= j) {
            return; // 索引无效或不需要反转
        }
        while (i < j) {
            ListNode temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        // 所有节点
        List<ListNode> listNodes = getListNodes(head);

        // 按照组交换
        for(int i = 0; i < listNodes.size(); i += k) {
            // 结束循环
            if(i+k-1 > listNodes.size()-1) {
                break;
            }

            reverse(listNodes, i, i+k-1);
        }

        // 设置->
        for(int i = 0; i < listNodes.size()-1; i++) {
            listNodes.get(i).next = listNodes.get(i+1);
        }
        // 最后一个设置为 null
        listNodes.get(listNodes.size()-1).next = null;

        // 返回
        return listNodes.get(0);
    }



}
