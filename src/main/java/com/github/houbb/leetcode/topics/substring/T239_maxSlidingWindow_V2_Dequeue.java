package com.github.houbb.leetcode.topics.substring;

import java.util.ArrayDeque;
import java.util.Deque;

public class T239_maxSlidingWindow_V2_Dequeue {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int lenResult = nums.length - k + 1;
        int[] results = new int[lenResult];

        int index = 0;
        // queue 中存放下标，更加灵活
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            // 移除队头所有过期的数据
            if(!deque.isEmpty()
                && deque.peekFirst() < i-k+1) {
                deque.removeFirst();
            }

            // 所有比当前小，全部从队尾移除
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            // 队尾加入当前索引
            deque.addLast(i);

            // 如果满了
            if(i >= k-1) {
                results[index++] = nums[deque.peekFirst()];
            }
        }

        return results;
    }

}
