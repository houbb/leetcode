package com.github.houbb.leetcode.F100T200;

public class T165_CompareVersionNumbers {

    /**
     * 直接根据 . 拆分，对比即可
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int minLen = Math.min(nums1.length, nums2.length);

        for(int i = 0; i < minLen; i++) {
            int one = Integer.parseInt(nums1[i]);
            int two = Integer.parseInt(nums2[i]);

            if(one > two) {
                return 1;
            }
            if(one < two) {
                return -1;
            }
        }


        // 大小一样，比较长度
        if(nums1.length > nums2.length) {
            int sum = calcSum(minLen, nums1);
            if(sum > 0) {
                return 1;
            }
        }
        if(nums1.length < nums2.length) {
            int sum = calcSum(minLen, nums2);
            if(sum > 0) {
                return -1;
            }
        }

        // 其他全部相同
        return 0;
    }

    // 处理 0.000 这种情况
    private int calcSum(int minLen, String[] nums) {

        int sum = 0;

        for(int i = minLen; i < nums.length; i++) {
            sum += Integer.parseInt(nums[i]);
        }

        return sum;
    }

}
