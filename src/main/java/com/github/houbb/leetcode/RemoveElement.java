package com.github.houbb.leetcode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class RemoveElement {

    /**
     * 思路：
     *
     * int i 计数
     *
     * 【效果】
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     * Memory Usage: 38.1 MB, less than 42.61% of Java online submissions for Remove Element.
     *
     * @param nums 数组
     * @param val 待移除的数字
     * @return 结果
     * @since v1
     */
    public int removeElement(int[] nums, int val) {
        int c = 0;

        // 第一个元素
        for(int i = 0; i < nums.length; i++) {
            // 判断当前位置的元素
            if(nums[i] != val) {
                nums[c++] = nums[i];
            }
        }

        return c;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};

        int c = new RemoveElement().removeElement(nums, 3);

        for(int i = 0; i < c; i++) {
            System.out.println(nums[i]);
        }
    }

}
