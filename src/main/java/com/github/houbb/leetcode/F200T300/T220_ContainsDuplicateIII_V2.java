package com.github.houbb.leetcode.F200T300;

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
public class T220_ContainsDuplicateIII_V2 {

    public static void main(String[] args) {
        T220_ContainsDuplicateIII_V2 v2 = new T220_ContainsDuplicateIII_V2();
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

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // 遍历所有可能的 i,j
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < i+indexDiff+1; j++) {
                if(j >= nums.length) {
                    continue;
                }

                if(Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }

        return false;
    }

}
