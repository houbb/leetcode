package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class T24_swapPairs_V0_ExtraList {

    public static void main(String[] args) {
        T24_swapPairs_V0_ExtraList extraList = new T24_swapPairs_V0_ExtraList();
        ListNode head = InnerListUtils.buildListNode(new int[]{1,2,3,4});
        head = extraList.swapPairs(head);
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

    private void swap(List<ListNode> listNodes, int i, int j) {
        ListNode temp = listNodes.get(i);
        listNodes.set(i, listNodes.get(j));
        listNodes.set(j, temp);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        // 所有节点
        List<ListNode> listNodes = getListNodes(head);

        // 按照组交换
        int groupNum = 2;
        for(int i = 0; i+1 < listNodes.size(); i += groupNum) {
            // 交换或者说翻转
            swap(listNodes, i, i+1);
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
