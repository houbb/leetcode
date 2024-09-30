package com.github.houbb.leetcode.F200T300;

import java.util.*;

/**
 * # 题目
 *
 *
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 *
 * 找出满足下述条件的下标对 (i, j)：
 *
 * i != j,
 *
 * abs(i - j) <= indexDiff
 *
 * abs(nums[i] - nums[j]) <= valueDiff
 *
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * ## 示例 1：
 *
 * 输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * 输出：true
 * 解释：可以找出 (i, j) = (0, 3) 。
 * 满足下述 3 个条件：
 * i != j --> 0 != 3
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 *
 * ## 示例 2：
 *
 * 输入：nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
 * 输出：false
 * 解释：尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 1 <= indexDiff <= nums.length
 * 0 <= valueDiff <= 10^9
 */
public class T220_ContainsDuplicateIII_V3 {

    public static void main(String[] args) {
        T220_ContainsDuplicateIII_V3 v2 = new T220_ContainsDuplicateIII_V3();
        int nums[] = new int[]{1,5,9,1,5,9};
        boolean result = v2.containsNearbyAlmostDuplicate(nums, 2, 3);
        System.out.println(result);

        int nums2[] = new int[]{1,2,3,1};
        boolean result2 = v2.containsNearbyAlmostDuplicate(nums2, 3, 0);
        System.out.println(result2);

        int nums3[] = new int[]{2, 2};
        boolean result3 = v2.containsNearbyAlmostDuplicate(nums3, 2, 0);
        System.out.println(result3);
    }

    /**
     * 思路：
     *
     * AVL 红黑树
     *
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        //1. treeSet
        // 滑动窗口结合查找表，此时滑动窗口即为查找表本身（控制查找表的大小即可控制窗口大小）
        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++) {
            // 边添加边查找
            // 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            //  the least key greater than or equal to the given key, or null if there is no such key.
            Long ceiling = set.ceiling((long) nums[i] - (long) valueDiff);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) valueDiff)) {
                return true;
            }

            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);

            // 这里其实不会错误删除。因为重复的元素，如果满足，上面就直接 return 了。
            // 这里删除的只是这个位置最早的一个值？????
            if (set.size() == indexDiff + 1) {
                set.remove((long) nums[i - indexDiff]);
            }
        }


        return false;
    }

}
