package com.hz.arithmetic.lettcode.test75;

/**
 * 寻找峰值
 *
 * @author zhenghui
 * @since 2023/10/8
 */
public class Solution162 {

  /**
   * 利用遍历算法
   *
   * @param nums
   * @return
   */
  public int findPeakElement1(int[] nums) {
    int max = Integer.MIN_VALUE, result = -1, len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] > max) {
        result = i;
        max = nums[i];
      }
    }
    return result;
  }

  public int findPeakElement(int[] nums) {
    int len = nums.length;
    int[] flag = new int[len];
    for (int i = 0; i < len; i++) {
      flag[i] = i;
    }
    int left;
    if ((len - 1) % 2 == 0) {
      left = (len - 1) / 2;
    } else {
      left = (len - 1) / 2 - 1;
    }
    int index = len - 1;
    while (index >= left) {
      int j = index;
      while (j >= 1) {
        int p, tmp = 0;
        if (j % 2 == 0) {
          p = j / 2 - 1;
        } else {
          p = j / 2;
        }
        if (nums[j] > nums[p]) {
          tmp = nums[j];
          nums[j] = nums[p];
          nums[p] = tmp;
          tmp = flag[j];
          flag[j] = flag[p];
          flag[p] = tmp;
        }
        j = p;
      }
      index--;
    }
    return flag[0];
  }
}
