package com.hz.arithmetic.lettcode.test100;

/**
 * 滑动窗口最大值
 *
 * @author zhenghui
 * @since 2023/11/16
 */
public class Solution239 {

  /**
   * 穷举超出时间复杂度
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow1(int[] nums, int k) {
    int len = nums.length;
    int[] result = new int[len - k + 1];
    for (int i = 0; i < len - k + 1; i++) {
      int value = nums[i];
      for (int j = i; j < k + i; j++) {
        value = Math.max(value, nums[j]);
      }
      result[i] = value;
    }
    return result;
  }

  public static int[] maxSlidingWindow2(int[] nums, int k) {
    int len = nums.length, i = 0, j = k - 1, maxIndex = -1;
    int[] result = new int[len - k + 1];
    while (j < len) {
      if (maxIndex < i || maxIndex > j) {
        int max = nums[i];
        maxIndex = i;
        for (int t = i; t <= j; t++) {
          if (nums[t] > max) {
            maxIndex = t;
          }
        }
      }
      result[i] = nums[maxIndex];
      i++;
      j++;
      if (j < len && nums[j] > nums[maxIndex]) {
        maxIndex = j;
      }
    }
    return result;
  }


  public int[] maxSlidingWindow(int[] nums, int k) {
    return new int[0];
  }
}
