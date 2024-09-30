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
public class T220_ContainsDuplicateIII_V6 {

    public static void main(String[] args) {
        T220_ContainsDuplicateIII_V6 v2 = new T220_ContainsDuplicateIII_V6();
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

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        int n = nums.length;

        Map<Long, Long> map = new HashMap<>();
        // 为什么是 t+1?
        // 令 size = t + 1 的本质是因为差值为 t 两个数在数轴上相隔距离为 t + 1，它们需要被落到同一个桶中。
        long w = (long) t + 1;

        for (int i=0;i<n;i++) {

            // 得到当前数的桶编号
            long id = getID(nums[i], w);

            // 在桶中已经存在了
            if (map.containsKey(id)) {

                return true;
            }

            // 相邻的桶中有在[num - t, num + t]内：左边相邻的桶中
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {

                return true;
            }
            //右边相邻的桶中
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }

            // 不会导致覆盖吗？
            /**
             * 桶的解法相当凝练，不过有一点可以啰嗦两句。不知道有没有人疑惑，在比较id - 1和id + 1这两个相邻桶时，
             * 只比较了一个元素，这足够吗？
             *
             * 哈希表的行为不是会用新元素覆盖旧元素，一个桶里有多个元素怎么办？
             *
             * 其实是覆盖根本不会发生...因为一旦要覆盖，就说明存在两个元素同属一个桶，直接返回true了。
             *
             * 这就是题解说的“一个桶内至多只会有一个元素”——数组输入里当然可以有多个元素属于同一个桶，但是一旦出现一对，算法就结束了。
             */
            map.put(id, (long) nums[i]);

            // 为什么需要删除？
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long num, long w) {

        if (num >= 0) {

            return num / w;
        }

        //但由于 0 号桶已经被使用了，我们还需要在此基础上进行 -1，相当于将负数部分的桶下标（idx）往左移，即得到 ((nums[i] + 1) / size) - 1

        return (num + 1) / w - 1;
    }


}
