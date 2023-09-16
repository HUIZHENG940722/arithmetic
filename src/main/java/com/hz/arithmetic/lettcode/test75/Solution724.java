package com.hz.arithmetic.lettcode.test75;

/**
 * 寻找数组的中心下标
 *
 * @author zhenghui
 * @since 2023/9/16
 */
public class Solution724 {

  public int pivotIndex(int[] nums) {
    int sum = 0, len = nums.length, ans = 0;
    for (int num : nums) {
      sum += num;
    }
    for (int i = 0; i < len; i++) {
      if (ans * 2 + nums[i] == sum) {
        return i;
      }
      ans += nums[i];
    }
    return -1;
  }
}
