package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T1011_V3_BinarySearchRecursive {

    public int shipWithinDays(int[] weights, int days) {
        // 最小
        int left = 0;
        // 最大
        int right = 0;

        for(int weight : weights) {
            left = Math.max(weight, left);
            // 会不会越界？
            right += weight;
        }

        return shipWithinDaysRecursive(weights, days, left, right);
    }

    private int shipWithinDaysRecursive(int[] weights, int days, int left, int right) {
        // end
        if(left > right) {
            return left;
        }

        int mid = Math.toIntExact(left + (right - left) / 2);

        int totalDays = calcTotalDays(weights, days, mid);
        // 满足条件的最小值 继续向左边去
        if(totalDays <= days) {
            return shipWithinDaysRecursive(weights, days, left, mid-1);
        } else {
            return shipWithinDaysRecursive(weights, days, mid+1, right);
        }
    }

    private int calcTotalDays(int[] weights, int days, int weightLimit) {
        long totalDays = 0;
        long tempWeight = 0;
        for(int weight : weights) {
            // 超出+1 清空
            if(tempWeight + weight > weightLimit) {
                totalDays++;
                tempWeight = 0;

                // 快速失败
                if(totalDays > days) {
                    break;
                }
            }

            // 继续增加
            tempWeight += weight;
        }

        // 剩余的
        if(tempWeight > 0) {
            totalDays++;
        }

        return Math.toIntExact(totalDays);
    }

    // 测试极端的场景
    public static void main(String[] args) {
        BinarySearch_T1011_V3_BinarySearchRecursive loop = new BinarySearch_T1011_V3_BinarySearchRecursive();
        int[] weights= new int[]{1,1,1,1000};
        int days = 2;
        System.out.println(loop.shipWithinDays(weights, days));
    }


}
