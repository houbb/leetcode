package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T252_meetingRoom_V3_SweepLine {

    public static boolean canAttendMeetings(int[][] intervals) {
        List<int[]> events = new ArrayList<>();

        // 将每个会议的开始和结束时间作为事件存储
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});  // 会议开始时间 +1
            events.add(new int[]{interval[1], -1}); // 会议结束时间 -1
        }

        // 按时间排序，如果时间相同，优先处理结束事件
        Collections.sort(events, (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int ongoingMeetings = 0;

        // 扫描事件列表，检查会议的重叠情况
        for (int[] event : events) {
            ongoingMeetings += event[1];  // 加上当前事件的标记值
            if (ongoingMeetings > 1) {
                return false; // 有重叠会议
            }
        }

        return true; // 没有重叠会议
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test case 1: " + canAttendMeetings(intervals1)); // 输出：false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test case 2: " + canAttendMeetings(intervals2)); // 输出：true
    }

}
