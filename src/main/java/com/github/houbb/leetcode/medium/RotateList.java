package com.github.houbb.leetcode.medium;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class RotateList {

    /**
     * 右旋
     *
     * 优化思路：
     *
     * 1. k 应该进行取模。
     *
     * 2. 如何后去 head 的列表大小呢？
     *
     * 0 <= k <= 2 * 10^9
     *
     * 3. 可以在获取大小的时候，同时递增 k
     *
     * 不过这回导致比较麻烦。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        //1. 遍历获取元素
        ListNode tempHead = head;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);

            head = head.next;
        }

        // 空列表或者只有1
        if(list.size() <= 1) {
            return tempHead;
        }

        //2. 取模
        int mod = k % list.size();
        if(mod == 0) {
            return tempHead;
        }

        //3. 根据取模的位置，重新构建元素列表，返回
//        Input: head = [1,2,3,4,5], k = 2
//        Output: [4,5,1,2,3]

        // 后续的元素
        int kStart = list.size()-mod-1;

        // 从 k 到开始
        ListNode tail = new ListNode(list.get(kStart), null);
        // 从 k 向前
        for(int i = kStart-1; i >= 0; i--) {
            // 更新结尾元素
            tail = new ListNode(list.get(i), tail);
        }

        // 从最后，到转换的位置
        for(int i = list.size()-1; i > kStart; i--) {
            // 更新结尾元素
            tail = new ListNode(list.get(i), tail);
        }


        return tail;
    }

    private class ListNode {
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
