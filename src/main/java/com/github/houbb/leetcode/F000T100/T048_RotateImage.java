package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.util.MultiArrays;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T048_RotateImage {

    public static void main(String[] args) {
        T048_RotateImage rotateImage = new T048_RotateImage();
        int[][] one = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotateImage.rotate(one);
        MultiArrays.show(one);
    }

    /**
     * 旋转图片
     *
     * 【解题思路】
     * 因为旋转需要 in-place，所以我们一次需要变换 4 个元素的位置，避免丢失。
     *
     * 我们换一种思路：
     * （1）一次保留一权，最外圈。
     * 圈数 = n / 2
     *
     * （2）循环最外圈，然后依次向内
     * 内圈的左右，上线都是-2的。
     *
     * @param matrix 矩阵
     */
    public void rotate(int[][] matrix) {
        if(matrix.length == 1) {
            return;
        }

        int times = matrix.length/2;
        for(int i = 0; i < times; i++) {
            // 旋转这一圈的数据
            // 临时保存上面的数据
            int[] tempTops = getRows(matrix, i, i);
            int[] tempLeft = getColumns(matrix, i,  i);
            int[] tempRight = getColumns(matrix, i, matrix.length-1 - i);
            int[] tempBottom = getRows(matrix, i, matrix.length-1 - i);


            //1. 左边=》上边
            setRows(matrix, i, i, tempLeft);

            //2. 上边=》右
            setColumns(matrix, i, matrix.length-1-i, tempTops);

            //3. 右边=》下
            setRows(matrix, i, matrix.length-1-i, tempRight);

            //4. 下=》左
            setColumns(matrix, i, i, tempBottom);
        }
    }

    /**
     * 获取列数据
     * @param nums
     * @param times
     * @param columnIndex
     * @return
     */
    private int[] getColumns(int[][] nums, int times, int columnIndex) {
        int len = nums.length;
        int[] results = new int[len - 2*times];
        int size = 0;

        for(int i = times; i < len - times; i++) {
            for(int j = times; j < len-times; j++) {
                if(j == columnIndex) {
                    results[size++] = nums[i][j];
                }
            }
        }
        return results;
    }

    /**
     * 设置列数据
     * @param nums
     * @param times
     * @param columnIndex
     * @return
     */
    private void setColumns(int[][] nums, int times, int columnIndex,
                            int[] tempList) {
        int len = nums.length;
        int size = 0;

        for(int i = times; i < len - times; i++) {
            for(int j = times; j < len-times; j++) {
                if(j == columnIndex) {
                    nums[i][j] = tempList[size++];
                }
            }
        }
    }

    /**
     * 获取行
     * @param nums 矩阵
     * @param times 圈数
     * @param rowIndex 行
     * @return  结果
     */
    private int[] getRows(int[][] nums, int times, int rowIndex) {
        int len = nums.length;
        int[] results = new int[len - 2*times];

        int[] rows = nums[rowIndex];
        int size = 0;
        for(int i = times; i < len-times; i++) {
            results[size++] = rows[i];
        }
        return results;
    }

    /**
     * 设置行，需要把顺序颠倒过来
     * @param nums 矩阵
     * @param times 圈数
     * @param rowIndex 行
     */
    private void setRows(int[][] nums, int times, int rowIndex, int[] tempList) {
        int len = nums.length;

        int index = tempList.length-1;
        for(int i = times; i < len-times; i++) {
            nums[rowIndex][i] = tempList[index--];
        }
    }

}
