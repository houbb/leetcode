package com.github.houbb.leetcode.F1000T1100;

import java.util.Arrays;

public class T2548_maxPriceBag_V2 {

    // [pricei, weighti]
    public double fillBackpack(int[][] items, int capacity) {
        // 按单位重量的价格从高到低排序
        Arrays.sort(items, (a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));
        double maxPrice = 0.0;
        int remainingCapacity = capacity;

        for (int[] item : items) {
            int price = item[0];
            int weight = item[1];
            if (remainingCapacity <= 0) {
                break;
            }
            if (weight <= remainingCapacity) {
                // 如果整个物品可以放入背包
                maxPrice += price;
                remainingCapacity -= weight;
            } else {
                // 如果只能放一部分物品
                double fraction = (double) remainingCapacity / weight;
                maxPrice += price * fraction;
                remainingCapacity = 0;
            }
        }
        // 检查背包是否被完全填满
        return remainingCapacity == 0 ? maxPrice : -1.0;
    }

    public static void main(String[] args) {
        T2548_maxPriceBag_V2 sol = new T2548_maxPriceBag_V2();
        int[][] items1 = {{50, 1}, {10, 8}};
        int capacity1 = 5;
        System.out.printf("%.5f\n", sol.fillBackpack(items1, capacity1)); // 输出：55.00000

        int[][] items2 = {{100, 30}};
        int capacity2 = 50;
        System.out.printf("%.5f\n", sol.fillBackpack(items2, capacity2)); // 输出：-1.00000
    }

}
