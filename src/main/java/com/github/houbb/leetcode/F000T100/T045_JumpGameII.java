package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T045_JumpGameII {

    /**
     *
     * 【解題思路】
     *
     * 首先是能否到達，就是當前的 i
     *
     * 如何獲取最短的次數呢？
     *
     *
     * 貪心算法
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Jump Game II.
     * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Jump Game II.
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int count = 0;
        if(nums.length == 1) {
            return count;
        }

        // 最後一個位置。
        for(int i = nums.length-1; i > 0; i--) {
            // 取出当前位置的值

            // 从前往后循环都一样，因为你必须循环一遍，才能找到最大的那一个元素。
            // 最后前面的一个元素，肯定可以达到，至少为 1 步
            // 从前向后，记录肯定是最远的。
            for(int j = 0; j < i; j++) {
                // 哪一个值并不重要，重要的是距离
                int len = i - j;
                int maxLen = nums[j];
                // 可以达到
                if(maxLen >= len && len > 1) {
                    i -= (len-1);
                    break;
                }
            }

            // 次数递增
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        T045_JumpGameII jumpGameII = new T045_JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{1,1,1,1}));; //3
        System.out.println(jumpGameII.jump(new int[]{1,2}));; //1
        System.out.println(jumpGameII.jump(new int[]{3,2,1}));; //1
        System.out.println(jumpGameII.jump(new int[]{0}));; //0
        System.out.println(jumpGameII.jump(new int[]{2,3,1,1,4}));; //2
    }

}
