package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class T083_RemoveDuplicatesFromSortedList {


    /**
     * 删除重复节点
     *
     * 1. 直接遍历，记录一下 preValue，如果值和 preValue 相同，直接继续 next
     * @param head 头结点
     * @return 结果
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode pointer = head;
        List<ListNode> list = new ArrayList<>();

        while (pointer != null) {
            int curVal = pointer.val;
            Integer lastVal = getLastValue(list);

            // 判断和上一个是否重复，不重复才加入
            if(lastVal == null
                || lastVal != curVal) {
                list.add(pointer);
            }

            pointer = pointer.next;
        }

        // 反转，构建 head 头
        //[tail, -, head]
        ListNode nextNode = null;
        for(int i = list.size()-1; i >=0; i--) {
            ListNode curNode = list.get(i);
            curNode.next = nextNode;

            nextNode = curNode;

            // 最后一个返回
            if(i == 0) {
                return curNode;
            }
        }

        return null;
    }

    private Integer getLastValue(List<ListNode> list) {
        if(list.size() <= 0) {
            return null;
        }

        return list.get(list.size()-1).val;
    }


}
