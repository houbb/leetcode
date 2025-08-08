package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class T234_isPalindrome_V1_List {


    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        // 判断
        if(list.isEmpty()) {
            return false;
        }

        // 判断回文
        return isValid(list);
    }

    private boolean isValid(List<Integer> list) {
        int left = 0;
        int right = list.size()-1;

        while (left < right) {
            if(list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


}
