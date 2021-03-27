package com.github.houbb.leetcode.F100T200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MajorityElementMoerVote {

    /**
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // 全部抵消，重新赋值
            if(count == 0) {
                count++;
                major = num;
            } else if(major == num) {
                // 自己阵营，+1
                count++;
            } else {
                // 敌方阵营，-1
                count--;
            }
        }

        return major;
    }


}
