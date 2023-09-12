package com.hz.arithmetic.lettcode.test75;

/**
 * 最大连续1的个数
 *
 * @author zhenghui
 * @since 2023/9/11
 */
public class Solution1004 {

  public int longestOnes(int[] nums, int k) {
    int len = nums.length, i = 0, j = 0, result = 0, distance = k;
    while (j < len) {
      int valJ = nums[j];
      if (valJ == 1) {
        j++;
      } else {
        if (distance > 0) {
          distance--;
          j++;
        } else {
          int valI = nums[i];
          if (valI == 1) {
            result = Math.max(result, j - i);
            while (i < len && nums[i] == 1) {
              i++;
            }
          } else {
            i++;
            j++;
          }
        }
      }
    }
    result = Math.max(result, j - i);
    return result;
  }
}
