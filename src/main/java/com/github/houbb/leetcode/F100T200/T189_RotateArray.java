package com.github.houbb.leetcode.F100T200;

public class T189_RotateArray {

    /**
     * 最简单的思路：
     *
     * 1. 临时数组，把原始的结果存下来
     * 2. 更新 nums
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        final int len = nums.length;
        int offset = k % len;
        if(offset == 0) {
            return;
        }


        int[] temp = new int[len];
        int tempIndex = 0;
        // 偏移
        //Input: nums = [1,2,3,4,5,6,7], k = 3
        //Output: [5,6,7,1,2,3,4]
        for(int i = len-1-offset+1; i < len; i++) {
            temp[tempIndex++] = nums[i];
        }
        for(int i = 0; i <= len-1-offset; i++) {
            temp[tempIndex++] = nums[i];
        }

        // 赋值
        System.arraycopy(temp, 0, nums, 0, len);
    }

}
