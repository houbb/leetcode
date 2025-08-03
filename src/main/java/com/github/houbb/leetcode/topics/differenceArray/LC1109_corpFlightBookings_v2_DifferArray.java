package com.github.houbb.leetcode.topics.differenceArray;

public class LC1109_corpFlightBookings_v2_DifferArray {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] differArray = new int[n];
        for(int[] booking : bookings) {
            int startIx = booking[0]-1;
            int endIx = booking[1]-1;
            int seatNum = booking[2];

            // startIx 开始 +seat
            differArray[startIx] += seatNum;

            // endIx 之后，去掉 seat
            if(endIx + 1 < n) {
                differArray[endIx+1] -= seatNum;
            }
        }

        // 前缀和恢复数组
        int[] results = new int[n];
        results[0] = differArray[0];
        for(int i = 1; i < n; i++) {
            results[i] = results[i-1] + differArray[i];
        }
        return results;
    }

}
