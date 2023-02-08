package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T055_JumpGame {

    /**
     * 这一题其实是最大的步数问题。
     *
     *【解题思路】
     * 基本思想是：在每个步骤中，我们都跟踪最远的可到达索引。
     *
     * 问题的本质（例如，您可以击中一个目标范围的最大跳跃，而不是您只能击中一个目标的奇异跳跃）是要使一个索引可以到达，必须使每个先前的索引都可以到达。
     *
     * 因此，我们迭代每个索引就足够了，如果遇到无法访问的索引，我们将中止并返回false。
     *
     * 到最后，我们将迭代到最后一个索引。 如果循环结束，则最后一个索引是可到达的。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > max) {
                return false;
            }

            // 这是可以达到的最大的距离，对应的就是 i
            // 只要 i 在 max 的范围内，就是可以达到。
            max = Math.max(max, nums[i] + i);
        }

        return true;
    }

    public static void main(String[] args) {
        T055_JumpGame game = new T055_JumpGame();

        int[] nums = {2,3,1,1,4};
        System.out.println(game.canJump(nums));
//
        int[] nums2 = {3,2,1,0,4};
        System.out.println(game.canJump(nums2));

        int[] nums3 = {0};
        System.out.println(game.canJump(nums3));

        int[] nums4 = {2,5,0,0};
        System.out.println(game.canJump(nums4));
    }


}
