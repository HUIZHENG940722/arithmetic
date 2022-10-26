package com.ethan.course.lettcode.huawei;

/**
 * @Author zhenghui
 * @Description 寻找两个正序数组中的中位数
 * @Date 2022/10/26
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int m_n = m + n;
        int[] results = new int[m_n];
        int i = 0, j = 0, t = 0;
        for (; i < m && j < n; t++) {
            if (nums1[i] <= nums2[j]) {
                results[t] = nums1[i];
                i++;
            } else {
                results[t] = nums2[j];
                j++;
            }
        }
        for (; i < m; i++, t++) {
            results[t] = nums1[i];
        }
        for (; j < n; j++, t++) {
            results[t] = nums2[j];
        }
        double result;
        if (m_n % 2 == 0) {
            result = (results[m_n / 2] + results[m_n / 2 - 1]) / 2.0;
        } else {
            result = results[m_n / 2];
        }
        return result;
    }
}
