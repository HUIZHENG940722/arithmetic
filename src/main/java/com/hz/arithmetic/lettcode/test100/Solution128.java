package com.hz.arithmetic.lettcode.test100;

import java.util.Arrays;

/**
 * 最长连续序列
 *
 * @author zhenghui
 * @since 2023/11/12
 */
public class Solution128 {

  public int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int index = 0, len = nums.length, result = 0;
    while (index < len) {
      int sum = 1;
      while (index + 1 < len && (nums[index] + 1 == nums[index + 1] || nums[index] == nums[index
          + 1])) {
        if (nums[index] + 1 == nums[index + 1]) {
          sum++;
        }
        index++;
      }
      index++;
      result = Math.max(result, sum);
    }
    return result;
  }
}
