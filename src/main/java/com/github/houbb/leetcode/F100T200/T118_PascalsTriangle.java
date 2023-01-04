package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T118_PascalsTriangle {

    /**
     * 思路：
     *
     * 1. 固定第一行为 [1]
     * 2. 剩下的递归处理
     *
     * @param numRows 行信息
     * @return 结果
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);

        getList(numRows, list);
        return list;
    }

    private void getList(int rowNum, List<List<Integer>> list) {
        if(rowNum <= 0) {
            return;
        }

        if(list.size() == 0) {
            List<Integer> ones = Collections.singletonList(1);
            list.add(ones);
        } else {
            List<Integer> preList = list.get(list.size()-1);

            List<Integer> currentList = new ArrayList<>();
            currentList.add(1);
            for(int i = 0; i < preList.size()-1; i++) {
                int value = preList.get(i) + preList.get(i+1);
                currentList.add(value);
            }
            currentList.add(1);
            list.add(currentList);
        }

        // 递归
        getList(rowNum-1, list);
    }

    public static void main(String[] args) {
        System.out.println(new T118_PascalsTriangle().generate(1));
        System.out.println(new T118_PascalsTriangle().generate(2));
        System.out.println(new T118_PascalsTriangle().generate(3));
        System.out.println(new T118_PascalsTriangle().generate(4));
        System.out.println(new T118_PascalsTriangle().generate(5));
    }

}
