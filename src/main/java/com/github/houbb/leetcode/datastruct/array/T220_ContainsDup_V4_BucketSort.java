package com.github.houbb.leetcode.datastruct.array;

import java.util.HashMap;
import java.util.Map;

public class T220_ContainsDup_V4_BucketSort {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        // 桶大小
        long bucketSize = (long) valueDiff + 1;
        Map<Long, Long> bucketMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long bucketId = getBucketId(nums[i], bucketSize);

            // 检查当前桶是否有元素满足条件
            if (bucketMap.containsKey(bucketId)) {
                return true;
            }

            // 检查相邻桶的元素是否满足条件
            if (bucketMap.containsKey(bucketId - 1) && Math.abs(nums[i] - bucketMap.get(bucketId - 1)) < bucketSize) {
                return true;
            }
            if (bucketMap.containsKey(bucketId + 1) && Math.abs(nums[i] - bucketMap.get(bucketId + 1)) < bucketSize) {
                return true;
            }

            // 将当前元素放入桶中
            bucketMap.put(bucketId, (long) nums[i]);

            // 保持窗口大小
            if (i >= indexDiff) {
                bucketMap.remove(getBucketId(nums[i - indexDiff], bucketSize));
            }
        }

        return false;
    }

    private long getBucketId(int num, long bucketSize) {
        return num < 0 ? (num + 1) / bucketSize - 1 : num / bucketSize;
    }

}
