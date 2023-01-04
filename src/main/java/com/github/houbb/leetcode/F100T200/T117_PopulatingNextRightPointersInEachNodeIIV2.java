package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.Node;

import java.util.ArrayList;
import java.util.List;

public class T117_PopulatingNextRightPointersInEachNodeIIV2 {

    /**
     *
     * ## 思路 1
     *
     * （1）获取每一层的元素
     * （2）从左到右 next 设置
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        List<List<Node>> results = new ArrayList<>();

        connect(results, root, 0);

        // 设置 next
        for(int i = 0; i < results.size(); i++) {
            List<Node> list = results.get(i);

            for(int j = 1; j < list.size(); j++) {
                Node pre = list.get(j-1);
                pre.next = list.get(j);
            }
        }
        return root;
    }

    private void connect(List<List<Node>> results, Node node, int level) {
        if (node == null) {
            return;
        }

        // AVOID BOUND EX
        if(results.size() <= level) {
            results.add(new ArrayList<>());
        }
        List<Node> list = results.get(level);
        if(list == null) {
            list = new ArrayList<>();
        }

        list.add(node);
        results.set(level, list);

        connect(results, node.left, level+1);
        connect(results, node.left, level+2);
    }

}
