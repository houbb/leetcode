package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T252_meetingRoom_V4_PriorityQueue {

    public static boolean canAttendMeetings(int[][] intervals) {
        // 按开始时间排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 最小堆用于跟踪会议的结束时间
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            // 如果堆顶的会议结束时间小于等于当前会议的开始时间，弹出堆顶
            if (!minHeap.isEmpty() && minHeap.peek() <= interval[0]) {
                minHeap.poll();
            }

            // 将当前会议的结束时间加入堆中
            minHeap.add(interval[1]);

            // 如果堆中有超过一个会议的结束时间，说明有重叠
            if (minHeap.size() > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test case 1: " + canAttendMeetings(intervals1)); // 输出：false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test case 2: " + canAttendMeetings(intervals2)); // 输出：true
    }

}
