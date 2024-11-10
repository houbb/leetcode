package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;

@Deprecated
public class T001_twoSum_V2_SortBinarySearch_ERR {


    /**
     * 错误的代码
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Arrays.sort(nums);

        // 遍历+二分
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            // 找另一部分
            int t = target - nums[i];

            // 找到了自己怎么办？
            int j = Arrays.binarySearch(nums, t);
            if(j > 0) {
                res[0] = i;
                res[1] = j;
                return res;
            }
        }

        return res;
    }

}
