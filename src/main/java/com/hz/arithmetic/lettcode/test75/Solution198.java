package com.hz.arithmetic.lettcode.test75;

/**
 * 打家劫舍
 *
 * @author zhenghui
 * @since 2023/9/11
 */
public class Solution198 {

  /**
   * 第N个房间进行打劫
   *
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
    int len = nums.length;
    return rob(nums, len - 1);
  }

  private int rob(int[] nums, int index) {
    int len = nums.length;
    if (len <= 2) {
      return len == 1 ? nums[0] : Math.max(nums[0], nums[1]);
    }
    if (index >= len) {
      return Math.max(rob(nums, len - 3) + nums[len - 1], rob(nums, len - 2));
    }
    return Math.max(rob(nums, index - 2) + nums[index], rob(nums, index - 1));
  }

  public int rob2(int[] nums) {
    int len = nums.length;
    if (len <= 2) {
      return len == 1 ? nums[0] : Math.max(nums[0], nums[1]);
    }
    int[] dp = new int[len];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < len; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[len - 1];
  }
}
