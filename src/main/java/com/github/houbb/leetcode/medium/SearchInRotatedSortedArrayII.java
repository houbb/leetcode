package com.github.houbb.leetcode.medium;

/**
 * 优化思路：直接根据 k 分割数组，因为数组的复制也是非常耗时的。
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class SearchInRotatedSortedArrayII {

    /**
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     *
     * 【优化思路】
     *
     * 如果只是 contains，可以先判断一下数组的最大值和最小值。
     *
     * 如果不在，肯定不存在，
     *
     * 但是因爲這題的測試 case 太少，所以沒意思。
     *
     * @param nums 数组
     * @param target 目标
     * @return 是否存在
     */
    public boolean search(int[] nums, int target) {
        // 没有旋转，或者全部旋转
        int randomK = getRandomK(nums);
        if(-1 == randomK) {
            return binarySearch(nums, target, 0, nums.length-1) > -1;
        }

        // 将数组拆成2个部分
        int leftIndex = binarySearch(nums, target, 0, randomK);
        if(leftIndex != -1) {
            return true;
        }

        // 右边寻找
        int rightIndex = binarySearch(nums, target, randomK+1, nums.length-1);
        if(rightIndex != -1) {
            return true;
        }


        // 如果不存在
        return false;
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
        SearchInRotatedSortedArrayII search = new SearchInRotatedSortedArrayII();
        System.out.println(search.search(new int[]{2,5,6,0,0,1,2}, 0));
    }


}