package com.github.houbb.leetcode.topics.twoPointer;

public class T31_nextPermutation_V1_TIPS {

    /**
     * 1. **从右向左找到第一个 `i`，使得 `nums[i] < nums[i + 1]`**；
     * 2. 如果找不到，说明整个数组是降序的，直接反转即可；
     * 3. 否则，从右向左找第一个 `j`，使得 `nums[j] > nums[i]`；
     * 4. 交换 `nums[i]` 和 `nums[j]`；
     * 5. 反转 `nums[i + 1:]` 这段（后缀升序化）；
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = -1;

        //1. 从右向左找到第一个 `i`，使得 `nums[i] < nums[i + 1]`；
        for(i = n-2; i >=0; i--) {
            if(nums[i] < nums[i + 1]){
                break;
            }
        }
        // 未找到，说明是最大顺序 reverse
        if(i == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        // 3.否则，从右向左找第一个 `j`，使得 `nums[j] > nums[i]`；
        // 因为 i 找到的条件，必然存在 j
        int j = n-1;
        for(j = n-1; j > i; j--) {
            if(nums[j] > nums[i]) {
                break;
            }
        }

        //4. swap
        swap(nums, i, j);

        //5. reverse
        reverse(nums, i+1, n-1);
    }

    /**
     * 逆序
     * @param nums 数组
     * @param startIndex 开始
     * @param endIndex 结束
     */
    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(nums, startIndex++, endIndex--);
        }
    }

    private void swap(int[] nums, int startIndex, int endIndex) {
        int temp = nums[startIndex];
        nums[startIndex] = nums[endIndex];
        nums[endIndex] = temp;
    }

}
