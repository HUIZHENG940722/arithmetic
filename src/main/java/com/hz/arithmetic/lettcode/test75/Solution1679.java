package com.hz.arithmetic.lettcode.test75;

import java.util.Arrays;

/**
 * K和数对的最大数目
 *
 * @author zhenghui
 * @since 2023/9/11
 */
public class Solution1679 {

  public int maxOperations(int[] nums, int k) {
    int len = nums.length, i = 0, j = len - 1, result = 0;
    Arrays.sort(nums);
    while (i < j) {
      if (nums[i] + nums[j] > k) {
        j--;
      } else if (nums[i] + nums[j] == k) {
        i++;
        j--;
        result++;
      } else {
        i++;
      }
    }
    return result;
  }
}
