package com.github.houbb.leetcode.topics.linkedlist;

import java.util.List;

public class T234_isPalindrome_V3_Array {


    private static int [] globalArray = new int[100000];

    public boolean isPalindrome(ListNode head) {
        // 直接全局复制
        int[] array = globalArray;

        // 拷贝全部元素
        int ix = 0;
        while (head != null) {
            array[ix++] = head.val;
            head = head.next;
        }

        // 判断回文
        return isValid(array, ix);
    }

    private boolean isValid(int[] array,
                            int size) {
        int left = 0;
        int right = size-1;

        while (left < right) {
            if(array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


}
