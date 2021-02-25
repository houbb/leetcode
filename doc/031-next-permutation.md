https://leetcode.com/problems/next-permutation/

Implement next permutation（排列，交换）, which rearranges numbers into the lexicographically（词典上） next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

Example 4:

Input: nums = [1]
Output: [1]

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100
    
# 理解

这一题最难的在于对于要求的理解，看完题目一脸？？，看完例子，依然如此。

## 引用一句小伙伴的例子

题干的意思是：找出这个数组排序出的所有数中，刚好比当前数大的那个数

比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，排序后，比123大的那个数 也就是132

如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数（比它大的不存在），那么就返回1，2，3排序后所有数中最小的那个，也就是1，2，3 -> [1,2,3]

## 解题思路

暴力法：

穷举所有的解，然后选择一个排序，然后选择一个刚好比当前值大的。

如果不存在，则选择最小的。

问题：时间复杂度非常高。

其他思路：

-- 

大小的概念：

权重。数组中的数组，实际上都是一个序列：n1 n2 n3...nx

权重为10，n1*10^x + n2*10^x-1 + ... + nx*1

如何找出一个数，刚好比当前的序列大呢（比当前的数大，但是是最小的那一个）？

个人理解，是不看第一个数字，然后从第二个位置看起，找到

12345 ==》 12354

从最后一位，开始向前遍历，如果元素大于前一个元素，交换位置即可。

当然如果遇到了倒霉催的，比如 54321 本来就是最大序列，如何得到最小序列呢？

那就是数组反转？