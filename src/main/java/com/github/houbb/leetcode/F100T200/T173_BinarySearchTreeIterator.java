package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class T173_BinarySearchTreeIterator {


    private Iterator<Integer> iterator;

    /**
     * 思路：直接 in-order 放在 list 中，然后处理。
     *
     * @param root
     */
    public T173_BinarySearchTreeIterator(TreeNode root) {
        List<Integer> allList = new ArrayList<>();
        // 初始化
        travel(allList, root);

        this.iterator =  allList.iterator();
    }

    private void travel(List<Integer> list, TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        // 左
        if(treeNode.left != null) {
            travel(list, treeNode.left);
        }
        // 中
        list.add(treeNode.val);
        // 右边
        if(treeNode.right != null) {
            travel(list, treeNode.right);
        }
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

}
