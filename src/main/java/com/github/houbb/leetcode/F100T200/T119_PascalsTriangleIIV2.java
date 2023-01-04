package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.List;

public class T119_PascalsTriangleIIV2 {

    /**
     * 优化思路：实际上我们未必需要从上到下把每一层都计算出来。
     *
     * 数学的问题，通过数学公式计算更加优雅。
     *
     * https://zhuanlan.zhihu.com/p/257895125
     * https://leetcode.com/problems/pascals-triangle-ii/submissions/870953912/
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> resultList = new ArrayList<>(rowIndex+1);
        resultList.add(1);

        long temp = 1;
        int up = rowIndex;
        int down = 1;

        for(int i = 1; i <= rowIndex; i++){
            // 我不理解，但是大受震撼
            temp = temp*up/down;

            resultList.add((int)temp);

            up--;
            down++;
        }
        return resultList;
    }




    public static void main(String[] args) {
        System.out.println(new T119_PascalsTriangleIIV2().getRow(1));
        System.out.println(new T119_PascalsTriangleIIV2().getRow(2));
        System.out.println(new T119_PascalsTriangleIIV2().getRow(3));
        System.out.println(new T119_PascalsTriangleIIV2().getRow(4));
        System.out.println(new T119_PascalsTriangleIIV2().getRow(5));
    }

}
