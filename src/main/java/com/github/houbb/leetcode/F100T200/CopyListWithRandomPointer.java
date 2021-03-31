package com.github.houbb.leetcode.F100T200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class CopyListWithRandomPointer {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
     * Memory Usage: 39.2 MB, less than 14.57% of Java online submissions for Copy List with Random Pointer.
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        // 最基本的場景
        if(head == null) {
            return null;
        }

        // 使用 HashMap 保存當前節點和複製後的節點
        // 頭節點
        Node copyDummy = new Node(0);
        Node copy = new Node(head.val);
        copyDummy.next = copy;

        Map<Node, Node> map = new HashMap<>();
        map.put(head, copy);

        // 第一遍複製
        Node next = head.next;
        while (next != null) {
            Node nextCopy = new Node(next.val);

            map.put(next, nextCopy);

            copy.next = nextCopy;

            next = next.next;
            copy = nextCopy;
        }

        // 第二遍處理 random
        for(Map.Entry<Node, Node> entry : map.entrySet()) {
            Node nodeCopy = entry.getValue();

            Node random = entry.getKey().random;
            nodeCopy.random = map.get(random);
        }

        return copyDummy.next;
    }

}
