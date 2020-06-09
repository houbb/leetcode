package com.github.houbb.leetcode;

import java.util.Arrays;

/**
 * 计算两个已经排序后的数组的中位数
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class MedianOfTwoSortedArrays {

    /**
     * 最简单的算法：
     *
     * （1）将两个数组合并成为一个。
     * （2）重新排序
     * （3）取中间的元素
     *
     * 效果：
     * Runtime: 3 ms, faster than 37.05% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 40.7 MB, less than 33.92% of Java online submissions for Median of Two Sorted Arrays.
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 结果
     * @since v1
     * @date 2020-6-9 17:47:18
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int[] results = new int[nums1.length+nums2.length];

        // 1. 初始化
        System.arraycopy(nums1, 0, results, 0, nums1.length);
        System.arraycopy(nums2, 0, results, nums1.length, nums2.length);

        //2. 排序
        Arrays.sort(results);

        //3. 计算结果
        // 位运算替代除法
        int mod = totalSize % 2;
        int midIndex = totalSize >> 1;

        if(mod == 1) {
            return results[midIndex];
        }

        int one = results[midIndex-1];
        int two = results[midIndex];
        double sum = one+two;
        return sum / 2;
    }

    /**
     * 官方核心解法
     *
     * 将 A/B 拆分，然后让其满足中位数的条件。
     *
     * 拆分结果：
     *
     * <pre>
     *       left_part          |        right_part
     * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     * </pre>
     *
     * 核心目标：
     *
     * (1) i + j == m - i + n - j (或者: m - i + n - j + 1) 即让左半边元素数量等于与右半边
     *     对于 n >= m 的情况，我们只需要让 : i = 0 ~ m, j = (m + n + 1)/2 - i
     *
     * 简单推导过程如下：
     * <pre>
     *      i + j = m - i + n - j + 1;  // 两种 case，选择这一种说明
     *      2(i+j) = m+n+1; // 移项
     *      i+j = (m+n+1)/2;
     *      j = (m+n+1)/2 - i;
     * </pre>
     *
     * (2) B[j-1] <= A[i] 并且 A[i-1] <= B[j]  即让左边最大元素小于右边最小元素
     *
     * 此处为了保证 j >=0 ，所以必须 n >= m
     * 保证 B.length >= A.length;
     *
     * ps: B[j-1] 肯定是小于右侧所有的 B; 同理 A[i-1] 也小于所有右侧元素。故只需要满足(2) 即可。
     *
     * 【中位数】
     * max(A[i-1], B[j-1]) ( m + n 是奇数)
     * 或者 (max(A[i-1], B[j-1]) + min(A[i], B[j]))/2 ( m + n 是偶数)
     *
     * 【性能】
     * Runtime: 2 ms, faster than 99.81% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 40.2 MB, less than 91.06% of Java online submissions for Median of Two Sorted Arrays.
     *
     * 【感受】
     * 这种算法需要对中位数理解特别深，基本属于难以超越的解法。
     * @param nums1 列表1
     * @param nums2 列表 2
     * @return 结果
     * @since v2
     * @date 2020-6-9 19:30:41
     */
    public double findMedianLeetCode(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] A = nums1;
        int[] B = nums2;

        // 如果 A 较大，那么直接反过来处理，保证 n >= m
        if(m > n) {
            m = nums2.length;
            n = nums1.length;
            A = nums2;
            B = nums1;
        }

        // 初始化变量
        int iMin = 0;
        int iMax = m;
        int iHalf = (m + n + 1)/2;

        int i, j;
        int maxOfLeft, minOfRight;

        while (iMin <= iMax) {
            i = (iMin+iMax)/2;
            j = iHalf - i;

            if(i < m && B[j-1] > A[i]) {
                iMin++;
            } else if(i > 0 && A[i-1] > B[j]) {
                iMax--;
            } else {
                // GOT IT（主要是边缘值的处理）
                if(i == 0) {
                    // A 左边为空
                    maxOfLeft = B[j-1];
                } else if(j == 0) {
                    // B 左边为空
                    maxOfLeft = A[i-1];
                } else {
                    // 左边较大的一个
                    maxOfLeft = Math.max(A[i-1], B[j-1]);
                }

                // 奇数
                if((m+n) % 2 == 1) {
                    return maxOfLeft;
                }

                // 偶数
                if(i == m) {
                    // 最右边
                    minOfRight = B[j];
                } else if(j == n) {
                    minOfRight = A[i];
                } else {
                    minOfRight = Math.min(B[j], A[i]);
                }

                return (minOfRight+maxOfLeft) / 2.0;
            }
        }

        return 0.0;
    }


    // 二分法

}
