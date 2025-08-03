package com.github.houbb.leetcode.topics.differenceArray;

public class LC1109_corpFlightBookings_v1_BF {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] results = new int[n];

        for(int[] booking : bookings) {
            int startIx = booking[0];
            int endIx = booking[1];
            int seatNum = booking[2];

            for(int i = startIx-1; i <= endIx-1; i++) {
                results[i] += seatNum;
            }
        }
        return results;
    }

}
