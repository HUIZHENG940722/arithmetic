package com.hz.arithmetic.lettcode.test75;

/**
 * 子数组最大平均数I
 *
 * @author zhenghui
 * @since 2023/9/15
 */
public class Solution643 {

  public double findMaxAverage(int[] nums, int k) {
    // 利用滑动窗口算法，初始值左边界为0，右边界为k-1，整个子数组的和为sum
    int len = nums.length, left = 0, right = k - 1, sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    double max = sum / (k * 1.0);
    while (right < len - 1) {
      sum = sum - nums[left++] + nums[++right];
      max = Math.max(sum / (k * 1.0), max);
    }
    return max;
  }
}
