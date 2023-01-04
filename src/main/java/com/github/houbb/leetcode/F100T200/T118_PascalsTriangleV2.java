package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.List;

public class T118_PascalsTriangleV2 {

    /**
     * 思路：
     *
     * 1. 固定第一行为 [1]
     * 2. 剩下的递归处理
     *
     * 采用不是递归的方式，就是直接一层一层的计算就行。
     *
     * 1. 每一行的最后一个元素&第一个元素为1
     * 2. 中间的元素为上一行的元素 [i] + [i+1]
     *
     * PS：跑起来不是很有区分度。
     *
     * @param numRows 行信息
     * @return 结果
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);

        for(int i = 0; i < numRows; i++) {
            // 每一行的元素个数，和第一行一一对应。
            List<Integer> row = new ArrayList<>(i+1);

            for(int j = 0; j < i + 1; j++) {
                // 两边固定为 1
                if(j == 0 || j == i) {
                    row.add(1);
                } else {
                    // arrayList 的寻址复杂度为 O(1)
                    int sum = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                    row.add(sum);
                }
            }

            list.add(row);
        }

        return list;
    }


    public static void main(String[] args) {
        System.out.println(new T118_PascalsTriangleV2().generate(1));
        System.out.println(new T118_PascalsTriangleV2().generate(2));
        System.out.println(new T118_PascalsTriangleV2().generate(3));
        System.out.println(new T118_PascalsTriangleV2().generate(4));
        System.out.println(new T118_PascalsTriangleV2().generate(5));
    }

}
