package com.github.houbb.leetcode.topics.linkedlist;

public class T25_reverseKGroup_V2_TwoPointerLoop {

    public static void main(String[] args) {
        T25_reverseKGroup_V2_TwoPointerLoop extraList = new T25_reverseKGroup_V2_TwoPointerLoop();
        ListNode head = InnerListUtils.buildListNode(new int[]{1,2,3,4,5});
        head = extraList.reverseKGroup(head, 3);
        System.out.println(InnerListUtils.getList(head));
    }




    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;

        while (true) {
            //1. 找到第 k 个元素，不够 k 个直接结束
            ListNode kthNode = findKthNode(pre, k);
            if(kthNode == null) {
                break;
            }

            //2. 当前的开始+下一组的开头
            ListNode curGroupStart = pre.next;
            ListNode nextGroupStart = kthNode.next;

            //3. 翻转
            reverse(curGroupStart, kthNode);

            //4. 衔接
            pre.next = kthNode;
            curGroupStart.next = nextGroupStart;

            //5. 更新 pre
            pre = curGroupStart;
        }

        return dummy.next;
    }

    // 反转从 start 到 end 的链表（包含两端）
    private void reverse(ListNode start, ListNode end) {
        ListNode pre = end.next;
        ListNode cur = start;

        // 和 LC206 的区别，不是整体反转。而是到 end.next 就结束了
        while (pre != end) {
            //1->2->3->...
            // 临时节点，避免 cur-> 指向反转时，引用丢失
            ListNode tmp = cur.next;

            // 指向反转
            cur.next = pre;

            // 更新节点
            pre = cur;
            // cur 指向本来 cur->next，方便做剩余的反转
            cur = tmp;
        }
    }

    private ListNode findKthNode(ListNode node, int k) {
        while (k > 0 && node != null) {
            node = node.next;

            k--;
        }
        return node;
    }



}
