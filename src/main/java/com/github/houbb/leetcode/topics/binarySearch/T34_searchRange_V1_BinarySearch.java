package com.github.houbb.leetcode.topics.binarySearch;

public class T34_searchRange_V1_BinarySearch {

    public static void main(String[] args) {
        T34_searchRange_V1_BinarySearch binarySearch = new T34_searchRange_V1_BinarySearch();
        int[] nums = new int[]{1};
        System.out.println(binarySearch.searchRange(nums, 1));
    }
    public int[] searchRange(int[] nums, int target) {
        // 左右遍历，找到结果
        int midIndex = binarySearch(nums, target);

        // 左边
        int left = midIndex;
        if(left != -1) {
            while (left > 0 && nums[left] == nums[left-1]){
                left--;
            }
        }

        // 右边
        int right = midIndex;
        if(right != -1) {
            while (right < nums.length - 1 && nums[right] == nums[right+1]){
                right++;
            }
        }

        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                // 太大 去左边
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return -1;
    }


}
