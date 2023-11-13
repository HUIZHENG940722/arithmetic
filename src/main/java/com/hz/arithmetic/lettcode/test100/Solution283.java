package com.hz.arithmetic.lettcode.test100;

/**
 * 移动零
 *
 * @author zhenghui
 * @since 2023/11/12
 */
public class Solution283 {

  public void moveZeroes(int[] nums) {
    int len = nums.length, i = 0, j = 0;
    for (; j < len; j++) {
      if (nums[j] != 0) {
        nums[i++] = nums[j];
      }
    }
    while (i < len) {
      nums[i++] = 0;
    }
  }
}
