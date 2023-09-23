package com.hz.arithmetic.lettcode.test75;

import java.util.Arrays;

/**
 * 只出现一次的数字
 *
 * @author zhenghui
 * @since 2023/9/23
 */
public class Solution136 {

  /**
   * 可以有几种方法：记录数字法、异或运算
   *
   * @param nums
   * @return
   */
  public int singleNumber(int[] nums) {
    Arrays.sort(nums);
    int len = nums.length, index = 0;
    for (int i = 0; i < len - 1; i = i + 2) {
      if (nums[i] != nums[i + 1]) {
        return nums[i];
      }
    }
    return nums[len - 1];
  }

  public int singleNumber1(int[] nums) {
    int result = nums[0], len = nums.length;
    for (int i = 1; i < len; i++) {
      result ^= nums[i];
    }
    return result;
  }

  public int singleNumber2(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }
}
