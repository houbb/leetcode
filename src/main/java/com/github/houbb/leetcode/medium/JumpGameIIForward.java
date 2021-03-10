package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class JumpGameIIForward {

    /**
     *
     * 【解題思路】
     *
     * 我们第一次可以选择走两步：
     *
     * （1）直接两步，可以走到 1，
     * （2）走一步，选择走到3，然后向后走走3步。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int count = 0;
        if(nums.length == 1) {
            return count;
        }

        // 目前能跳到的最远位置
        int maxFar = 0;
        // 上次跳跃可达范围右边界（下次的最右起跳点）
        int end = 0;

        // 最后一个位置不需要访问。
        for(int i = 0; i < nums.length-1; i++) {
            maxFar = Math.max(maxFar, i + nums[i]);

            // 到达上次跳跃能到达的右边界了
            if(i == end) {
                // 更新右边界
                end = maxFar;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        JumpGameIIForward jumpGameII = new JumpGameIIForward();
        System.out.println(jumpGameII.jump(new int[]{1,1,1,1}));; //3
        System.out.println(jumpGameII.jump(new int[]{1,2}));; //1
        System.out.println(jumpGameII.jump(new int[]{3,2,1}));; //1
        System.out.println(jumpGameII.jump(new int[]{0}));; //0
        System.out.println(jumpGameII.jump(new int[]{2,3,1,1,4}));; //2
    }

}
