package com.github.houbb.leetcode.F200T300;

/**
 * 是否存在重复元素
 *
 * @since 20231117
 */
public class T217_ContainsDuplicateV3InsertSort {

    /**
     * 核心思想：插入排序
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        int j = 0;
        int current = 0;

        for(int i = 1; i < nums.length; i++) {
            j = i-1;
            current = nums[i];

            // 和左边的相比，一直循环到对应的位置。这个性能其实比较差
            while (j >= 0 && current < nums[j]) {
                // 不断的把 j 的位置右边移动一位。类似于 array 中左边要插入一个元素，在挪动出一个位置。
                // 其他 java 中，类似于 Arrays.copy 的话，性能应该会更好。

                nums[j+1] = nums[j];
                j--;
            }

            // 如果 current 不是最小的，且元素重复？
            // 这里其实做了一个赋值。
            if(j >=0 && current == nums[j]) {
                return true;
            }

            // 插入新当前的元素
            nums[j+1] = current;
        }


        return false;
    }

    public static void main(String[] args) {
        T217_ContainsDuplicateV3InsertSort containsDuplicate = new T217_ContainsDuplicateV3InsertSort();
        boolean result = containsDuplicate.containsDuplicate(new int[]{1,2,3,1});
        System.out.println(result);
    }

}
