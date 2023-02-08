package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T133_CloneGraphBFS {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 核心问题：
     *
     * （1）如何遍历图
     *
     * DFS
     *
     * （2）如何记录已经访问过的节点呢？
     *
     * 可以使用列表。
     *
     * Runtime: 24 ms, faster than 98.98% of Java online submissions for Clone Graph.
     * Memory Usage: 38.9 MB, less than 87.79% of Java online submissions for Clone Graph.
     *
     * @param node
     * @return
     */
    // 定义为 101，直接把 val 当做下标，减少一次减法运算。
    Node[] copyArray = new Node[101];
    public Node cloneGraph(Node node) {
        //fast-return
        if(node == null) {
            return null;
        }

        // 当前节点
        // 节点的位置，就是对应的索引的位置。
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        // 克隆第一个节点并存储到哈希表中
        int val = node.val;
        copyArray[val]  = new Node(val, new ArrayList<>());

        while (!stack.isEmpty()) {
            Node pop = stack.pop();

            // 处理邻居节点
            for(Node neighbor : pop.neighbors) {
                // 复制邻居节点
                int nVal = neighbor.val;
                Node copy = copyArray[nVal];

                // 没有访问过
                if(copy == null) {
                    copy = new Node(nVal, new ArrayList<>());
                    copyArray[nVal] = copy;
                    stack.push(neighbor);
                }

                // 更新拷贝的邻居节点
                copyArray[pop.val].neighbors.add(copy);
            }
        }

        // 直接获取拷贝后的 node
        return copyArray[val];
    }

}
