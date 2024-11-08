package com.github.houbb.leetcode.F1000T1100;

import java.util.Arrays;
import java.util.Comparator;

public class T2548_maxPriceBag {

    public static void main(String[] args) {
        int[][] items = new int[][]{{50,1}, {10, 8}};

        T2548_maxPriceBag priceBag = new T2548_maxPriceBag();
        System.out.println(priceBag.maxPrice(items, 5));
    }

    // items[i] = [pricei, weighti] 表示第 i 个物品的价格和重量。
    public double maxPrice(int[][] items, int capacity) {
        Arrays.sort(items, (a, b) -> a[1] * b[0] - a[0] * b[1]);

        double ans = 0;
        for (int[] elem : items) {
            int price = elem[0], weight = elem[1];
            int val = Math.min(weight, capacity);
            ans += val * 1.0 / weight * price;
            capacity -= val;
        }

        return capacity > 0 ? -1 : ans;
    }



}
