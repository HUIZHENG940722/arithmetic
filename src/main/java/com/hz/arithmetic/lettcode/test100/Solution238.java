package com.hz.arithmetic.lettcode.test100;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 * @author zhenghui
 * @since 2023/11/25
 */
public class Solution238 {

  /**
   * 左右乘积列表
   *
   * @param nums
   * @return
   */
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length, leftNum = 1, rightNum = 1;
    int[] result = new int[len];
    Arrays.fill(result, 1);
    for (int i = 1; i < len; i++) {
      leftNum *= nums[i - 1];
      result[i] *= leftNum;
      rightNum *= nums[len - i];
      result[len - i - 1] *= rightNum;
    }
    return result;
  }
}
