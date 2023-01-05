package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T129_SumRootToLeafNums {

    // 获取所有路径

    /**
     * Runtime: 1 ms, faster than 28.21% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 36.9 MB, less than 30.13% of Java online submissions for Sum Root to Leaf Numbers.
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        getAllPath(root, results, new ArrayList<>());

        // 遍历构建
        int sum = 0;
        for(int i = 0; i < results.size(); i++) {
            sum += calcInt(results.get(i));
        }

        return sum;
    }

    // 1 2 3 4 = 1 * 10^3 + 2*10^2 + 3*10 + 4;
    private int calcInt(List<Integer> list) {
        int sum = 0;

        for(int i = 0; i < list.size(); i++) {
            int pow = list.size() -1 - i;
            sum += list.get(i) * Math.pow(10, pow);
        }
        return sum;
    }

    private void getAllPath(TreeNode node, List<List<Integer>> results,
                            List<Integer> tempList) {
        if(node == null) {
            return;
        }

        tempList.add(node.val);

        if(node.left == null && node.right == null) {
            results.add(tempList);
        }

        getAllPath(node.left, results, new ArrayList<>(tempList));
        getAllPath(node.right, results, new ArrayList<>(tempList));
    }

}
