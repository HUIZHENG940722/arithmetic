package com.hz.arithmetic.lettcode.test75;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 * @author zhenghui
 * @since 2023/9/7
 */
public class Solution238 {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4};
    int[] ints = productExceptSelf(nums);
    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }

  public static int[] productExceptSelf(int[] nums) {
    int len = nums.length, left = 1, right = 1;
    int[] result = new int[len];
    Arrays.fill(result, 1);
    for (int i = 1; i < len; i++) {
      left *= nums[i - 1];
      result[i] *= left;
      right *= nums[len - i];
      result[len - 1 - i] *= right;
    }
    return result;
  }
}
