package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T223_rectangleArea_V2_Sweepline {


    public static void main(String[] args) {
        computeArea(1,2,3,4,5,6,7,8);

    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int[][] arr = new int[2][];
        arr[0] = new int[]{ax1, ay1, ax2, ay2};
        arr[1] = new int[]{bx1, by1, bx2, by2};
        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[3] - o2[3] : o1[1] - o2[1]);
        List<Integer> xList = Arrays.asList(ax1, ax2, bx1, bx2);
        Collections.sort(xList);
        int ans = 0;
        for (int i = 1; i < 4; i++) {
            int width = xList.get(i) - xList.get(i-1);
            for (int[] ints : getLine(xList.get(i-1), xList.get(i), arr)) {
                ans += width * (ints[1] - ints[0]);
            }
        }
        return ans;
    }

    private static List<int[]> getLine(int x1, int x2, int[][] arr) {
        List<int[]> list = new ArrayList<>();
        for (int[] ints : arr) {
            if (x1 >= ints[0] && x2 <= ints[2]) {
                if (list.isEmpty()) {
                    list.add(new int[]{ints[1], ints[3]});
                } else {
                    int[] tmp = list.get(list.size() - 1);
                    if (tmp[1] < ints[1]) {
                        list.add(new int[]{ints[1], ints[3]});
                    } else if (tmp[1] < ints[3]) {
                        tmp[1] = ints[3];
                    }
                }
            }
        }
        return list;
    }

}
