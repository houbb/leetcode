package com.github.houbb.leetcode.F200T300;

import java.util.*;

/**
 * 是否存在重复元素
 *
 * @since 20231117
 */
public class T218_SkyProblem_V1 {

    private static class Event implements Comparable<Event> {
        public int x;
        public int height;
        public boolean isStart;

        public Event(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Event other) {
            if (this.x != other.x) {
                return this.x - other.x;
            }
            if (this.isStart && !other.isStart) {
                return -1;
            }
            return this.isStart ? 1 : 0;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Event> events = new ArrayList<>();
        for (int[] building : buildings) {
            events.add(new Event(building[0], building[2], true));  // Start event
            events.add(new Event(building[1], building[2], false)); // End event
        }

        // Sort events by x, then by type (start before end)
        Collections.sort(events);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        List<List<Integer>> skyline = new ArrayList<>();
        int prevHeight = 0;

        for (Event event : events) {
            if (event.isStart) {
                maxHeap.add(event.height);
            } else {
                maxHeap.remove(event.height);
            }

            int currentHeight = maxHeap.isEmpty() ? 0 : maxHeap.peek();
            if (currentHeight != prevHeight) {
                skyline.add(Arrays.asList(event.x, currentHeight));
                prevHeight = currentHeight;
            }
        }

        return skyline;
    }


}
