package com.github.houbb.leetcode.F600T700;

import java.util.Arrays;

public class T_minMeetingRooms {

    public static void main(String[] args) {
        T_minMeetingRooms minMeetingRooms = new T_minMeetingRooms();
        int[][] array = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms.minMeetingRooms(array));;

        // [[7,10],[2,4]]
        int[][] array2 = {{7,10}, {2,4}};
        System.out.println(minMeetingRooms.minMeetingRooms(array2));
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int pointer = 0;
        for (int i = 0; i < len; i++) {
            if (start[i] < end[pointer]) {
                res++;
            } else {
                pointer++;
            }
        }

        return res;
    }

}
