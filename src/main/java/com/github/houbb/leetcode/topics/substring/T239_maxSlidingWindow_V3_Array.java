package com.github.houbb.leetcode.topics.substring;

public class T239_maxSlidingWindow_V3_Array {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1]; // 结果数组，存放每个窗口的最大值

        int[] p = new int[n]; // 用数组模拟双端队列，存放元素下标
        int head = 0;         // 队头指针，指向队列头元素在 p 数组中的索引
        int tail = -1;        // 队尾指针，指向队列尾元素在 p 数组中的索引，初始为空队列

        for (int i = 0; i < n; i++) {
            // 1. 保持队列单调递减：
            // 当当前元素 nums[i] 大于等于队尾元素 nums[p[tail]] 时，弹出队尾元素，
            // 因为它们不可能成为之后窗口的最大值了
            while (head <= tail && nums[p[tail]] <= nums[i]) {
                tail--; // 队尾元素出队
            }

            // 2. 将当前元素下标加入队尾
            p[++tail] = i;

            // 当前窗口左边界的下标
            int left = i - k + 1;

            // 3. 移除已经滑出窗口范围的队头元素
            // 如果队头元素的下标小于窗口左边界，则该元素已经过期，移除
            if (p[head] < left) {
                head++;
            }

            // 4. 当窗口形成（i >= k-1）时，队头元素对应的 nums[p[head]] 即为当前窗口最大值
            if (left >= 0) {
                res[left] = nums[p[head]];
            }
        }

        return res;
    }


}
