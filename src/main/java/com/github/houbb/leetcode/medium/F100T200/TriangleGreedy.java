package com.github.houbb.leetcode.medium.F100T200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这个是错的。
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class TriangleGreedy {

    /**
     * dp
     *
     * 贪心？
     * 还是动态规划？
     *
     *
     * 最笨的方法：
     *
     * dp[i] = Math.min(dp[i-1], dp[i-1]') ;
     *
     * 两条路：
     * （1）下一步相同
     * （2）下一步 index+1
     * @param triangle 三角形
     * @return 结果
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] greedy = new int[triangle.size()+1];

        greedy[0] = triangle.get(0).get(0);
        int ix = 0;

        // 第一个元素
        for(int i = 1; i < triangle.size(); i++) {
            // 针对第一步不变的元素
            ix = next(triangle, i, ix, greedy);
        }

        int size = triangle.size();
        return greedy[size-1];
    }

    // 下一步的处理逻辑
    // 选择 i 和 i+1，选择更小的，并且返回新的 index
    // 从 2 开始
    private int next(List<List<Integer>> triangle,
                      int level, int preIndex,
                      int[] dp) {
        List<Integer> list = triangle.get(level);

        int minVal = list.get(preIndex);
        int minIndex = preIndex;

        int nextVal = list.get(preIndex+1);
        if(nextVal < minVal) {
            minVal = nextVal;
            minIndex = preIndex+1;
        }

        dp[level] = dp[level-1] + minVal;
        return minIndex;
    }


    // [2],[3,4],[6,5,7],[4,1,8,3]
    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.asList(2));
        results.add(Arrays.asList(3, 4));
        results.add(Arrays.asList(6,5, 7));
        results.add(Arrays.asList(4,1, 8, 4));

        TriangleGreedy triangle = new TriangleGreedy();
        System.out.println(triangle.minimumTotal(results));
    }

}
