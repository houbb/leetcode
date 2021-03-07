package com.github.houbb.leetcode.medium;

/**
 * 优化思路：直接根据 k 分割数组，因为数组的复制也是非常耗时的。
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class SearchInRotatedSortedArray {

    /**
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 没有旋转，或者全部旋转
        int randomK = getRandomK(nums);
        if(-1 == randomK) {
            return binarySearch(nums, target, 0, nums.length-1);
        }

        // 将数组拆成2个部分
        // 4 5 6 7 0 1 2 => [4 5 6 7] [0 1 2]
        // 3 1 ==> [3] [1]
        int leftIndex = binarySearch(nums, target, 0, randomK);
        if(leftIndex != -1) {
            return leftIndex;
        }

        // 右边寻找
        int rightIndex = binarySearch(nums, target, randomK+1, nums.length-1);
        if(rightIndex != -1) {
            return rightIndex;
        }


        // 如果不存在
        return -1;
    }

    /**
     * 获取随机数
     *
     * 寻找 k > k+i 的位置
     *
     * [4,5,6,7,0,1,2]
     * @param nums 数组
     * @return 变化的长度
     * @since v33
     */
    private int getRandomK(final int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return i;
            }
        }

        // 根据顺序找到即可
        return -1;
    }

    /**
     * 二分查询
     * <p>
     * 备注：ASC
     *
     * @param nums   原始数组
     * @param target 目标值
     * @return 结果
     * @since v33
     */
    private static int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = (high+low)/2;
            int midVal = nums[mid];

            // 刚好相等
            if (target == midVal) {
                return mid;
            } else if (target > midVal) {
                // 当前信息偏小
                low = mid+1;
            } else {
                // 数据偏大
                high = mid-1;
            }
        }

        //NOT FOUND
        return -1;
    }

    public static void main(String[] args) {
        // 4,5,6,7,0,1,2
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();

        System.out.println(search.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search.search(new int[]{3,5,1}, 1));
        System.out.println(search.search(new int[]{3,1}, 1));
    }


    /**
     * 如何处理好旋转？？
     *
     *  [0,1,2,4,5,6,7] + 3 ==》 [4,5,6,7,0,1,2].
     *
     *  [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     *
     *  两种解题方式：
     *
     *  （1）当前两个数组处理
     *  （2）还原数组处理
     *
     * @param nums
     * @param k
     */
    @Deprecated
    private static void offsetArray(int nums[], int k) {
        int len = nums.length;
        if(len == 1 || k == len-1 || k == 0) {
            return;
        }

        // 什么是旋转呢？
        // 使用临时数组 保存前 K 个内容
        int[] numTemp = new int[k];
        int tempSize = 0;
        // 首先临时保存 后面 k 个 的内容
        for(int i = len-k; i < len; i++) {
            numTemp[tempSize++] = nums[i];
        }

        // 从后向前平移
        for(int i = len-k-1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }

        // 将临时的信息设置到最后面
        for(int i = 0; i < k; i++) {
            nums[i] = numTemp[i];
        }
    }


}