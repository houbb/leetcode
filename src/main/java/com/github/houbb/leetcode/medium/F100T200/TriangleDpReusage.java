package com.github.houbb.leetcode.medium.F100T200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class TriangleDpReusage {

    /**
     * 思路：不需要重复创建，直接修改原始的 list 也行
     *
     * Runtime: 4 ms, faster than 36.07% of Java online submissions for Triangle.
     * Memory Usage: 38.7 MB, less than 92.94% of Java online submissions for Triangle.
     *
     * @param triangle 三角形
     * @return 结果
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        // list 有太多的越界限制，导致性能很差。
        for(int i = size-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                List<Integer> list = triangle.get(i);
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j);

                list.set(j, min);
            }
        }

        return triangle.get(0).get(0);
    }


    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.asList(2));
        results.add(Arrays.asList(3, 4));
        results.add(Arrays.asList(6,5, 7));
        results.add(Arrays.asList(4,1, 8, 4));

        TriangleDpReusage triangle = new TriangleDpReusage();
        System.out.println(triangle.minimumTotal(results));
    }

}
