package com.hz.arithmetic.lettcode.test75;

/**
 * 移动零
 *
 * @author zhenghui
 * @since 2023/9/8
 */
public class Solution283 {
  public void moveZeroes(int[] nums) {
    int i = 0, j=0, len = nums.length;
    while (i<len) {
      int val = nums[i];
      if (val!=0) {
        nums[j++]=nums[i++];
      } else {
        i++;
      }
    }
    while (j<len) {
      nums[j++] = 0;
    }
  }
}
