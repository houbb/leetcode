package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 减法的方式做 DFS
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-17 15:09:54
 */
public class T022_GenerateParenthesesDfsMinis {

    /**
     * @param n 数字
     * @return 结果
     */
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();

        dfs(resultList, "", n, n, n);

        return resultList;
    }

    /**
     * 深度优先遍历
     * @param resultList 结果列表
     * @param string 字符串
     * @param left 左括号
     * @param right 右括号
     * @param num 位数
     */
    private void dfs(List<String> resultList,
                     String string,
                     int left,
                     int right,
                     int num) {
        if(left == 0 && right == 0) {
            resultList.add(string);
            return;
        }

        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数）
        if (left > right) {
            return;
        }

        if(left > 0) {
            dfs(resultList, string+"(", left-1, right, num);
        }
        if(right > 0) {
            dfs(resultList, string+")", left, right-1, num);
        }
    }

}
