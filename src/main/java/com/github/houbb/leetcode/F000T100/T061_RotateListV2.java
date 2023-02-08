package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T061_RotateListV2 {

    /**
     * 右旋
     *
     * 优化思路：
     *
     * 1. k 应该进行取模。
     * 2. 如何后去 head 的列表大小呢？
     * 0 <= k <= 2 * 10^9
     * 3. 可以在获取大小的时候，同时递增 k
     * 不过这回导致比较麻烦。
     *
     * 【优化思路】
     *
     * 1. 第一步依然是获取 length + 计算取模 mod
     *
     * 2. 从头开始，找到 mod 的位置。
     *
     * head[mod-1].next = null; // 新的队尾
     *
     * head[mod].next = head; // 将
     *
     * return head[mod];  // 返回新的队头
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        //1. 遍历获取元素
        ListNode current = head;
        ListNode tail = head;

        int totalLen = 0;
        while (current != null) {
            tail = current;
            current = current.next;
            totalLen++;
        }

        // 空列表或者只有1
        if(totalLen <= 1) {
            return head;
        }

        //2. 取模
        int mod = k % totalLen;
        if(mod == 0) {
            return head;
        }

        // 3. 找到需要迭代的位置
        //        Input: head = [1,2,3,4,5], k = 2
        //        Output: [4,5,1,2,3]
        int times = 0;
        int totalTimes = totalLen - mod - 1;
        current = head;
        while (times < totalTimes) {
            current = current.next;
            times++;
        }

        // 下一个元素作为开始
        ListNode nextHead = current.next;
        // 当前元素作为最后一个元素
        current.next = null;
        // 对尾巴的下一个元素是原来的队首
        tail.next = head;

        return nextHead;
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
