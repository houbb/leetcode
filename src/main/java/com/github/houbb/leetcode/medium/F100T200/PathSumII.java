package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        getAllPathSum(allPaths, new ArrayList<>(), root);


        List<List<Integer>> results = new ArrayList<>();
        for(List<Integer> all : allPaths) {
            if(isTargetList(all, targetSum)) {
                results.add(all);
            }
        }
        return results;
    }

    private boolean isTargetList(List<Integer> list, int target) {
        if(list.size() == 0) {
            return false;
        }

        int sum = 0;
        for(Integer integer : list) {
            sum += integer;
        }

       return target == sum;
    }

    private void getAllPathSum(List<List<Integer>> allPaths, List<Integer> tempList, TreeNode root) {
        if(root == null) {
            return ;
        }

        tempList.add(root.val);

        // 叶子
        if(root.left == null && root.right == null) {
            allPaths.add(tempList);
        }

        // 左右子树
        getAllPathSum(allPaths, new ArrayList<>(tempList), root.left);
        getAllPathSum(allPaths, new ArrayList<>(tempList), root.right);
    }


}
