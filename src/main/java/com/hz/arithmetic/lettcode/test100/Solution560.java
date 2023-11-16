package com.hz.arithmetic.lettcode.test100;

/**
 * 和为k的子数组
 *
 * @author zhenghui
 * @since 2023/11/15
 */
public class Solution560 {

  public int subarraySum(int[] nums, int k) {
    int len = nums.length, result = 0;
    for (int i = 0; i < len; i++) {
      int sum = 0, j = i;
      while (j < len) {
        sum = sum + nums[j];
        if (sum == k) {
          result++;
        }
        j++;
      }
    }
    return result;
  }
}
