package com.github.houbb.leetcode.F400T500;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        //1. 获取所有路径
        List<List<Integer>> allPaths = allPathSums(root);

        //2. 遍历获取符合条件的列表

        return 0;
    }

    // 穷举
    // 0 ... n-1，一个也算吗？
    // 每个元素可以重复吗？
    // 长度为1，尝试一遍？
    // 长度为2，尝试一遍？
    // ...
    // 长度为n，尝试一遍？
    private List<Integer> allList(List<Integer> list, int targetSum) {
        List<Integer> results = new ArrayList<>();

        return results;
    }

    public List<List<Integer>> allPathSums(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        getAllPathSum(allPaths, new ArrayList<>(), root);
        return allPaths;
    }

    private void getAllPathSum(List<List<Integer>> allPaths, List<Integer> tempList,
                               TreeNode root) {
        if(root == null) {
            return ;
        }

        tempList.add(root.val);

        // 叶子
        if(root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(tempList));
        }

        // 左右子树
        getAllPathSum(allPaths, tempList, root.left);
        getAllPathSum(allPaths, tempList, root.right);

        // 移除最后一个元素
        tempList.remove(tempList.size()-1);
    }




}
