package com.github.houbb.leetcode.F000T100;

import java.util.Arrays;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T031_NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};

        new T031_NextPermutation().nextPermutation(nums);
//        reverse(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *

     1. 如何判断有木有下一个呢？只要存在a[i-1] < a[i]的升序结构，就有，而且我们应该从右往左找
     2. 当发现a[i-1] < a[i]的结构时，从在[i, ∞]中找到最接近a[i-1]并且又大于a[i-1]的数字，由于降序，从右往左遍历即可得到k
     然后交换a[i-1]与a[k]，然后对[i, ∞]排序即可，排序只需要首尾不停交换即可，因为已经是降序 上面说的很抽象，还是需要拿一些例子思考才行，比如[0,5,4,3,2,1]，下一个是[1,0,2,3,4,5]
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //fast-return
        int len = nums.length;
        if(len == 1) {
            return;
        }

        // 倒叙查看
        //123=>132
        //12233
        int i = 0;
        for(i = len-1; i > 0; i--) {
            // 小于
            if(nums[i-1] < nums[i]) {
                // 记录索引
                break;
            }
        }

        //132  从右向左边，找到第一个小于等于 index 的数 && > index-1
        //从 index=>len 找到大于 n
        // 存在
        if(i > 0) {
            int preVal = nums[i-1];
            int indexVal = nums[i];
            int k;
            for(k = len-1; k > i; k--) {
                if(nums[k] > preVal && nums[k] <= indexVal) {
                    // 跳出循环
                    break;
                }
            }
            // 交换 k 和 i-1
            swap(nums, k, i-1);
        }

        // 将 i => len-1 执行排序
        reverse(nums, i, nums.length-1);
    }



    /**
     * 交换
     * @param nums 数组
     * @param one 第一个下标
     * @param two 第二个下标
     */
    private static void swap(int[] nums, int one, int two) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }

    /**
     * 逆序
     * @param nums 数组
     * @param startIndex 开始
     * @param endIndex 结束
     */
    private static void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(nums, startIndex++, endIndex--);
        }
    }


    private static void reverse(int[] nums) {
        int len = nums.length;

        for(int i = 0; i < len / 2; i++) {
            swap(nums, i, len-1-i);
        }
    }

    /**
     *
     1 <= nums.length <= 100
     0 <= nums[i] <= 100

     [1,3,2]==》213

     312
     必须 in place 交换，而且使用固定的额外空间
     * @param nums
     */
    public void nextPermutationError(int[] nums) {
        //fast-return
        int len = nums.length;
        if(len == 1) {
            return;
        }

        // 倒叙查看
        //123=>132
        //12233
        for(int i = len-1; i > 0; i--) {
            int current = nums[i];
            int pre = nums[i-1];

            //如果 pre < current 交换
            //132==>312   213
            //
            if(pre < current) {
                //交换
                swap(nums, i, i-1);
                return;
            }
        }

        // 如果不存在，直接逆序
        reverse(nums);
    }
}
