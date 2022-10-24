package com.ethan.course.lettcode.huawei;

import java.util.Arrays;

/**
 * @Author zhenghui
 * @Description 两数之和
 * @Date 2022/10/16
 */
public class Solution1 {

    /**
     * 初始化函数
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] ints = twoSum(nums, 6);
        System.out.println(ints);
    }


    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] results = new int[2];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    results[0] = i;
                    results[1] = j;
                    return results;
                }
            }
        }
        return null;
    }
}
